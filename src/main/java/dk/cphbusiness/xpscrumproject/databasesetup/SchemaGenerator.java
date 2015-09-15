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
    }

}
