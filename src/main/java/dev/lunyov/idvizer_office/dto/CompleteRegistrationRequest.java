package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompleteRegistrationRequest extends ApiRequest<CompleteRegistrationRequest.RegistrationData> {

    public CompleteRegistrationRequest(RequestType requestType, RegistrationData request) {
        super(requestType, request);
    }

    @Getter
    @Setter
    public static class RegistrationData {
        private String jwtVersion;
        private String base64Jwt;

        public RegistrationData(String jwtVersion, String base64Jwt) {
            this.jwtVersion = jwtVersion;
            this.base64Jwt = base64Jwt;
        }
    }
}