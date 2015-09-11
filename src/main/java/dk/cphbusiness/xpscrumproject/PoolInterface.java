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
    
    void setUnassignedPool(List<Subject> list);
    List<Subject> getUnassignedPool();
    
    void addToPoolA(Subject fag);
    List<Subject> getPoolA();
    
    void addToPoolB(Subject fag);
    List<Subject> getPoolB();
    
    void addToPoolC(Subject fag);
    List<Subject> getPoolC();
    
    Subject removeFromPoolA(Subject fag);
    Subject removeFromPoolB(Subject fag);
    Subject removeFromPoolC(Subject fag);
    void addToUnassigned(Subject fag);
    Subject removeFromUnassignedPool(Subject fag);
}
