package com.greenlabs.crudsample.entity;

public class Matakuliah extends BaseEntity {

    private String kode;
    private String namaMatakuliah;

    public Matakuliah() {
    }

    public Matakuliah(long id) {
        super(id);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMatakuliah() {
        return namaMatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namaMatakuliah = namaMatakuliah;
    }

    @Override
    public String toString() {
        return "Matakuliah{" +
                "kode='" + kode + '\'' +
                ", namaMatakuliah='" + namaMatakuliah + '\'' +
                '}';
    }
}
