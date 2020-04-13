package org.albertsanso.commons.query;

public interface QueryBus {
    DomainQueryResponse push(DomainQuery query);
    void registerHandler(DomainQueryHandler handler);
}
