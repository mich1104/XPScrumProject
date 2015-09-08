/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Controller implements ControllerInterface {

    private Pool pool;
    private List<Student> students;
    private SatisfactionCalculator calc;
    private String[] subs;
    public Controller(){
        pool = new Pool();
        subs = new String[]{"C#", "Python", "Android", "SW Design", "Games", "Databases", "Test", "Arduino"};
        for(String s:subs){
            Subject subject = new Subject(s,"","");
            pool.addToUnassigned(subject);
        }
        calc = new SatisfactionCalculator();
        this.students = new ArrayList();
        loadStudents();
    }
    
    @Override
    public List<Subject> getUnassignedList() {
        return pool.getUnassignedPool();
    }

    @Override
    public List<Subject> getPoolAList() {
        return pool.getPoolA();
    }

    @Override
    public List<Subject> getPoolBList() {
        return pool.getPoolB();
    }

    @Override
    public void addtoPoolA(Subject fag) {
        pool.addToPoolA(fag);
    }

    @Override
    public Subject removeFromPoolA(Subject fag) {
        return pool.removeFromPoolA(fag);
    }

    @Override
    public void addtoPoolB(Subject fag) {
        pool.addToPoolB(fag);
    }

    @Override
    public Subject removeFromPoolB(Subject fag) {
        return pool.removeFromPoolB(fag);
    }

    @Override
    public void addToUnassigned(Subject fag) {
        pool.addToUnassigned(fag);
    }
    
    @Override
    public Subject removeFromUnassigned(Subject fag) {
        return pool.removeFromUnassignedPool(fag);
    }
    
    @Override
    public List<Student> calculate() {
       
        return  calc.calculate(students, pool.getPoolA(), pool.getPoolB()); 
    }
    
    @Override
    public void loadStudents(){
        
        try {
            students = CSVFileChooser.run();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            students = null;
        }
    }
    
    @Override
    public List<Student> getStudents(){
        return students;
    }
    
    @Override
    public Boolean submitPools(List<Subject> poolA, List<Subject> poolB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPool(Pool pool){
        this.pool = pool;
    }
    
    public PoolInterface getPool(){
        return pool;
    }

}
