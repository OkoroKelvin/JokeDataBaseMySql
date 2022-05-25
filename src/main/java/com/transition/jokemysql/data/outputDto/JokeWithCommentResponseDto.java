package com.transition.jokemysql.data.outputDto;

import com.transition.jokemysql.data.inputDto.ApiFieldError;
import com.transition.jokemysql.data.inputDto.PageInfo;
import com.transition.jokemysql.data.model.Joke;

import java.util.List;

public class JokeWithCommentResponseDto extends StandardResponseDto{
    private JokeWithCommentDto jokeWithComment;
    private List<JokeWithCommentDto> jokeWithComments;



    public JokeWithCommentResponseDto(){

    }

    public JokeWithCommentResponseDto(Status status){
        this.status = status;
    }

    public JokeWithCommentResponseDto(Status status, ApiFieldError data) {
        this.data = data;
        this.status = status;
    }

    public JokeWithCommentResponseDto(List<JokeWithCommentDto> jokeWithComments, Status status, PageInfo page){
        super(status);
        this.jokeWithComments = jokeWithComments;
        this.page = page;
    }

    public JokeWithCommentResponseDto(JokeWithCommentDto jokeWithComment, Status status) {
        super(status);
        this.jokeWithComment = jokeWithComment;
    }

    public JokeWithCommentResponseDto(Status status, JokeWithCommentDto jokeWithComment) {
        super(status);
        this.jokeWithComment= jokeWithComment;
    }

    public JokeWithCommentResponseDto(List<JokeWithCommentDto> jokeWithComments, Status status) {
        super(status);
        this.jokeWithComments = jokeWithComments;
    }

    public JokeWithCommentDto getJokeWithComment() {
        return jokeWithComment;
    }

    public void setJokeWithComment(JokeWithCommentDto jokeWithComment) {
        this.jokeWithComment = jokeWithComment;
    }

    public List<JokeWithCommentDto> getJokeWithComments() {
        return jokeWithComments;
    }

    public void setJokeWithComments(List<JokeWithCommentDto> jokeWithComments) {
        this.jokeWithComments = jokeWithComments;
    }
}
