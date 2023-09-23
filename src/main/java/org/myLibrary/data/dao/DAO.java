package org.myLibrary.data.dao;

import java.util.List;

public interface DAO<T> {   // T est un générique pour Type. Permet de retourner tout type d'objet
    T get(int id);
    List<T> getByName(String name);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
