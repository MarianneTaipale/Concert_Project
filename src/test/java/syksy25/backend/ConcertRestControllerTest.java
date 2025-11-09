package syksy25.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import syksy25.backend.web.ConcertRestController;

@SpringBootTest
public class ConcertRestControllerTest {

    @Autowired
    private ConcertRestController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
