package dev.lunyov.idvizer_office.util;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
public class ApiResponse<T> {
    private ResponseType responseType;
    private UUID requestId;
    private T response;

    public ApiResponse() {
    }

    public ApiResponse(ResponseType responseType, UUID requestId, T response) {
        this.responseType = responseType;
        this.requestId = requestId;
        this.response = response;
    }
}