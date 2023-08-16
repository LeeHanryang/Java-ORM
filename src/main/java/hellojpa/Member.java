package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ",
        allocationSize = 1
)
@Getter @Setter
public class Member {
    @Id // 기본 키 매핑
    @GeneratedValue(
//            strategy = GenerationType.AUTO // 아래 세가지 옵션 중 자동
//            strategy = GenerationType.IDENTITY // - 기본키 생성을 DB에 위임
//            strategy = GenerationType.SEQUENCE // - 시퀀스를 주는 전략
            strategy = GenerationType.TABLE // - 시퀀스 테이블 생성
            , generator = "MEMBER_SEQ_GENERATOR"
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    protected Member() {}

}
