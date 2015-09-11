/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.databasesetup;

import dk.cphbusiness.xpscrumproject.DBFacade;
import dk.cphbusiness.xpscrumproject.Pool;
import dk.cphbusiness.xpscrumproject.Subject;
import java.util.ArrayList;
import javax.persistence.Persistence;

/**
 *
 * @author Michael
 */
public class SchemaGenerator {

    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
        DBFacade dbf = new DBFacade(false);
        Subject s1 = new Subject("AI", null, null);
        Subject s2 = new Subject("Haskell", null, null);
        Subject s3 = new Subject("COBOL", null, null);
        Subject s4 = new Subject("Android", null, null);
        Subject s5 = new Subject("Arduino", null, null);
        Subject s6 = new Subject("C#", null, null);
        Subject s7 = new Subject("Test", null, null);
        Pool p = new Pool();
        
        
        
    }

}
