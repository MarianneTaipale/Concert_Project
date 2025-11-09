package syksy25.backend;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import syksy25.backend.domain.Artist;
import syksy25.backend.domain.Concert;
import syksy25.backend.domain.Venue;
import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.ConcertRepository;
import syksy25.backend.repos.VenueRepository;

@DataJpaTest
public class ConcertRepositoryTest {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired 
    private VenueRepository venueRepository;

    @Test
    public void deleteConcert(){
        Artist artist = new Artist("Cheek");
        artistRepository.save(artist);

        Venue venue = new Venue("Stadikka");
        venueRepository.save(venue);
        
        LocalDate date = LocalDate.of(2024, 4, 6);

        Concert concert = new Concert(artist,venue,date);

        Concert savedConcert = concertRepository.save(concert);
        Long id = savedConcert.getId();

        assertThat(savedConcert.getId()).isNotNull();
        assertThat(concertRepository.findById(id)).isPresent();

        concertRepository.delete(savedConcert);
        assertThat(concertRepository.findById(id)).isEmpty();
    }
}
