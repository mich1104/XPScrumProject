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

    private List<Fag> unassignedPool;
    private List<Fag> poolA;
    private List<Fag> poolB;

    public Pool() {
        this.unassignedPool = new ArrayList();
        this.poolA = new ArrayList();
        this.poolB = new ArrayList();
    }

    @Override
    public void setUnassignedPool(List<Fag> list) {
        unassignedPool = list;
    }

    @Override
    public List<Fag> getUnassignedPool() {
        return unassignedPool;
    }

    @Override
    public void addToPoolA(Fag fag) {
        poolA.add(fag);
    }

    @Override
    public List<Fag> getPoolA() {
        return poolA;
    }

    @Override
    public void addToPoolB(Fag fag) {
        poolB.add(fag);
    }

    @Override
    public List<Fag> getPoolB() {
        return poolB;
    }

    @Override
    public Fag removeFromPoolA(Fag fag) {
        if (poolA.contains(fag)) {
            poolA.remove(fag);
            return fag;
        } else {
            return null;
        }

    }

    @Override
    public Fag removeFromPoolB(Fag fag) {
        if (poolB.contains(fag)) {
            poolB.remove(fag);
            return fag;
        } else {
            return null;
        }
    }

    @Override
    public Fag removeFromUnassignedPool(Fag fag) {
        if (unassignedPool.contains(fag)) {
            unassignedPool.remove(fag);
            return fag;
        } else {
            return null;
        }
    }

    @Override
    public void addToUnassigned(Fag fag) {
        unassignedPool.add(fag);
    }

}
