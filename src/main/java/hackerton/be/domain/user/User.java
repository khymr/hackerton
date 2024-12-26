package hackerton.be.domain.user;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.userRegisteredSubject.UserRegisteredSubject;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 사용자 이름

    @OneToMany(mappedBy = "user") // UserRegisteredSubject의 "user" 필드와 매핑
    private List<UserRegisteredSubject> registeredSubjects = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommend> recommends = new ArrayList<>();


}
