package syksy25.backend.web;

import org.springframework.stereotype.Controller;
import syksy25.backend.repos.ArtistRepository;

@Controller
public class ArtistController {

    private final ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

}
