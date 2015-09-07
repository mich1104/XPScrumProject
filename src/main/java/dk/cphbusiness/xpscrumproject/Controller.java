/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Controller implements ControllerInterface {

    private PoolInterface pool;
    private List<StudentInterface> students;
    private CSVReaderInterface csv;
    
    public Controller(){
        pool = new Pool();
        csv = new CSVReader();
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
    public void calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void loadStudents(){
        
        try {
            students = csv.loadStudents("src/students.csv");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<StudentInterface> getStudents(){
        return students;
    }
    
    @Override
    public Boolean submitPools(List<Subject> poolA, List<Subject> poolB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPool(PoolInterface pool){
        this.pool = pool;
    }
    
    public PoolInterface getPool(){
        return pool;
    }
    
    public void setReader(CSVReaderInterface csv){
        this.csv = csv;
    }
    
    public CSVReaderInterface getReader(){
        return csv;
    }
}
