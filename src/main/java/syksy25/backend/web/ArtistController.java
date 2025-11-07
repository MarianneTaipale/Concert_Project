package syksy25.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.VenueRepository;

@Controller
public class ArtistController {

    private final VenueRepository venueRepository;

    private final ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository, VenueRepository venueRepository) {
        this.artistRepository = artistRepository;
        this.venueRepository = venueRepository;
    }

    @RequestMapping("/concertlist")
    public String concertList(Model model) {
        model.addAttribute("concerts", artistRepository.findAll());
        return "concertlist";
    }

}
