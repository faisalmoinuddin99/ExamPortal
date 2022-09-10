package com.exam.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId ;

    @Column(length = 5000)
    private String content ;
    private String image ;
    private String option1 ;
    private String option2 ;
    private String option3 ;
    private String option4 ;
    private String answer ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_q_id")
    private Quiz quiz ;
}
