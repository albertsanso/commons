package org.albertsanso.commons.query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Named
public class SynchronousQueryBus implements QueryBus {

    private Map<String, DomainQueryHandler> registry;

    @Inject
    public SynchronousQueryBus(List<DomainQueryHandler<? extends DomainQuery>> handlersList) {
        this.registry = new HashMap<>();
        if (!isNull(handlersList)) {
            handlersList.forEach(this::registerHandler);
        }
    }

    @Override
    public DomainQueryResponse push(DomainQuery query) {
        DomainQueryHandler handler = registry.get(query.getClass().getName());
        return executeInmediately(query, handler);
    }

    private DomainQueryResponse executeInmediately(DomainQuery query, DomainQueryHandler handler) {
        return handler.handle(query);
    }

    @Override
    public void registerHandler(DomainQueryHandler handler) {
        if (registry.containsKey(handler.handles().getName())) {
            throw new IllegalStateException("Query registered yet!");
        }
        registry.put(handler.handles().getName(), handler);
    }
}
