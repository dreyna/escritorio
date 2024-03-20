
package com.mycompany.maven.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Docente
 * @param <T>
 */
public interface Operaciones<T> {
    public int create(T t);
    public int update(T t);
    public int delete(int id);
    public T read(int id);
    public List<T> readAll();
    public List<Map<String, Object>> lista();
    public T read2(String nom);
}
