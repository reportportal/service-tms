package com.epam.reportportal.mapper;

public interface DtoMapper<T,V> {
    V convert(T t);
}
