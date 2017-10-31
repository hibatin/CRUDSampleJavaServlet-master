package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.DbConnection;
import com.greenlabs.crudsample.dao.TransaksiKrsDao;
import com.greenlabs.crudsample.entity.TransaksiKrs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransaksiKrsDaoImpl implements TransaksiKrsDao {

    @Override
    public TransaksiKrs Save(TransaksiKrs entity) {
        String sql = "INSERT INTO transaksikrs VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getKodeMatkul());
            statement.setString(3, entity.getHari());
            statement.setInt(4, entity.getJam());
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
    public TransaksiKrs update(TransaksiKrs entity) {

        String sql = "UPDATE transaksikrs SET " +
                "kode = ?, " +
                "hari = ?, " +
                "jam = ? " +
                "WHERE id = ? ";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getKodeMatkul());
            statement.setString(2, entity.getHari());
            statement.setInt(3, entity.getJam());
            statement.setLong(4, entity.getId());
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
    public List<TransaksiKrs> find(int offset, int limit) {
        List<TransaksiKrs> transaksikrses = new ArrayList<>();
        String sql = "SELECT * FROM transaksikrs " +
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
                TransaksiKrs transaksiKrs = new TransaksiKrs();
                transaksiKrs.setId(rs.getInt("id"));
                transaksiKrs.setKodeMatkul(rs.getString("kode"));
                transaksiKrs.setHari(rs.getString("hari"));
                transaksiKrs.setJam(rs.getInt("jam"));
                transaksikrses.add(transaksiKrs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksikrses;
    }

    @Override
    public TransaksiKrs findById(long id) {
        return null;
    }

    @Override
    public String delete(long id) {
        String sql = "DELETE FROM transaksikrs WHERE id = ? ";
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
