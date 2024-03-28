package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.Preference;
import tn.esprit.coexist.service.PreferenceService;

@RestController
@AllArgsConstructor
public class PreferenceController {
    PreferenceService preferenceService;
    @PostMapping("/addPreference")
    public Preference addPreference(@RequestBody Preference preference){
      return   preferenceService.addPreference(preference);

    }
    @DeleteMapping("/delatePreference/{preferenceId}")
    public void delatePreference(@PathVariable Integer preferenceId){
       preferenceService.delatePreference(preferenceId);

    }
    @PutMapping("/updatePreference/{preferenceId}")
    public void updatePreference(@PathVariable Integer preferenceId,@RequestBody Preference preference){
        preferenceService.updatePreference(preferenceId,preference);

    }
}
