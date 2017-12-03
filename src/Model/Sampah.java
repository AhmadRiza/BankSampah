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

//`sampah`(`id_jenis`, `jenis`, `harga_jual`, `harga_beli`

public final class Sampah extends QueryAbstract{
    
    
    private int idJenis;
    private String jenis;
    private double hargaJual;
    private double hargaBeli;
    private int stok;

    public Sampah(int idJenis, String jenis, double hargaJual, double hargaBeli, int stok) {
        this.idJenis = idJenis;
        this.jenis = jenis;
        this.hargaJual = hargaJual;
        this.hargaBeli = hargaBeli;
        this.stok = stok;
    }
    
    
    @Override
    public String getWhereKey() {
        return "id_jenis = "+idJenis;
    }

    
    @Override
    public String toInsert() {
        String s = "default, '"+jenis+"' , "+hargaJual+" , "+hargaBeli+","+stok;
        return s;
    }
    
    @Override
    public String toUpdate() {
        String s = " jenis = '"+jenis+"' , harga_jual = "+hargaJual+", harga_beli = "+hargaBeli+", stok="+stok;
        return s;
    }
    
    

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    

    public void setIdJenis(int idJenis) {
        this.idJenis = idJenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public int getIdJenis() {
        return idJenis;
    }

    public String getJenis() {
        return jenis;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    @Override
    public String toString() {
        String s =  getIdJenis()+"->"+
                getJenis()+"->"+
                getHargaBeli()+"->"+
                getHargaJual();
        return s;
    }

    @Override
    public String getTableName() {
        return "sampah";
    }

    
    
}
