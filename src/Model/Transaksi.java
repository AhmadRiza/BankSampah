/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author riza
 */
public class Transaksi extends QueryAbstract{
    protected int id;
    protected int idJenis;
    protected int beratTotal;
    protected double total;
    protected String tanggal;

    public Transaksi(int id, int idJenis, int beratTotal, double total, String tanggal) {
        this.id = id;
        this.idJenis = idJenis;
        this.beratTotal = beratTotal;
        this.total = total;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public int getIdJenis() {
        return idJenis;
    }

    public int getBeratTotal() {
        return beratTotal;
    }

    public double getTotal() {
        return total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setBeratTotal(int beratTotal) {
        this.beratTotal = beratTotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
