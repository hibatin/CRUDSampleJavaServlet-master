package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.dao.TransaksiKrsDao;
import com.greenlabs.crudsample.entity.Mahasiswa;
import com.greenlabs.crudsample.entity.TransaksiKrs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransaksiKrsDaoImplTest {
    private TransaksiKrsDao impl;
    private TransaksiKrs param;

    @Before
    public void setUp() throws Exception {
        impl = new TransaksiKrsDaoImpl();
        param = new TransaksiKrs();
    }

    @Test
    public void testSuite() throws Exception {
        save();
        //update();
        /*find();
        findById();
        delete();*/
    }
    @Test
    public void save() throws Exception {
        param.setKodeMatkul("MK002");
        param.setHari("kamis");
        param.setJam(2);
        param = impl.Save(param);
        System.out.println("save : " + param.toString());
        Assert.assertTrue(param.getId() != 0);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void find() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}