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
public interface CSVFileSaverInterface {
    
    boolean saveFile(boolean manualSave, List<Subject> unaPool, List<Subject> poolA, List<Subject> poolB);
    
}
