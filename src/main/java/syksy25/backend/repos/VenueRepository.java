package syksy25.backend.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {
    List<Venue> findByName(String name);
}
