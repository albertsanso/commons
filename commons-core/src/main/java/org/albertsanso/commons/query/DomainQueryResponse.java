package org.albertsanso.commons.query;

public class DomainQueryResponse {
    private final boolean success;
    private final Object response;

    private DomainQueryResponse(boolean success, Object response) {
        this.success = success;
        this.response = response;
    }

    public static DomainQueryResponse sucessResponse(Object response) {
        return new DomainQueryResponse(true, response);
    }

    public static DomainQueryResponse failResponse(Object response) {
        return new DomainQueryResponse(false, response);
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getResponse() {
        return response;
    }
}
