package com.project.database.service;

import java.util.List;

public interface CRUDService <T> {
    public void add(T instance);
    public void update(T instance);
    public void delete(int id);
    public T getById(int id);
    public List<T> getList();
}
