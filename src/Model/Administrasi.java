/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author riza
 */
public class Administrasi extends QueryAbstract{
//    INSERT INTO `administrasi`(`id_adm`, `tanggal`, 
//    `saldo`, `keterangan`, `pemasukan`)
    
    
    private int id;
    private String date;
    private double saldo;
    private String keterangan;
    private double pemasukan;

    public Administrasi(int id, String date, double saldo, String keterangan, double pemasukan) {
        this.id = id;
        this.date = date;
        this.saldo = saldo;
        this.keterangan = keterangan;
        this.pemasukan = pemasukan;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public double getPemasukan() {
        return pemasukan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setPemasukan(double pemasukan) {
        this.pemasukan = pemasukan;
    }

    @Override
    public String toString() {
        String s = 
                getId()+"->"+
                getDate()+"->"+
                getPemasukan()+"->"+
                getSaldo()+"->"+
                getKeterangan();
                
        return s;
    }

    @Override
    public String toInsert() {
//        `id_adm`, `tanggal`, `saldo`, `keterangan`, `pemasukan`
        String s = "default, default, default  , '"+keterangan+"', "+pemasukan;
        return s;
    }

    @Override
    public String toUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereKey() {
        return "id_adm "+" = "+id;
    }

    @Override
    public String getTableName() {
        return "administrasi";
    }
    
    
    
}
