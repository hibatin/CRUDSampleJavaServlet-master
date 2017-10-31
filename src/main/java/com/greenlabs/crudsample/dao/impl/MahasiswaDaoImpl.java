package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.DbConnection;
import com.greenlabs.crudsample.dao.MahasiswaDao;
import com.greenlabs.crudsample.entity.Mahasiswa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class MahasiswaDaoImpl implements MahasiswaDao {

    @Override
    public Mahasiswa Save(Mahasiswa entity) {
        String sql = "INSERT INTO mahasiswa VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getNim());
            statement.setString(3, entity.getNama());
            statement.setString(4, entity.getAlamat());
            statement.setString(5, entity.getJurusan());
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
    public Mahasiswa update(Mahasiswa entity) {
        String sql = "UPDATE mahasiswa SET " +
                "nim = ?, " +
                "nama = ?, " +
                "alamat = ?, " +
                "jurusan = ? " +
                "WHERE id = ? ";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getNim());
            statement.setString(2, entity.getNama());
            statement.setString(3, entity.getAlamat());
            statement.setString(4, entity.getJurusan());
            statement.setLong(5, entity.getId());
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
    public List<Mahasiswa> find(int offset, int limit) {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa " +
                "ORDER BY id DESC ";

        if (offset != 0 && limit != 0) {
            sql += "limit ?, ? ";
        }

        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            if (offset != 0 && limit != 0) {
                statement.setInt(1, offset);
                statement.setInt(2, limit);
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setId(rs.getInt("id"));
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setAlamat(rs.getString("alamat"));
                mahasiswa.setJurusan(rs.getString("jurusan"));
                mahasiswas.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mahasiswas;
    }

    @Override
    public Mahasiswa findById(long id) {
        Mahasiswa mahasiswa = new Mahasiswa();
        String sql = "SELECT * FROM mahasiswa WHERE id = ? ";

        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                mahasiswa.setId(rs.getInt("id"));
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setAlamat(rs.getString("alamat"));
                mahasiswa.setJurusan(rs.getString("jurusan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mahasiswa;
    }

    @Override
    public String delete(long id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ? ";
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
