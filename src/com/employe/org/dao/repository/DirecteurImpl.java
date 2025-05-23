package com.employe.org.dao.repository;

import com.employe.org.dao.interfce.IDirecteurDAO;
import com.employe.org.domain.Directeur;

import java.sql.SQLException;
import java.util.List;

public class DirecteurImpl implements IDirecteurDAO
{

    @Override
    public Directeur get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Directeur> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Directeur create(Directeur directeur) throws SQLException {
        return null;
    }

    @Override
    public int update(Directeur directeur) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Directeur directeur) throws SQLException {
        return 0;
    }
}
