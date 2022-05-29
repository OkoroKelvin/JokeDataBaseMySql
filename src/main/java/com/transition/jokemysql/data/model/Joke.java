package com.transition.jokemysql.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "joke")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private LocalDateTime createdDate;
    private Integer likes;
    public void like() {
        this.likes +=1;
    }
}
