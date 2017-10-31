package com.greenlabs.crudsample.entity;

public class TransaksiKrs extends BaseEntity {

    private String kodeMatkul;
    private String hari;
    private int jam;

    public TransaksiKrs(){

    }
    public TransaksiKrs(long id) {
        super(id);
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return "TransaksiKrsDao{" +
                "kodeMatkul='" + kodeMatkul + '\'' +
                ", hari='" + hari + '\'' +
                ", jam=" + jam +
                '}';
    }
}
