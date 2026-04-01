package com.synap.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이 클래스를 상속할 경우 필드들도 컬럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class)  //Auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장될때 시간도 자동 저장
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate  // 조회한 엔티티의 값을 변경할때 시간이 자동 저장
    private LocalDateTime updatedAt;

}
