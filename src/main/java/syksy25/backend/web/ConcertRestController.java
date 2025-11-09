package syksy25.backend.web;

import org.springframework.web.bind.annotation.RestController;

import syksy25.backend.repos.ConcertRepository;

@RestController
public class ConcertRestController {

    private final ConcertRepository repository;

    public ConcertRestController(ConcertRepository repository){
        this.repository = repository;
    }
}
