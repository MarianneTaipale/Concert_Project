package syksy25.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import syksy25.backend.domain.Artist;
import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.ConcertRepository;

@Controller
public class ConcertController {

    private final ArtistRepository artistRepository;

    private ConcertRepository cRepository;

    public ConcertController(ConcertRepository cRepository, ArtistRepository artistRepository){
        this.cRepository = cRepository;
        this.artistRepository = artistRepository;
    }

}
