package tn.esprit.coexist.service.React;


import tn.esprit.coexist.entity.React;

import java.util.List;

public interface ReactService {

    React addReactToSubject(React react, Integer idSub, Integer userId) ;
    List<React> getReactSubject(Integer subjectId);
}
