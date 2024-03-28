package tn.esprit.coexist.service.Subject;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Subject;
import tn.esprit.coexist.repository.SubjectRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectServiceImp implements ICRUDService<Subject,Integer>,SubjectService {

    @Autowired
    SubjectRepository subjectRepository ;
    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject retrieveItem(Integer idItem) {
        return subjectRepository.findById(idItem).get();
    }

    @Override
    public Subject add(Subject Subject) {
        return subjectRepository.save(Subject);
    }

    @Override
    public void delete(Integer idRaect) {
        subjectRepository.deleteById(idRaect);

    }

    @Override
    public Subject update(Integer id ,Subject Subject) {
        Optional<Subject> existingSubjectOptional = subjectRepository.findById(id);

        if (existingSubjectOptional.isPresent()) {
            Subject existingSubject = existingSubjectOptional.get();
            existingSubject.setSubjectTitle(Subject.getSubjectTitle());

            return subjectRepository.save(existingSubject);
        } else {
            return null;
        }}
}



