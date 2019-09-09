package com.utilities;

import java.util.List;

public interface DAO<T> {

    boolean insert(T t);
    boolean update(String search, T t);
    boolean remove(String search);
    T get(String search);
    List<T> getAll();
}
