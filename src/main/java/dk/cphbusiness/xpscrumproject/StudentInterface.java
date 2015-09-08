/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

/**
 *
 * @author Muggi
 */
public interface StudentInterface {
    
    void setName(String name);
    String getName();
    void setFirstPriority(Subject fag1, Subject fag2);
    void setSecondPriority(Subject fag3, Subject fag4);
    Subject[] getFirstPriority();
    Subject[] getSecondPriority();
    void setGrades(int first,int second);
    int[] getGrades();
    void setFirstGrade(int grade);
    void setSecondGrade(int grade);
    
}
