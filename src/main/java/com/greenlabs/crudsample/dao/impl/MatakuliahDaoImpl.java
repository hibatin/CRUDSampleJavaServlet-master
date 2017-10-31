package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.DbConnection;
import com.greenlabs.crudsample.dao.MatakuliahDao;
import com.greenlabs.crudsample.entity.Matakuliah;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatakuliahDaoImpl implements MatakuliahDao {
    @Override
    public Matakuliah Save(Matakuliah entity) {
        return null;
    }

    @Override
    public Matakuliah update(Matakuliah entity) {
        return null;
    }

    @Override
    public List<Matakuliah> find(int offset, int limit) {
        List<Matakuliah> matakuliahs = new ArrayList<>();
        String sql = "SELECT * FROM matakuliah " +
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
                Matakuliah matakuliah = new Matakuliah();
                matakuliah.setId(rs.getInt("id"));
                matakuliah.setKode(rs.getString("kode"));
                matakuliah.setNamaMatakuliah(rs.getString("namamatkul"));
                matakuliahs.add(matakuliah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matakuliahs;
    }

    @Override
    public Matakuliah findById(long id) {
        return null;
    }

    @Override
    public String delete(long id) {
        return null;
    }
}
