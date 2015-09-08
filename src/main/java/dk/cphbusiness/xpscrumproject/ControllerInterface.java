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
    
    List<Subject> getUnassignedList();
    List<Subject> getPoolAList();
    List<Subject> getPoolBList();
    Boolean submitPools();
    void addtoPoolA(Subject fag);
    Subject removeFromPoolA(Subject fag);
    void addtoPoolB(Subject fag);
    Subject removeFromPoolB(Subject fag);
    void addToUnassigned(Subject fag);
    Subject removeFromUnassigned(Subject fag);
    List<Student> calculate();
    void loadStudents();
    List<Student> getStudents();
}
