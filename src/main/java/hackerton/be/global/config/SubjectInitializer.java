package hackerton.be.global.config;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.repository.SubjectRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class SubjectInitializer {
    private final SubjectRepository subjectRepository;

    @PostConstruct
    public void init() {
        if (subjectRepository.count() > 0) {
            return;
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("subjects_2024.csv").getInputStream(), "UTF-8"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Subject subject = Subject.builder().build();
                subject.updateName(data[0]);
                subject.updateType(data[1]);
                subject.updateCredit(data[2]);
                subject.updateGrade(Integer.parseInt(data[3]));
                subject.updateDepartment(data[4]);
                subject.updateProfessor(data[5]);
                subjectRepository.save(subject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
