package org.albertsanso.commons.command;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DomainCommandHandler <T extends DomainCommand> {
    public abstract DomainCommandResponse handle(T command);

    public Class<T> handles() {
        Class clazz = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        return (Class<T>) typeArguments[0];
    }
}
