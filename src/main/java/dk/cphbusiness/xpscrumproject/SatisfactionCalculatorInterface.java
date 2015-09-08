/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muggi
 */
public interface SatisfactionCalculatorInterface {
    
    List<Student> calculate(List<Student> slist,List<Subject> poolA,List<Subject> poolB);
    List<Student> sortList(List<Student> slist);
    
}
