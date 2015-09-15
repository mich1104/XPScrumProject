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
    List<Subject> getPoolCList();
    Boolean submitPools();
    void moveFromTo(Subject fag, String from, String to);
    List<Student> calculate();
    void loadStudents(String fileName);
    List<Student> getStudents();
    boolean resetPools();
    void loadDB();
}
