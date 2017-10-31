package com.greenlabs.crudsample.service;

import com.greenlabs.crudsample.dao.MahasiswaDao;
import com.greenlabs.crudsample.dao.impl.MahasiswaDaoImpl;
import com.greenlabs.crudsample.entity.Mahasiswa;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class MahasiswaService implements BaseService<Mahasiswa> {

    private MahasiswaDao mahasiswaDao = new MahasiswaDaoImpl();

    @Override
    public Mahasiswa Save(Mahasiswa entity) {
        if (entity.getId() == 0) {
            entity = mahasiswaDao.Save(entity);
        } else {
            entity = mahasiswaDao.update(entity);
        }

        return entity;
    }

    @Override
    public List<Mahasiswa> find(int offset, int limit) {
        return mahasiswaDao.find(offset, limit);
    }

    @Override
    public Mahasiswa findById(long id) {
        return mahasiswaDao.findById(id);
    }

    @Override
    public String delete(long id) {
        return mahasiswaDao.delete(id);
    }
}
