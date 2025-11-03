package syksy25.backend.repos;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

}
