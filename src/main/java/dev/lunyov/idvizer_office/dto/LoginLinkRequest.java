package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoginLinkRequest extends ApiRequest<LoginLinkRequest.LoginLinkData> {

    public LoginLinkRequest(RequestType requestType, LoginLinkData request) {
        super(requestType, request);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginLinkData {
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Incorrect email format")
        private String email;
    }
}

