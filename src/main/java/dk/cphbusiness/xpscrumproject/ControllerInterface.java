/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.List;

/**
 *
 * @author Michael
 */
public interface ControllerInterface {
    
    List<Fag> getUnassignedList();
    List<Fag> getPoolAList();
    List<Fag> getPoolBList();
    Boolean submitPools(List<Fag> poolA,List<Fag> poolB);
    void addtoPoolA(Fag fag);
    Fag removeFromPoolA(Fag fag);
    void addtoPoolB(Fag fag);
    Fag removeFromPoolB(Fag fag);
    void addToUnassigned(Fag fag);
    Fag removeFromUnassigned(Fag fag);
    List<Student> calculate();
}
