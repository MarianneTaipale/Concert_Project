package syksy25.backend.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import syksy.backend.dto.ConcertDto;
import syksy25.backend.domain.Artist;
import syksy25.backend.domain.Concert;
import syksy25.backend.domain.Venue;
import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.ConcertRepository;
import syksy25.backend.repos.VenueRepository;

@RestController
public class ConcertRestController {

    private final ConcertRepository repository;
    private final ArtistRepository artistRepository;
    private final VenueRepository venueRepository;

    public ConcertRestController(ConcertRepository repository, ArtistRepository artistRepository,
            VenueRepository venueRepository) {
        this.repository = repository;
        this.artistRepository = artistRepository;
        this.venueRepository = venueRepository;
    }

    // näytä konserttien tiedot
    @RequestMapping(value = "/api/concerts", method = RequestMethod.GET)
    public @ResponseBody List<Concert> concertListRest() {
        return (List<Concert>) repository.findAll();
    }

    // etsi konsertti
    @RequestMapping(value = "/api/concerts/{id}", method = RequestMethod.GET)
    public @ResponseBody Concert findConcertRest(@PathVariable("id") Long concertId) {
        return repository.findById(concertId).orElse(null);
    }

    // lisää konsertti
    @PostMapping
    public Concert addConcert(@RequestBody Concert concert) {

        Artist artist = concert.getArtist();
        if (artist.getId() == null)
            artistRepository.save(artist);

        Venue venue = concert.getVenue();
        if (venue.getId() == null)
            venueRepository.save(venue);

        return repository.save(concert);
    }

}
