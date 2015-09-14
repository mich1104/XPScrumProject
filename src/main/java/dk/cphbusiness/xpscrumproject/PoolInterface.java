/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.List;

/**
 *
 * @author Muggi
 */
public interface PoolInterface {
        
    void addToPool(Subject fag);
    void addToPool(List<Subject> fag);
    List<Subject> getPool();
    List<Subject> removeAll();
    
    Subject removeFromPool(Subject fag);

}
