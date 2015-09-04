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
    void setFirstPriority(Fag fag1, Fag fag2);
    void setSecondPriority(Fag fag3, Fag fag4);
    Fag[] getFirstPriority();
    Fag[] getSecondPriority();
    void setGrades(int first,int second);
    int[] getGrades();
    
}
