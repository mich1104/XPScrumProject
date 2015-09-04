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
    
    void setUnassignedPool(List<Fag> list);
    List<Fag> getUnassignedPool();
    
    void addToPoolA(Fag fag);
    List<Fag> getPoolA();
    
    void addToPoolB(Fag fag);
    List<Fag> getPoolB();
    
    Fag removeFromPoolA(Fag fag);
    Fag removeFromPoolB(Fag fag);
    void addToUnassigned(Fag fag);
    Fag removeFromUnassignedPool(Fag fag);
}
