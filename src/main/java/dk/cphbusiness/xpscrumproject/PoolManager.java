package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.interfaces.PoolManagerInterface;
import dk.cphbusiness.xpscrumproject.entity.Pool;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dennis
 */
public class PoolManager implements PoolManagerInterface {

    private Pool poolA;
    private Pool poolB;
    private Pool poolC;
    private Pool poolUnassigned;

    public PoolManager() {
        poolA = new Pool("A");
        poolB = new Pool("B");
        poolC = new Pool("C");
        poolUnassigned = new Pool("Unassigned");
    }

    @Override
    public boolean reset() {
        List<Subject> all = new ArrayList();

        all.addAll(poolA.removeAll());
        all.addAll(poolB.removeAll());
        all.addAll(poolC.removeAll());

        poolUnassigned.addToPool(all);
        
        return true;
    }

    @Override
    public List<Subject> getPoolA() {
        return poolA.getPool();
    }

    @Override
    public List<Subject> getPoolB() {
        return poolB.getPool();
    }

    @Override
    public List<Subject> getPoolC() {
        return poolC.getPool();
    }

    @Override
    public List<Subject> getPoolUnassigned() {
        return poolUnassigned.getPool();
    }

    @Override
    public void moveSubject(Subject subject, String from, String to) {

        Subject s;
        if (from.equals("A")) {
            s = poolA.removeFromPool(subject);
        } else if (from.equals("B")) {
            s = poolB.removeFromPool(subject);
        } else if (from.equals("C")) {
            s = poolC.removeFromPool(subject);
        } else if (from.equals("Unassigned")) {
            s = poolUnassigned.removeFromPool(subject);
        } else {
            s = null;
        }
        if (s != null) {
            if (to.equals("A")) {
                poolA.addToPool(s);
            } else if (to.equals("B")) {
                poolB.addToPool(s);
            } else if (to.equals("C")) {
                poolC.addToPool(s);
            } else if (to.equals("Unassigned")) {
                poolUnassigned.addToPool(s);
            }
        }
    }

    public List<Pool> getAllPools(){
        List<Pool> pools = new ArrayList();
        pools.add(poolA);
        pools.add(poolB);
        pools.add(poolC);
        pools.add(poolUnassigned);
        
        return pools;
    }
    
    public void setPools(Pool a, Pool b, Pool c, Pool u){
        poolA = a;
        poolB = b;
        poolC = c;
        poolUnassigned = u;
    }
    
}
