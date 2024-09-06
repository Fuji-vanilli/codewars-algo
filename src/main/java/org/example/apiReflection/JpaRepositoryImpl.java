package org.example.apiReflection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JpaRepositoryImpl<T, R> implements JpaRepository<T, R>{
    private final static Connection connection= SingletonConnection.getConnection();
    static {
        try {
            PreparedStatement statement= connection.prepareStatement(
                    "CREATE TABLE "
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T save(T args) throws SQLException {
        PreparedStatement statement= connection.prepareStatement(
                "INSERT INTO"
        );
        return null;
    }

    @Override
    public T findById(R id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(R id) {
        return false;
    }
}
