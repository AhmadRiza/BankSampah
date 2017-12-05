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
public class TarikTunai extends QueryAbstract{
    
    private int id;
    private int idMember;
    private double nominal;
    private String tgl;

    public TarikTunai(int id, int idMember, double nominal, String tgl) {
        this.id = id;
        this.idMember = idMember;
        this.nominal = nominal;
        this.tgl = tgl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
    
    
    
    @Override
    public String toInsert() {
        return "default, "+idMember+", "+nominal+" , default";
    }

    @Override
    public String toUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereKey() {
        return "id_penarikan = "+id;
    }

    @Override
    public String getTableName() {
        return "tarik_tunai";
    }
    
    
}
