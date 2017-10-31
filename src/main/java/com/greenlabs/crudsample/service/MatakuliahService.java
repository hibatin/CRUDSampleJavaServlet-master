package com.greenlabs.crudsample.service;

import com.greenlabs.crudsample.dao.MatakuliahDao;
import com.greenlabs.crudsample.dao.impl.MatakuliahDaoImpl;
import com.greenlabs.crudsample.entity.Matakuliah;

import java.util.List;

public class MatakuliahService implements BaseService<Matakuliah> {

    private MatakuliahDao matakuliahDao = new MatakuliahDaoImpl();
    @Override
    public Matakuliah Save(Matakuliah entity) {
        return null;
    }

    @Override
    public List<Matakuliah> find(int offset, int limit) {
        return matakuliahDao.find(offset,limit);
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
