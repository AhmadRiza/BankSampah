/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Model.Administrasi;
import Model.QueryAbstract;
import Model.Member;
import Model.Pengepul;
import Model.Sampah;
import Model.TransaksiBeli;
import Model.TransaksiJual;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riza
 */
public class CRUD extends MySQLAccess {

    Statement stat;
    PreparedStatement preStat;
    ResultSet result;
    String query, message;

    
    //for custom sql sam!!
    public boolean query (String sql){
        openConection();
        query = sql;
         try {
            stat = connect.createStatement();
            result = stat.executeQuery(query);

        } catch (SQLException ex) {
            message = "FAILED SELECT!"+ex.getMessage();
            return false;
        }
         return true;
        
    }
    
    public boolean get(String column, String table, String where, int limit) {
        openConection();
        query = "SELECT ";

        //parse column
        if (column == null) {
            query += "* ";
        } else {
            query += column + " ";
        }

        //parse table
        if (table == null) {
            return false;
        } else {
            query += "FROM " + table + " ";
        }

        //parse where
        if (where != null) {
            query += "WHERE " + where + " ";
        }

        if (limit > 0) {
            query += "LIMIT " + limit + " ";
        }

        try {
            stat = connect.createStatement();
            result = stat.executeQuery(query);

        } catch (SQLException ex) {
            message = "FAILED SELECT!"+ex.getMessage();
            return false;
        }

        return true;
    }

    public boolean insert(QueryAbstract object) {
        openConection();

        query = "INSERT INTO " + object.getTableName() + " VALUES (" + object.toInsert() + ") ";
        System.out.println(query);
        try {
            preStat = connect.prepareStatement(query);
            preStat.executeUpdate();
        } catch (SQLException ex) {
            message = "INSERT FAILED! " + ex.getMessage();
            return false;
        }

        return true;
    }

    public boolean delete(String table, String where) {
        openConection();
        if (table == null) {
            return false;
        }

        query = "DELETE FROM " + table + " WHERE " + where;
        try {
            preStat = connect.prepareStatement(query);
            preStat.executeUpdate();
        } catch (SQLException ex) {
            message = "DELETE FAILED!";
            return false;
        }

        return true;
    }

    public boolean update(QueryAbstract obj) {
        openConection();

        query = "UPDATE " + obj.getTableName() + " SET " + obj.toUpdate() + " WHERE " + obj.getWhereKey();
        try {
            preStat = connect.prepareStatement(query);
            preStat.executeUpdate();
        } catch (SQLException ex) {
            message = "Update FAILED! " + ex.getMessage();
            return false;
        }

        return true;

    }

    public ResultSet getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void closeConnection() {
        super.closeConnection();
        try {
            if (preStat != null) {
                preStat.close();

            }
            if (stat != null) {
                stat.close();

            }
            if (result != null) {
                result.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * PARSING RESULT TO OBJECT
     *
     * @return LIST
     */
    public ArrayList<Member> parseMember() {

        ArrayList<Member> list = new ArrayList<>();

        try {
            while (result.next()) {
                //    `id_member`,`nik`,`nama`,`alamat`,`no_telp`,`saldo`, 
                int id = result.getInt(1);
                String nama = result.getString(2);
                String nik = result.getString(3);
                String alamat = result.getString(4);
                String noTelp = result.getString(5);
                double saldo = result.getDouble(6);

                list.add(new Member(id, nama, nik, alamat, noTelp, saldo));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Sampah> parseSampah() {

        ArrayList<Sampah> list = new ArrayList<>();

        try {
            while (result.next()) {
                //`sampah`(`id_jenis`, `jenis`, `harga_jual`, `harga_beli`

                int idJenis = result.getInt(1);
                String jenis = result.getString(2);
                double hargaJual = result.getDouble(3);
                double hargaBeli = result.getDouble(4);
                int stok = result.getInt(5);

                list.add(new Sampah(idJenis, jenis, hargaJual, hargaBeli, stok));
            }
        } catch (Exception ex) {
            message = "INCOMPATIBLE TYPE!";
        }

        return list;

    }

    public ArrayList<Pengepul> parsePengepul() {

        ArrayList<Pengepul> list = new ArrayList<>();

        try {
            while (result.next()) {
                //    INSERT INTO `pengepul`(`id_pengepul`, `nama`, `alamat`, `jadwal`, `no_telp`) 
                int idPengepul = result.getInt(1);
                String nama = result.getString(2);
                String alamat = result.getString(3);
                String jadwal = result.getString(4);
                String noTelp = result.getString(5);
                list.add(new Pengepul(idPengepul, nama, alamat, jadwal, noTelp));
            }
        } catch (Exception ex) {
            message = "INCOMPATIBLE TYPE!";
        }

        return list;

    }

    public ArrayList<Administrasi> parseAdmin() {

        ArrayList<Administrasi> list = new ArrayList<>();

        try {
            while (result.next()) {
//             SELECT `id_adm`, `tanggal`, `saldo`, `keterangan`, `pemasukan` FROM `administrasi`
                int idAdmin = result.getInt(1);
                String tgl = result.getString(2);
                double saldo = result.getDouble(3);
                String ket = result.getString(4);
                double pemasukan = result.getDouble(5);
                list.add(new Administrasi(idAdmin, tgl, saldo, ket, pemasukan));
            }
        } catch (Exception ex) {
            message = "INCOMPATIBLE TYPE! " + ex;
        }

        return list;

    }

    public ArrayList<TransaksiBeli> parseTbeli() {

        ArrayList<TransaksiBeli> list = new ArrayList<>();

        try {
            while (result.next()) {
//                SELECT `id_tbeli`, `id_jenis`, `berat_total`, `nomor_nota`, `id_member`, `total`, `tanggal`
                int id = result.getInt(1);
                int idJenis = result.getInt(2);
                int beratTotal = result.getInt(3);
                String nota = result.getString(4);
                int idMember = result.getInt(5);
                double total = result.getDouble(6);
                String tgl = result.getString(7);
                list.add(new TransaksiBeli(idMember, nota, id, idJenis, beratTotal, total, tgl));
            }
        } catch (Exception ex) {
            message = "INCOMPATIBLE TYPE! " + ex;
        }

        return list;

    }

    public ArrayList<TransaksiJual> parseTJual() {

        ArrayList<TransaksiJual> list = new ArrayList<>();

        try {
            while (result.next()) {
//                `id_tjual`, `id_pengepul`, `id_jenis`, `berat_total`, `total`, `tanggal` FROM `transaksi_jual`
                int id = result.getInt(1);
                String nota = result.getString(2);
                int idPengepul = result.getInt(3);
                int idJenis = result.getInt(4);
                int beratTotal = result.getInt(5);
                double total = result.getDouble(6);
                String tanggal = result.getString(7);

                list.add(new TransaksiJual(idPengepul, nota, id, idJenis, beratTotal, total, tanggal));
            }
        } catch (Exception ex) {
            message = "INCOMPATIBLE TYPE! " + ex;
        }

        return list;

    }

    public String getQuery() {
        return query;
    }

}
