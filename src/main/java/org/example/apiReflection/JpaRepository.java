package org.example.apiReflection;

import java.sql.SQLException;
import java.util.List;

public interface JpaRepository <T, R>{
    T save(T args) throws SQLException;
    T findById(R id);
    List<T> findAll();
    boolean deleteById(R id);
}
