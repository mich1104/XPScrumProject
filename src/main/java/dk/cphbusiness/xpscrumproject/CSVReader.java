/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.interfaces.CSVReaderInterface;
import dk.cphbusiness.xpscrumproject.entity.Student;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class CSVReader implements CSVReaderInterface{
    
    private String path = "";
    private String attributeSeperator = ",";
    private String studentSeperator = ";";
    
    public CSVReader(){
        
    }

    @Override
    public ArrayList<Student> loadStudents(String path) throws IOException{
        //throw new UnsupportedOperationException("Not supported yet.");
       this.path = path;
       
       BufferedReader br;
       String line;
       String fullDocument = "";
       String[] students;
       ArrayList<Student> arrayForReturn = new ArrayList<>();
       
       try{
           br = new BufferedReader(new FileReader(path));
           while ((line = br.readLine()) != null){
               fullDocument = fullDocument.concat(line);
           }
       } catch (IOException e) {
            throw new FileNotFoundException("File not found at "+path);
       }
       
       students = fullDocument.split(studentSeperator);
       for(String studentAsString : students){
           
           String[] attributes = studentAsString.split(attributeSeperator);
           
           String name = attributes[0];
           String firstPrioOne = attributes[1];
           String firstPrioTwo = attributes[2];
           String firstPrioThird = attributes[3];
           
           String secondPrioOne = attributes[4];
           String secondPrioTwo = attributes[5];
           String secondPrioThird = attributes[6];
           
           Student student = new Student(name);
           student.setFirstPriorities(new Subject(firstPrioOne, null, null), new Subject(firstPrioTwo, null, null),new Subject(firstPrioThird,null,null));
           student.setSecondPriorities(new Subject(secondPrioOne, null, null), new Subject(secondPrioTwo, null, null),new Subject(secondPrioThird,null,null));
           
           arrayForReturn.add(student);
       }
       
       return arrayForReturn;
        
    }

    @Override
    public String getPath() {
        return path;
    }
    
}
