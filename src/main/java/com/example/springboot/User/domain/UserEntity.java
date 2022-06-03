package com.example.springboot.user.domain;

import com.example.springboot.user.domain.type.Sex;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 접근자 필드에 접근하게 해준다 ? 필드에 Get 메소드 생성해줌
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 매개변수가 없는 생성자
@Entity // Entity 클래스라는걸 스프링부트에 명시
public class UserEntity {
    @Id // 해당 테이블의 PK 필드를 나타냄, 하나만 존재하는 유니크 번호 부여
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙 나타냄, DB 에서는 내용에 맞춰 계속 행을 늘려줌(자동 증가), 정리 -> 규칙 정의 ?
    private Long id;
    // @Column = 속성 값을 정의(테이블), 필드를 테이블의 컬럼(열)에 매핑시킴
    // @Column 으로 작성해도 되지만 이렇게 작성해주는 이유는 자바에서도 인식하기 때문이다.
    // 이렇게 작성 ? =     @NotNull ,  @Length(max = N)
    @Column(length = 255, nullable = false)
    private String accountId;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 5, nullable = false)
    private Long studentId;

    @Enumerated(EnumType.STRING)
    @Column(length = 6, nullable = false)
    private Sex sex;

    @Builder
    public UserEntity(String accountId, String email, String password, String name, Long studentId, Sex sex) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.sex = sex;
    }

    public void update(String accountId, String password, String name, String email, Long studentId, Sex sex) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.studentId = studentId;
        this.sex = sex;
    }
}