package org.albertsanso.commons.command;

public class DomainCommandResponse {
    private final boolean success;
    private final Object response;

    private DomainCommandResponse(boolean success, Object response) {
        this.success = success;
        this.response = response;
    }

    public static DomainCommandResponse successResponse(Object response) {
        return new DomainCommandResponse(true, response);
    }

    public static DomainCommandResponse failResponse(Object response) {
        return new DomainCommandResponse(false, response);
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getResponse() {
        return response;
    }
}
