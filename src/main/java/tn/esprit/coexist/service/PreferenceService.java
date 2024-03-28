package tn.esprit.coexist.service;

import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.entity.Preference;

public interface PreferenceService {
    public Preference addPreference(Preference preference);
    public void delatePreference(Integer preferenceId);
    public void updatePreference(Integer preferenceId,Preference preference);

}
