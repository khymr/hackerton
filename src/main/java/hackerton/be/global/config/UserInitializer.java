package hackerton.be.global.config;

import hackerton.be.domain.user.User;
import hackerton.be.domain.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserInitializer {
    private final UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (!userRepository.existsById(1L)) {
            User user = User.builder()
                    .username("testUser")
                    .build();
            userRepository.save(user);
        }
    }
}