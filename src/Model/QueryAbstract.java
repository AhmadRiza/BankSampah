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
public abstract class QueryAbstract {
    
    public abstract String toInsert();
    public abstract String toUpdate();
    public abstract String getWhereKey();
    public abstract String getTableName();
    
}
