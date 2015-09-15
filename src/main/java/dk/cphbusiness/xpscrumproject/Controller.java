/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.interfaces.ControllerInterface;
import dk.cphbusiness.xpscrumproject.entity.Pool;
import dk.cphbusiness.xpscrumproject.entity.Student;
import dk.cphbusiness.xpscrumproject.entity.Subject;
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

    private PoolManager pm;
    private DBFacade dbf;
    private CSVFileSaver csvSaver;
    private List<Student> students;
    private SatisfactionCalculator calc;
    private String[] subs;
    
   
    public Controller(boolean test){
        dbf = new DBFacade(test);
        pm = new PoolManager();
        csvSaver = new CSVFileSaver();
        calc = new SatisfactionCalculator();
        this.students = new ArrayList();
    }
    
    @Override
    public void loadDB(){
        pm.getPoolUnassigned().addAll(dbf.getAllSubjects());
        List<Pool> pool = dbf.getPools();
        pm.setPools(pool.get(0), pool.get(1), pool.get(2), pool.get(3));
    }
    
    @Override
    public List<Subject> getUnassignedList() {
        return pm.getPoolUnassigned();
    }

    @Override
    public List<Subject> getPoolAList() {
        return pm.getPoolA();
    }

    @Override
    public List<Subject> getPoolBList() {
        return pm.getPoolB();
    }

    @Override
    public List<Subject> getPoolCList() {
        return pm.getPoolC();
    }
    
    @Override
    public List<Student> calculate() {
       
        return  calc.calculate(students, pm.getPoolA(), pm.getPoolB(),pm.getPoolC()); 
    }
    
    @Override
    public void loadStudents(String fileName){
        
        try {
            students = CSVFileChooser.run(fileName);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            students = new ArrayList<>();
        }
    }
    
    @Override
    public List<Student> getStudents(){
        return students;
    }
    
    @Override
    public Boolean submitPools() {
//        return csvSaver.saveFile(manual, pm.getPoolUnassigned(), pm.getPoolA(), pm.getPoolB(),pm.getPoolC());
        dbf.createPool(pm.getAllPools());
        return true;
    }


    @Override
    public void moveFromTo(Subject fag, String from, String to) {
        pm.moveSubject(fag, from, to);
    }

    @Override
    public boolean resetPools() {
        return pm.reset();
    }

    public PoolManager getPm() {
        return pm;
    }

    public void setPm(PoolManager pm) {
        this.pm = pm;
    }
    
    

}
