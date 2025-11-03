package syksy25.backend.repos;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.Concert;

public interface ConcertRepository extends CrudRepository<Concert, Long>{

}
