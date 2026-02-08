package repository;

import java.util.List;

public interface IRepository<T> {
    boolean add(T item);
    List<T> getAll();
    T getById(String id);
}
