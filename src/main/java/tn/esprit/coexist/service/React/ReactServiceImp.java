package tn.esprit.coexist.service.React;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Comment;
import tn.esprit.coexist.entity.React;
import tn.esprit.coexist.entity.Subject;
import tn.esprit.coexist.entity.User;
import tn.esprit.coexist.repository.CommentRepository;
import tn.esprit.coexist.repository.ReactRepository;
import tn.esprit.coexist.repository.SubjectRepository;
import tn.esprit.coexist.repository.UserRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ReactServiceImp implements ReactService {
    @Autowired
    ReactRepository reactRepository ;
    SubjectRepository subjectRepository ;
    UserRepository userRepository ;

    @Override
    public React addReactToSubject(React react, Integer idSub, Integer userId) {
        Subject subject = subjectRepository.findById(idSub).orElse(null);

        if (subject != null) {
            User user = userRepository.findById(userId).orElse(null);

            if (user != null) {
                React existingReact = reactRepository.findByUserAndSubject(user, subject);

                if (existingReact != null) {
                    reactRepository.delete(existingReact);
                }

                react.setUser(user);
                react.setSubject(subject);
                reactRepository.save(react);
            }
        }

        return react;
    }
    @Override
    public List<React> getReactSubject(Integer subjectId) {
        return reactRepository.findBySubjectSubjectId(subjectId);
    }
}



