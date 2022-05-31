package com.transition.jokemysql.controller;


import com.transition.jokemysql.data.inputDto.CommentInputDto;
import com.transition.jokemysql.data.inputDto.JokeCommentInputDto;
import com.transition.jokemysql.data.inputDto.JokeInputDto;
import com.transition.jokemysql.data.model.Joke;
import com.transition.jokemysql.data.outputDto.CommentResponseDto;
import com.transition.jokemysql.data.outputDto.JokeCompositeResponseDto;
import com.transition.jokemysql.data.outputDto.JokeResponseDto;
import com.transition.jokemysql.data.repository.JokeRepository;
import com.transition.jokemysql.service.CommentService;
import com.transition.jokemysql.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3002" +
        "/")
@RestController
@RequestMapping("/api/v1/")
public class JokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private JokeService jokeService;

    @Autowired
    private CommentService commentService;



    @GetMapping("/jokes")
    public JokeResponseDto getAllJokeOnly(){
        return jokeService.findAllJokes();
    }

    @PostMapping("/jokes")
    public JokeResponseDto createJoke(@RequestBody JokeInputDto jokeInputDto)  {
        return jokeService.saveJoke(jokeInputDto);
    }

    @PostMapping("/jokes/{id}")
    public CommentResponseDto createJokeComment(@PathVariable Integer id,@RequestBody JokeCommentInputDto jokeInputDto)  {
        return commentService.createJokeComment(id,jokeInputDto);
    }


    @DeleteMapping("/jokes/{id}")
    public JokeResponseDto deleteJoke(@PathVariable Integer id)  {
        return jokeService.removeJoke(id);
    }


    @GetMapping("/jokes/{id}")
    public JokeResponseDto getJokeById(@PathVariable Integer id){
        return jokeService.findJokeByItsId(id);
    }

    @GetMapping("/jokes/most")
    public JokeResponseDto getJokesByMostLike(){
        return jokeService.findAllJokesByBestToLeastLikes();
    }

    @GetMapping("/jokes/least")
    public JokeResponseDto getJokesByLeastLike(){
        return jokeService.findAllJokesByLeastToBestLikes();
    }

    
    @PatchMapping("jokes/{id}")
    public JokeResponseDto likeJoke(@PathVariable Integer id){
        return jokeService.likeJoke(id);
    }

    @GetMapping("jokes/comment/{id}")
    public CommentResponseDto getAllJokeComment(@PathVariable Integer id){
        return commentService.getAllCommentOfAJoke(id);
    }







}
