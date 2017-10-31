package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.DbConnection;
import com.greenlabs.crudsample.dao.JurusanDao;
import com.greenlabs.crudsample.entity.Jurusan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class JurusanDaoImpl implements JurusanDao {

    @Override
    public Jurusan Save(Jurusan entity) {
        String sql = "INSERT INTO jurusan VALUES(?, ?, ?)";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getKode());
            statement.setString(3, entity.getNama());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public Jurusan update(Jurusan entity) {
        String sql = "UPDATE jurusan SET " +
                "kode = ?, " +
                "nama = ? " +
                "WHERE id = ? ";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getKode());
            statement.setString(2, entity.getNama());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<Jurusan> find(int offset, int limit) {
        List<Jurusan> jurusans = new ArrayList<>();
        String sql = "SELECT * FROM jurusan " +
                "ORDER BY id DESC ";

        if (offset != 0 && limit != 0) {
            sql += "limit ?, ?";
        }

        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            if (offset != 0 && limit != 0) {
                statement.setInt(1, offset);
                statement.setInt(2, limit);
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Jurusan jurusan = new Jurusan();
                jurusan.setId(rs.getInt("id"));
                jurusan.setKode(rs.getString("kode"));
                jurusan.setNama(rs.getString("nama"));
                jurusans.add(jurusan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jurusans;
    }

    @Override
    public Jurusan findById(long id) {
        Jurusan jurusan = new Jurusan();
        String sql = "SELECT * FROM jurusan WHERE id = ? ";

        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                jurusan.setId(rs.getInt("id"));
                jurusan.setKode(rs.getString("kode"));
                jurusan.setNama(rs.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jurusan;
    }

    @Override
    public String delete(long id) {
        String sql = "DELETE FROM jurusan WHERE id = ? ";
        String message;
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            int status = statement.executeUpdate();
            if (status == 0) {
                message = "Delete Failed!";
            } else {
                message = "Record is deleted!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Delete Failed!";
        }

        return message;
    }
}
