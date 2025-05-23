package com.employe.org.dao.database;

import com.employe.org.domain.Employe;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ISQLFunction<T> {
    T apply(Connection connection) throws SQLException;
}
