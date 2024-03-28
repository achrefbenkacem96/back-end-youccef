package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.Subject;
import tn.esprit.coexist.service.Subject.SubjectService;
import tn.esprit.coexist.service.Subject.SubjectServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubjectController {
    @Autowired
    SubjectServiceImp subjectService ;
    @PostMapping("/add-Subject")
    @ResponseBody
    public Subject addSubject(@RequestBody Subject b) {

        return subjectService.add(b);
    }
    @GetMapping("/get_all_Subjects")
    public List<Subject> findAll() {
        return subjectService.findAll();
    }

    @PutMapping("/updateSubject/{id}")
    public Subject update(@RequestBody Subject Subject ,@PathVariable("id") Integer id) {
        return subjectService.update(id,Subject);
    }

    @DeleteMapping("/deleteSubject/{SubjectId}")
    public void delete(@PathVariable("SubjectId") Integer SubjectId) {
        subjectService.delete(SubjectId);
    }

}
