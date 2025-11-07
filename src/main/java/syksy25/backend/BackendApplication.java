package syksy25.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy25.backend.domain.Artist;
import syksy25.backend.domain.User;
import syksy25.backend.domain.Venue;
import syksy25.backend.repos.ArtistRepository;
import syksy25.backend.repos.UserRepository;
import syksy25.backend.repos.VenueRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner demo( ArtistRepository aRepository, VenueRepository vRepository, UserRepository uRepository){
		return(args) -> {

		Artist artist1 = new Artist("Antti Tuisku");
		Artist artist2 = new Artist("Kaija Koo");

		aRepository.save(artist1);
		aRepository.save(artist2);

		Venue venue1 = new Venue("Hartwall Arena");
		Venue venue2 = new Venue("Avicii Arena");

		vRepository.save(venue1);
		vRepository.save(venue2);

		User user1 = new User("user", "$2a$12$RO/4G1kye1O/fJoQsL0DKeib6kuf2BvIbMGrWPdEgaULGHMQgR1Ay", "USER");
		User user2 = new User("admin", "$2a$12$v9QS/ePsGDKudyiyWJav..ZSOYTnFg3W1LIClfLYJb6xqpoWMcJm6","ADMIN");

		uRepository.save(user1);
		uRepository.save(user2);
		};
	}
}
