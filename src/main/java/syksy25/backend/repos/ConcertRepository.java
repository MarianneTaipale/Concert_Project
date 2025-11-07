package syksy25.backend.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.Concert;

public interface ConcertRepository extends CrudRepository<Concert, Long>{
    
}
