package com.greenlabs.crudsample.service;

import com.greenlabs.crudsample.dao.TransaksiKrsDao;
import com.greenlabs.crudsample.dao.impl.TransaksiKrsDaoImpl;
import com.greenlabs.crudsample.entity.TransaksiKrs;

import java.util.List;

public class TransaksiKrsService implements BaseService<TransaksiKrs> {

    private TransaksiKrsDao transaksiKrsDao = new TransaksiKrsDaoImpl();

    @Override
    public TransaksiKrs Save(TransaksiKrs entity) {

        if (entity.getId() == 0) {
            entity = transaksiKrsDao.Save(entity);
        } else {
            entity = transaksiKrsDao.update(entity);
        }
        return entity;
    }

    @Override
    public List<TransaksiKrs> find(int offset, int limit) {
        return transaksiKrsDao.find(offset, limit);
    }

    @Override
    public TransaksiKrs findById(long id) {
        return null;
    }

    @Override
    public String delete(long id) {
        return transaksiKrsDao.delete(id);
    }
}
