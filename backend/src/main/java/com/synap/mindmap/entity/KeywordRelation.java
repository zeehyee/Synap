package com.synap.mindmap.entity;

import com.synap.common.entity.BaseTimeEntity;
import com.synap.mindmap.enums.RelationDirection;
import com.synap.mindmap.enums.RelationType;
import com.synap.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeywordRelation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_keyword_id")
    private Keyword fromKeyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_keyword_id")
    private Keyword toKeyword;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private RelationDirection direction;

    @Enumerated(EnumType.STRING)
    private RelationType type;

    @Column(nullable = false)
    private int strength;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;






}
