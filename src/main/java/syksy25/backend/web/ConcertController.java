package syksy25.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.ConcertRepository;
import syksy25.backend.repos.VenueRepository;

@Controller
public class ConcertController {

    private final VenueRepository venueRepository;

    private final ArtistRepository artistRepository;

    private ConcertRepository repository;

    public ConcertController(ArtistRepository artistRepository, VenueRepository venueRepository, ConcertRepository repository) {
        this.artistRepository = artistRepository;
        this.venueRepository = venueRepository;
        this.repository = repository;
    }

    @RequestMapping("/concertlist")
    public String concertList(Model model) {
        model.addAttribute("concerts", repository.findAll());
        return "concertlist";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

}
