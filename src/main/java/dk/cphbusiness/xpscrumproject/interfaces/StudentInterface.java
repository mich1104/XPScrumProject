/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.interfaces;

import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.List;

/**
 *
 * @author Muggi
 */
public interface StudentInterface {
    
    void setName(String name);
    String getName();
    void setFirstPriorities(Subject fag1, Subject fag2,Subject fag3);
    void setSecondPriorities(Subject fag1, Subject fag2, Subject fag3);
    List<Subject> getFirstPriority();
    List<Subject> getSecondPriority();
    void setGrades(int first,int second,int third);
    int[] getGrades();
    void setFirstGrade(int grade);
    void setSecondGrade(int grade);
    void setThirdGrade(int grade);
    
}
