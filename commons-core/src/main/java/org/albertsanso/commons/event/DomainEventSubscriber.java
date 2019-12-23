package org.albertsanso.commons.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DomainEventSubscriber <T extends DomainEvent> {
    public abstract void handle(T domainEvent);

    public Class<T> handles() {
        Class clazz = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        return (Class<T>) typeArguments[0];
    }
}
