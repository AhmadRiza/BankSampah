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
public class Member extends QueryAbstract{
    
//    `id_member`,`nik`,`nama`,`alamat`,`no_telp`,`saldo`, 
    
    
    private int id;
    private String nama;
    private String nik;
    private String alamat;
    private String noTelp;
    private double saldo;

    public Member(int id, String nama, String nik, String alamat, String noTelp, double saldo) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.saldo = saldo;
    }
    
    
    @Override
    public String getWhereKey() {
        return "id_member = "+id;
    }

    
    @Override
    public String toInsert() {
        String s = "default, '"+nik+"' , '"+nama+"' , '"+alamat+"' , '"+noTelp+"' , default";
        return s;
    }
    
    @Override
    public String toUpdate() {
        String s = " nama = '"+nama+"' , nik = '"+nik+"', alamat = '"+alamat
                +"', no_telp = '"+noTelp+"', saldo = "+saldo;
        return s;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public int getId() {
        return id;
    }
    
   
    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        String s = getId()+"->"+
                getNik()+"->"+
                getNama()+"->"+
                getAlamat()+"->"+
                getNoTelp()+"->"+
                getSaldo();
        return s;
    }

    @Override
    public String getTableName() {
        return "member";
    }

    
    
}
