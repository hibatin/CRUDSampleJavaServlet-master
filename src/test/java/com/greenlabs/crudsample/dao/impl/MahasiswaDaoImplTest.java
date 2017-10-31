package com.greenlabs.crudsample.dao.impl;

import com.greenlabs.crudsample.dao.MahasiswaDao;
import com.greenlabs.crudsample.entity.Mahasiswa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by kristiawan on 10/7/17.
 */
public class MahasiswaDaoImplTest {

    private MahasiswaDao impl;
    private Mahasiswa param;

    @Before
    public void setUp() throws Exception {
        impl = new MahasiswaDaoImpl();
        param = new Mahasiswa();
    }

    @Test
    public void testSuite() throws Exception {
        save();
        update();
        /*find();
        findById();
        delete();*/
    }

    public void save() throws Exception {
        param.setNim("10102890");
        param.setNama("Adi");
        param.setAlamat("jogja");
        param.setJurusan("TI");
        param = impl.Save(param);
        System.out.println("save : " + param.toString());
        Assert.assertTrue(param.getId() != 0);
    }

    public void update() {
        param.setAlamat("surabaya");
        param = impl.update(param);
        System.out.println("update : " + param.toString());
        Assert.assertTrue(param.getAlamat().equals("surabaya"));
    }

    public void find() throws Exception {
        List<Mahasiswa> mahasiswas = impl.find(0, 0);
        System.out.println("find -> Mahasiswas : " + mahasiswas.toString());
        Assert.assertFalse(mahasiswas.isEmpty());
    }

    public void findById() throws Exception {
        param = impl.findById(param.getId());
        System.out.println("findByid : " + param.toString());
        Assert.assertNotNull(param);
    }

    public void delete() throws Exception {
        System.out.println("delete : " + impl.delete(param.getId()));
    }
}