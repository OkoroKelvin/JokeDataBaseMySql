package com.transition.jokemysql.service;

import com.transition.jokemysql.data.inputDto.JokeInputDto;
import com.transition.jokemysql.data.model.Comment;
import com.transition.jokemysql.data.model.Joke;
import com.transition.jokemysql.data.outputDto.JokeResponseDto;
import com.transition.jokemysql.data.outputDto.JokeWithCommentDto;
import com.transition.jokemysql.data.outputDto.JokeWithCommentResponseDto;
import com.transition.jokemysql.data.outputDto.Status;
import com.transition.jokemysql.data.repository.CommentRepository;
import com.transition.jokemysql.data.repository.JokeRepository;
import com.transition.jokemysql.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JokeServiceImpl implements  JokeService {

    @Autowired
    JokeRepository jokeRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentService commentService;

    @Override
    public JokeResponseDto saveJoke(JokeInputDto jokeInput) {
        try {
            Joke joke = new Joke();
            joke.setContent(jokeInput.getContent());
            joke.setCreatedDate(LocalDateTime.now());
            joke.setLikes(0);
            Joke savedJoke = jokeRepository.save(joke);
            return new JokeResponseDto(Status.SUCCESS,savedJoke);
        } catch (Exception e) {
            return new JokeResponseDto(Status.INTERNAL_ERROR);
        }
    }



    public Joke findJokeById(Integer jokeId) {
        Optional<Joke> jokeRepo = jokeRepository.findById(jokeId);
        return jokeRepo.get();
    }

    @Override
    public JokeResponseDto removeJoke(Integer jokeId) {
        try{
            Joke foundJoke = findJokeById(jokeId);
            jokeRepository.delete(foundJoke);
            return new JokeResponseDto(Status.SUCCESS);
        }catch (Exception e) {
            return new JokeResponseDto(Status.INTERNAL_ERROR);
        }
    }

    @Override
    public JokeResponseDto likeJoke(Integer jokeId) {
        Joke foundJoke = findJokeById(jokeId);
        foundJoke.like();
        Joke savedJoke = jokeRepository.save(foundJoke);
        return new JokeResponseDto(savedJoke,Status.SUCCESS);
    }

    @Override
    public JokeResponseDto findAllJokesByBestToLeastLikes() {
        List<Joke> jokes = jokeRepository.findAllJokesFromBestToLeastLikes();
        return new JokeResponseDto(jokes,Status.SUCCESS);
    }

    @Override
    public JokeResponseDto findAllJokesByLeastToBestLikes() {
        List<Joke> jokes = jokeRepository.findAllJokesFromLeastToBestLikes();
        return new JokeResponseDto(jokes,Status.SUCCESS);
    }

   @Override
    public JokeWithCommentResponseDto findAllJokesWithItsComment() {
        List<Joke> jokes = jokeRepository.findAll();
        List<JokeWithCommentDto> jokeWithComments = new ArrayList<>();

        if(jokes==null){
            throw  new ApplicationException("No Joke available");
        }

        jokes.stream().forEach((joke) -> {
            JokeWithCommentDto jokeWithComment = new JokeWithCommentDto();
            List<Comment> comments = commentRepository.findCommentByJokeId(joke.getId());
            jokeWithComment.setJoke(joke);


            if(comments != null){
                jokeWithComment.setComment(comments);
                jokeWithComments.add(jokeWithComment);
            }else{
                jokeWithComments.add(jokeWithComment);
            }
        }
        );
        return new JokeWithCommentResponseDto(jokeWithComments,Status.SUCCESS);
   }
}
