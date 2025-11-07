package syksy25.backend.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{
    List<Artist> findByName(String name);
}
