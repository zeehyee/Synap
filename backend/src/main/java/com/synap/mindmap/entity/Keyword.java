package com.synap.mindmap.entity;

import com.synap.common.entity.BaseTimeEntity;
import com.synap.thought.entity.ThoughtKeyword;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="keywords")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String keyword;

    @OneToMany(mappedBy = "keyword")
    @Builder.Default
    private List<ThoughtKeyword> thoughtKeywords = new ArrayList<>();
}
