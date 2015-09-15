/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.databasesetup;

import dk.cphbusiness.xpscrumproject.DBFacade;
import dk.cphbusiness.xpscrumproject.entity.Pool;
import dk.cphbusiness.xpscrumproject.PoolManager;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class populate {
    public static void main(String[] args) {
        PoolManager pm = new PoolManager();
        DBFacade dbf = new DBFacade(false);
        
        List<Subject> li = new ArrayList();
        Subject s1 = new Subject("C#", null, null);
        Subject s2 = new Subject("Python", null, null);
        Subject s3 = new Subject("Android", null, null);
        Subject s4 = new Subject("SW Design", null, null);
        Subject s5 = new Subject("Games", null, null);
        Subject s6 = new Subject("Databases", null, null);
        Subject s7 = new Subject("Test", null, null);
        Subject s8 = new Subject("Arduino", null, null);
        Subject s9 = new Subject("COBOL", null, null);
        Subject s10 = new Subject("Haskel", null, null);
        Subject s11 = new Subject("C++", null, null);
        Subject s12 = new Subject("IOS", null, null);
        pm.getAllPools().get(3).addToPool(s1);
        pm.getAllPools().get(3).addToPool(s2);
        pm.getAllPools().get(3).addToPool(s3);
        pm.getAllPools().get(3).addToPool(s4);
        pm.getAllPools().get(3).addToPool(s5);
        pm.getAllPools().get(3).addToPool(s6);
        pm.getAllPools().get(3).addToPool(s7);
        pm.getAllPools().get(3).addToPool(s8);
        pm.getAllPools().get(3).addToPool(s9);
        pm.getAllPools().get(3).addToPool(s10);
        pm.getAllPools().get(3).addToPool(s11);
        pm.getAllPools().get(3).addToPool(s12);
        li.add(s1);
        li.add(s2);
        li.add(s3);
        li.add(s4);
        li.add(s5);
        li.add(s6);
        li.add(s7);
        li.add(s8);
        li.add(s9);
        li.add(s10);
        li.add(s11);
        li.add(s12);
        
        dbf.createPool(pm.getAllPools());
        
        
        Pool p = new Pool();
        
        
    }
}
