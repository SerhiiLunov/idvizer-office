package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiResponse;
import dev.lunyov.idvizer_office.util.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SimpleResponse<T> extends ApiResponse<T> {

    //  For Authorization and Refresh
    //  SUCCESS, AUTHORIZATION_ERROR, ERROR
    public SimpleResponse(ResponseType responseType, UUID requestId) {
        super(responseType, requestId, null);
    }
}