package com.example.TodoWebsite.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Memo extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @Builder
    public Memo(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void update(String name, String content) {
        this.name = name;
        this.content = content;
    }
}