package dev.lunyov.idvizer_office.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiRequest<T> {
    private RequestType requestType;
    private T request;

    public ApiRequest() {
    }

    public ApiRequest(RequestType requestType, T request) {
        this.requestType = requestType;
        this.request = request;
    }
}