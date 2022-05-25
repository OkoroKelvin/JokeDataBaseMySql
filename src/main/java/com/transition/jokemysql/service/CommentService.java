package com.transition.jokemysql.service;

import com.transition.jokemysql.data.inputDto.CommentDeleteDto;
import com.transition.jokemysql.data.inputDto.CommentInputDto;
import com.transition.jokemysql.data.outputDto.CommentResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentResponseDto createComment(CommentInputDto inputDto);

    CommentResponseDto removeCommentFromJoke(CommentDeleteDto deleteDto);
}
