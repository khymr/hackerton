package hackerton.be.domain.user;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.userRegisteredSubject.UserRegisteredSubject;
import hackerton.be.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 사용자 이름


}
