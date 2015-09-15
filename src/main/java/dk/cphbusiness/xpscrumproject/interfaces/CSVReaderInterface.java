/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.interfaces;

import dk.cphbusiness.xpscrumproject.entity.Student;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public interface CSVReaderInterface {
    public ArrayList<Student> loadStudents(String path) throws IOException;
    public String getPath();
}
