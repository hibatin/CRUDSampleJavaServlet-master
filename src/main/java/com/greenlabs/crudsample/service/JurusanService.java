package com.greenlabs.crudsample.service;

import com.greenlabs.crudsample.dao.JurusanDao;
import com.greenlabs.crudsample.dao.impl.JurusanDaoImpl;
import com.greenlabs.crudsample.entity.Jurusan;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class JurusanService implements BaseService<Jurusan> {

    private JurusanDao jurusanDao = new JurusanDaoImpl();

    @Override
    public Jurusan Save(Jurusan entity) {
        if (entity.getId() == 0) {
            entity = jurusanDao.Save(entity);
        }else {
            entity = jurusanDao.update(entity);
        }

        return entity;
    }

    @Override
    public List<Jurusan> find(int offset, int limit) {
        return jurusanDao.find(offset, limit);
    }

    @Override
    public Jurusan findById(long id) {
        return jurusanDao.findById(id);
    }

    @Override
    public String delete(long id) {
        return jurusanDao.delete(id);
    }
}
