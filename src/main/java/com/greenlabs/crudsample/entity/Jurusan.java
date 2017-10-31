package com.greenlabs.crudsample.entity;

/**
 * Created by kristiawan on 10/7/17.
 */
public class Jurusan extends BaseEntity{

    private String kode;
    private String nama;

    public Jurusan() {
    }

    public Jurusan(long id) {
        super(id);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Jurusan{" +
                "kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                '}';
    }
}
