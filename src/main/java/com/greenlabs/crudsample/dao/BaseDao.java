package com.greenlabs.crudsample.dao;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public interface BaseDao<T> {
    T Save(T entity);

    T update(T entity);

    List<T> find(int offset, int limit);

    T findById(long id);

    String delete(long id);
}
