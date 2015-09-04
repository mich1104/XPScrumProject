/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.List;

/**
 *
 * @author Michael
 */
public class Controller implements ControllerInterface {

    private PoolInterface pool;
    
    public Controller(){
        pool = new Pool();
    }
    
    @Override
    public List<Fag> getUnassignedList() {
        return pool.getUnassignedPool();
    }

    @Override
    public List<Fag> getPoolAList() {
        return pool.getPoolA();
    }

    @Override
    public List<Fag> getPoolBList() {
        return pool.getPoolB();
    }

    @Override
    public void addtoPoolA(Fag fag) {
        pool.addToPoolA(fag);
    }

    @Override
    public Fag removeFromPoolA(Fag fag) {
        return pool.removeFromPoolA(fag);
    }

    @Override
    public void addtoPoolB(Fag fag) {
        pool.addToPoolB(fag);
    }

    @Override
    public Fag removeFromPoolB(Fag fag) {
        return pool.removeFromPoolB(fag);
    }

    @Override
    public void addToUnassigned(Fag fag) {
        pool.addToUnassigned(fag);
    }

    @Override
    public Fag removeFromUnassigned(Fag fag) {
        return pool.removeFromUnassignedPool(fag);
    }

    @Override
    public List<Student> calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Boolean submitPools(List<Fag> poolA, List<Fag> poolB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPool(PoolInterface pool){
        this.pool = pool;
    }
    
    public PoolInterface getPool(){
        return pool;
    }
}
