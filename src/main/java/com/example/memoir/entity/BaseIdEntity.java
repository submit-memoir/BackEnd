package com.example.memoir.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass // 공통된 매핑 정보가 필요할 때 사용(DB 상속관계 매핑 관련 없음)
@EntityListeners(AuditingEntityListener.class) // @EntityListeners : Entity의 이벤트 처리, AuditingEntityListener.class : Auditing(시간에 대해 자동을 값을 넣어주는 기능) 사용
public class BaseIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
