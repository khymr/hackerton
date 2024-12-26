package hackerton.be.domain.user;

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

    @OneToMany(mappedBy = "subject")
    private List<UserRegisteredSubject> registeredSubjects = new ArrayList<>();


}
