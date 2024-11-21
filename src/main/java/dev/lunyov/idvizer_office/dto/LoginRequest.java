package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest extends ApiRequest<LoginRequest.LoginData> {

    public LoginRequest(RequestType requestType, LoginData request) {
        super(requestType, request);
    }

    @Getter
    @Setter
    public static class LoginData {
        private String jwtVersion;
        private String base64Jwt;

        public LoginData(String jwtVersion, String base64Jwt) {
            this.jwtVersion = jwtVersion;
            this.base64Jwt = base64Jwt;
        }
    }
}