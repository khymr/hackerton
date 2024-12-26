package hackerton.be.domain.userRegisteredSubject;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "user_subject")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder
public class UserRegisteredSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
