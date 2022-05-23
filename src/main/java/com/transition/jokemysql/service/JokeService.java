package com.transition.jokemysql.service;

import com.transition.jokemysql.data.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeService {
    @Autowired
    private JokeRepository jokeRepository;

}
