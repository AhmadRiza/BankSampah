/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;

public final class TransaksiBeli extends Transaksi {

    private int idMember;
    private String noNota;

    public TransaksiBeli(int idMember, String noNota, int id, int idJenis, int beratTotal, double total, String tanggal) {
        super(id, idJenis, beratTotal, total, tanggal);
        if (noNota == null) {
            String nota = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()).replace(".", "");
            this.noNota = nota;
        }else{
            this.noNota = noNota;
        }
        this.idMember = idMember;
    }

    @Override
    public String getTableName() {
        return "transaksi_beli";
    }

    @Override
    public String getWhereKey() {
        return "id_tbeli = " + id;
    }

    @Override
    public String toInsert() {

//        `id_tbeli`, `id_jenis`, `berat_total`, `nomor_nota`, `id_member`, `total`, `tanggal`
        String s = "default, " + idJenis + ", " + beratTotal + ", '" + noNota + "', " + idMember + ", default , default ";
        return s;
    }

    public int getIdMember() {
        return idMember;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    @Override
    public String toString() {
        String s
                = getId() + "->"
                + getNoNota() + "->"
                + getIdJenis() + "->"
                + getIdMember() + "->"
                + getTanggal() + "->"
                + getBeratTotal() + "->"
                + getTotal();
        return s;
    }

}
