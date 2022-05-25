package com.transition.jokemysql.data.outputDto;

import com.transition.jokemysql.data.model.Comment;
import com.transition.jokemysql.data.model.Joke;
import lombok.Data;

import java.util.List;



public class JokeWithCommentDto {
    private Joke joke;
    private List<Comment> comment;


    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "JokeWithCommentDto{" +
                "joke=" + joke +
                ", comment=" + comment +
                '}';
    }
}
