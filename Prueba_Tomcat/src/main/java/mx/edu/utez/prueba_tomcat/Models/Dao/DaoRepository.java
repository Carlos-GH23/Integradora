package mx.edu.utez.prueba_tomcat.Models.Dao;

import java.util.List;
public interface DaoRepository<T> {
    List<T> findAll();
    T findOne(int id);
    boolean save(T object);
    boolean update(T object);
    boolean delete(int id);

}