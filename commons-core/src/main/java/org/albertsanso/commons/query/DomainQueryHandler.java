package org.albertsanso.commons.query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DomainQueryHandler<T extends DomainQuery> {
    public abstract DomainQueryResponse handle(T query);

    public Class<T> handles() {
        Class clazz = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        return (Class<T>) typeArguments[0];
    }
}
