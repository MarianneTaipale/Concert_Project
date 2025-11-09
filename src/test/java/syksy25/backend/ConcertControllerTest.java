package syksy25.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import syksy25.backend.web.ConcertController;

@SpringBootTest
public class ConcertControllerTest {

    @Autowired
    private ConcertController controller;

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
    
}
