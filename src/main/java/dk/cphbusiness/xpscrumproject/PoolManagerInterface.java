/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.List;

/**
 *
 * @author Dennis
 */
public interface PoolManagerInterface {
    boolean reset();
    List<Subject> getPoolA();
    List<Subject> getPoolB();
    List<Subject> getPoolC();
    List<Subject> getPoolUnassigned();
    
    void moveSubject(Subject subject,String from,String to);

    
}
