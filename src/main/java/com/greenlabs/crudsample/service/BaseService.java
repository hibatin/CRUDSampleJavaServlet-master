package com.greenlabs.crudsample.service;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public interface BaseService<T> {

    T Save(T entity);

    List<T> find(int offset, int limit);

    T findById(long id);

    String delete(long id);
}
