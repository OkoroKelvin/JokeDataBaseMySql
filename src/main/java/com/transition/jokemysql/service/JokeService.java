package com.transition.jokemysql.service;

import com.transition.jokemysql.data.inputDto.JokeInputDto;
import com.transition.jokemysql.data.model.Joke;
import com.transition.jokemysql.data.outputDto.JokeResponseDto;
import com.transition.jokemysql.data.outputDto.JokeWithCommentResponseDto;
import com.transition.jokemysql.data.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface JokeService {
    JokeResponseDto saveJoke(JokeInputDto joke1);

    //JokeResponseDto findJokeById(Integer jokeId);

    JokeResponseDto removeJoke(Integer jokeId);

    JokeResponseDto likeJoke(Integer jokeId);

    JokeResponseDto findAllJokesByBestToLeastLikes();

    JokeResponseDto findAllJokesByLeastToBestLikes();

   JokeWithCommentResponseDto findAllJokesWithItsComment();
}
