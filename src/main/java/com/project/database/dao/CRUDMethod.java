package com.project.database.dao;

import java.util.List;

public interface CRUDMethod <T> {
    public void add(T instance);
    public void update(T instance);
    public void delete(int id);
    public T getById(int id);
    public List<T> getList();
}
