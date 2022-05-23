package com.transition.jokemysql.service;

import com.transition.jokemysql.data.model.Joke;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    JokeService jokeService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test That Joke Can Be Created")
    void testThatJokeCanBeCreated(){
        Joke joke = new Joke();
        assertNotNull(joke);
    }


}