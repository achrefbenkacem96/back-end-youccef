package tn.esprit.coexist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthenticationResponse {
    //private Integer userId;
    private String email;
    private String username;
    private String roleName;

    private String token;

}
