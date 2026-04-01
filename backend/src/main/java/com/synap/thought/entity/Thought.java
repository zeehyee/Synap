package com.synap.thought.entity;

import com.synap.common.entity.BaseTimeEntity;
import com.synap.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thoughts")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Thought extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 여러 생각은 한명의 유저에게
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String content;

    private String aiSummary;
    private String aiQuestion;
    private String userAnswer;


    @OneToMany(mappedBy = "thought", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ThoughtKeyword> thoughtKeywords = new ArrayList<>();
}
