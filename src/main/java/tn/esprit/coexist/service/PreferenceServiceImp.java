package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.entity.CarpoolingType;
import tn.esprit.coexist.entity.Preference;
import tn.esprit.coexist.repository.PreferenceRepository;
@Aspect
@Slf4j
@Service
@AllArgsConstructor
public class PreferenceServiceImp implements PreferenceService{
PreferenceRepository preferenceRepository;

    @Override
    public Preference addPreference(Preference preference) {

    return preferenceRepository.save(preference);
}

    @Override
    public void delatePreference(Integer preferenceId) {

        preferenceRepository.deleteById(preferenceId);
    }

    @Override
    public void updatePreference(Integer preferenceId, Preference preference) {
       preference.setPreferenceId(preferenceId);
       preferenceRepository.save(preference);
    }

}
