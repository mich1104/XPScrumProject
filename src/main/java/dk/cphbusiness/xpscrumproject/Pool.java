/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Michael
 */
@Entity
public class Pool implements Serializable, PoolInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Subject> unassignedPool;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Subject> poolA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Subject> poolB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Subject> poolC;

    public Pool() {
        this.unassignedPool = new ArrayList();
        this.poolA = new ArrayList();
        this.poolB = new ArrayList();
        this.poolC = new ArrayList();
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
    
    public List<Subject> getUnassignedPool() {
        return unassignedPool;
    }

    public void setUnassignedPool(List<Subject> unassignedPool) {
        this.unassignedPool = unassignedPool;
    }

    public void setPoolA(List<Subject> poolA) {
        this.poolA = poolA;
    }

    public void setPoolB(List<Subject> poolB) {
        this.poolB = poolB;
    }

    public void setPoolC(List<Subject> poolC) {
        this.poolC = poolC;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pool)) {
            return false;
        }
        Pool other = (Pool) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.xpscrumproject.PoolEntity[ id=" + id + " ]";
    }
    
    @Override
    public boolean reset() {
        List<Subject> reset = new ArrayList();
        reset.addAll(unassignedPool);
        reset.addAll(poolA);
        reset.addAll(poolB);
        reset.addAll(poolC);
        poolA = new ArrayList();
        poolB = new ArrayList();
        poolC = new ArrayList();
        unassignedPool = reset;
        return true;
        
    }

}
