/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.interfaces.CSVReaderInterface;
import dk.cphbusiness.xpscrumproject.entity.Student;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


/**
 *
 * @author Michael
 */
public class CSVReaderTest {
    
    public CSVReaderTest() {
        /*
        *   Testing that the FileReader can return a list of Students
        *
        */
    }
    
    @Test
    public void testCreateCSVReader(){
        
        CSVReader reader = new CSVReader();
        
        //Path should be empty
        //The splitter should be "," as default
        
        assertThat(reader.getPath(), is(""));
    }
    
    @Test
    public void testLoadStudents() throws Exception{
        CSVReaderInterface reader = new CSVReader();
        String path = "src/testCSVFile.csv";
        
        try{
            createTestFile(path);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            fail("Failed to create test CSV-file");
        }
        
        List<Student> students;
        students = reader.loadStudents(path);
        
        assertThat(reader.getPath(), is(path));
        assertThat(students.size(), is(2));
        
    }
    
    @Test(expected = IOException.class)
    public void testExceptionIfFileNotFound() throws Exception{
        String path = "This path does not exist";
        CSVReaderInterface reader = new CSVReader();
        reader.loadStudents(path);
    }
    
    public void createTestFile(String path) throws IOException{
        String toFile = "name, prio1.1, prio1.2,prio1,3, prio2.1, prio2.2, prio2.3;name2, prio1.1, prio1.2,prio1,3, prio2.1, prio2.2";
        PrintWriter pw = new PrintWriter(path);
        pw.print(toFile);
        pw.flush();
        pw.close();
    }
   
}
