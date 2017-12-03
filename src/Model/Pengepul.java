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
public class Pengepul extends QueryAbstract{
    
//    INSERT INTO `pengepul`(`id_pengepul`, `nama`, `alamat`, `jadwal`, `no_telp`) 
    private int idPengepul;
    private String nama;
    private String alamat;
    private String jadwal;
    private String noTelp;

    public Pengepul(int idPengepul, String nama, String alamat, String jadwal, String noTelp) {
        this.idPengepul = idPengepul;
        this.nama = nama;
        this.alamat = alamat;
        this.jadwal = jadwal;
        this.noTelp = noTelp;
    }
    
    @Override
    public String getWhereKey() {
        return "id_pengepul = "+idPengepul;
    }

    
    @Override
    public String toInsert() {
        String s = "default, '"+nama+"' , '"+alamat+"' , '"+jadwal+"' , '"+noTelp+"'";
        return s;
    }
    
    @Override
    public String toUpdate() {
        String s = " nama = '"+nama+"',  alamat = '"+alamat
                +"', no_telp = '"+noTelp+"', jadwal = '"+jadwal+"'";
        return s;
    }

    
    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    
    public int getIdPengepul() {
        return idPengepul;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setIdPengepul(int idPengepul) {
        this.idPengepul = idPengepul;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public String toString() {
        String s = 
                getIdPengepul()+"->"+
                getNama()+"->"+
                getAlamat()+"->"+
                getNoTelp()+"->"+
                getJadwal();
        return s;
    }

    @Override
    public String getTableName() {
        return "pengepul";
    }

    
    
}
