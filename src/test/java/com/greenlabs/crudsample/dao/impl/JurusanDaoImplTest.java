package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.entity.Jurusan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class JurusanDaoImplTest {
    private JurusanDaoImpl impl;
    private Jurusan param;

    @Before
    public void setUp() {
        impl = new JurusanDaoImpl();
        param = new Jurusan();
    }

    @Test
    public void testSuite() throws Exception {
        save();
        update();
        find();
        findById();
        delete();
    }

    public void save() throws Exception {
        param.setKode("TI90DA");
        param.setNama("Basis Data");
        param = impl.Save(param);
        System.out.println("save : " + param.toString());
        Assert.assertTrue(param.getId() != 0);
    }


    public void update() {
        param.setKode("TI90DS");
        param = impl.update(param);
        System.out.println("update : " + param.toString());
        Assert.assertTrue(param.getKode().equals("TI90DS"));
    }

    public void find() throws Exception {
        List<Jurusan> jurusans = impl.find(0, 0);
        System.out.println("find -> Jurusan count : " + jurusans.size());
        Assert.assertFalse(jurusans.isEmpty());
    }

    public void findById() throws Exception {
        param = impl.findById(param.getId());
        System.out.println("findById : " + param.toString());
        Assert.assertNotNull(param);
    }

    public void delete() throws Exception {
        System.out.println("delete : " + impl.delete(param.getId()));
    }
}