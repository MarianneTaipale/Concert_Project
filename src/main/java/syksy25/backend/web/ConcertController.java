package syksy25.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import syksy25.backend.domain.Artist;
import syksy25.backend.domain.Concert;
import syksy25.backend.domain.Venue;
import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.ConcertRepository;
import syksy25.backend.repos.VenueRepository;

@Controller
public class ConcertController {

    private final VenueRepository venueRepository;

    private final ArtistRepository artistRepository;

    private ConcertRepository repository;

    public ConcertController(ArtistRepository artistRepository, VenueRepository venueRepository,
            ConcertRepository repository) {
        this.artistRepository = artistRepository;
        this.venueRepository = venueRepository;
        this.repository = repository;
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/concertlist";
    }

    @RequestMapping("/concertlist")
    public String concertList(Model model) {
        model.addAttribute("concerts", repository.findAll()); // Haetaan tietokannasta kirjat
        return "concertlist";
    }

    // muokkaa
    @GetMapping("/edit/{id}")
    public String getEditConcertForm(@PathVariable Long id, Model model) {
        Concert concert = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid concert Id:" + id));
        model.addAttribute("concert", concert);
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("venues", venueRepository.findAll());
        return "editconcert";
    }

    // tallenna muutokset
    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute Concert concert) {
        Artist artist = artistRepository.findById(concert.getArtist().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid artist ID"));
        Venue venue = venueRepository.findById(concert.getVenue().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid venue ID"));

        concert.setArtist(artist);
        concert.setVenue(venue);

        repository.save(concert);
        return "redirect:/concertlist";
    }

    // konsertti lomakkeen palautus
    @RequestMapping(value = "/addconcert", method = RequestMethod.GET)
    public String showConcertForm(Model model) {
        model.addAttribute("concert", new Concert());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("venues", venueRepository.findAll());
        return "addconcert";
    }

    // tallentaa uuden konsertin tietokantaan
    @RequestMapping(value = "/addconcert", method = RequestMethod.POST)
    public String saveConcert(@ModelAttribute Concert concert) {
        repository.save(concert);
        return "redirect:/concertlist";
    }

    // poista konsertti
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteConcert(@PathVariable("id") Long concertId) {
        repository.deleteById(concertId);
        return "redirect:/concertlist";
    }
    
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
