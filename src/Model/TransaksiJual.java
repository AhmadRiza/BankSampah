/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;


public final class TransaksiJual extends Transaksi {
    
    private int idPengepul;
    private String nota;

    public TransaksiJual(int idPengepul, int id, int idJenis, int beratTotal, double total, String tanggal) {
        super(id, idJenis, beratTotal, total, tanggal);
        this.idPengepul = idPengepul;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    public int getIdPengepul() {
        return idPengepul;
    }

    public void setIdPengepul(int idPengepul) {
        this.idPengepul = idPengepul;
    }

    @Override
    public String getTableName() {
        return "transaksi_jual";
    }
//    SELECT `id_tjual`, `id_pengepul`, `id_jenis`, `berat_total`, `total`, `tanggal` FROM `transaksi_jual`
    @Override
    public String getWhereKey() {
        return "id_tjual = "+id;
    }

    @Override
    public String toInsert() {
        String nota = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()).replace(".", "");
        setNota(nota);
        String s = "default, '"+nota+"' , "+idPengepul+", "+idJenis+", "+beratTotal+", default , default";
        return s;
    }
    
    
    
    @Override
    public String toString() {
        String s = 
                getId()+"->"+
                getIdJenis()+"->"+
                getIdPengepul()+"->"+
                getTanggal()+"->"+
                getBeratTotal()+"->"+
                getTotal();
        return s;
    }
}
