package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiateRegistrationRequest extends ApiRequest<InitiateRegistrationRequest.RegistrationData> {

    public InitiateRegistrationRequest(RequestType requestType, RegistrationData request) {
        super(requestType, request);
    }


    @Getter
    @Setter
    public static class RegistrationData {
        private String email;
        private String phone;

        public RegistrationData(String email, String phone) {
            this.email = email;
            this.phone = phone;
        }
    }
}