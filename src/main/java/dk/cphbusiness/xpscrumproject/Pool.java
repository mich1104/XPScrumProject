/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muggi
 */
public class Pool implements PoolInterface {

    private List<Subject> unassignedPool;
    private List<Subject> poolA;
    private List<Subject> poolB;
    private List<Subject> poolC;

    public Pool() {
        this.unassignedPool = new ArrayList();
        this.poolA = new ArrayList();
        this.poolB = new ArrayList();
        this.poolC = new ArrayList();
    }

    @Override
    public void setUnassignedPool(List<Subject> list) {
        unassignedPool = list;
    }

    @Override
    public List<Subject> getUnassignedPool() {
        return unassignedPool;
    }

    @Override
    public void addToPoolA(Subject fag) {
        poolA.add(fag);
    }

    @Override
    public List<Subject> getPoolA() {
        return poolA;
    }

    @Override
    public void addToPoolB(Subject fag) {
        poolB.add(fag);
    }

    @Override
    public List<Subject> getPoolB() {
        return poolB;
    }

    @Override
    public Subject removeFromPoolA(Subject fag) {
        if (poolA.contains(fag)) {
            poolA.remove(fag);
            return fag;
        } else {
            return null;
        }

    }

    @Override
    public Subject removeFromPoolB(Subject fag) {
        if (poolB.contains(fag)) {
            poolB.remove(fag);
            return fag;
        } else {
            return null;
        }
    }

    @Override
    public Subject removeFromUnassignedPool(Subject fag) {
        if (unassignedPool.contains(fag)) {
            unassignedPool.remove(fag);
            return fag;
        } else {
            return null;
        }
    }

    @Override
    public void addToUnassigned(Subject fag) {
        unassignedPool.add(fag);
    }

    @Override
    public void addToPoolC(Subject fag) {
        poolC.add(fag);
    }

    @Override
    public List<Subject> getPoolC() {
        return poolC;
    }

    @Override
    public Subject removeFromPoolC(Subject fag) {
        if (poolC.contains(fag)) {
            poolC.remove(fag);
            return fag;
        } else {
            return null;
        }
    }

}
