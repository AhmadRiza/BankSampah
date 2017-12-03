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
public class Account extends QueryAbstract{
    
    private String userName;
    private String pasword;
    private int status;

    @Override
    public String toInsert() {
        return " ' "+userName+" ',  '"+pasword+"' ,"+status;
    }

    @Override
    public String toUpdate() {
        return "status = "+status;
    }

    @Override
    public String getWhereKey() {
        return "username = '"+userName+"' AND password = MD5 ('"+pasword+"') ";
    }

    @Override
    public String getTableName() {
        return "account";
    }
    
    
}
