/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.entity;

import dk.cphbusiness.xpscrumproject.interfaces.PoolInterface;
import dk.cphbusiness.xpscrumproject.entity.Subject;
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
    private String name;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Subject> pool;

    public Pool() {
        this.pool = new ArrayList();
    }

    public Pool(String name) {
        this.name = name;
        this.pool = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void addToPool(Subject fag) {
        pool.add(fag);
        fag.setPool(this);
    }

    @Override
    public List<Subject> getPool() {
        return pool;
    }

    @Override
    public Subject removeFromPool(Subject fag) {
        if (pool.contains(fag)) {
            pool.remove(fag);
            return fag;
        } else {
            return null;
        }
    }
    
       public void setPool(List<Subject> poolC) {
        this.pool = poolC;
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
    public List<Subject> removeAll() {
        
        List<Subject> temp = new ArrayList(); 
        temp.addAll(pool);
        pool.removeAll(temp);
        return temp;
    }

    @Override
    public void addToPool(List<Subject> fag) {
        pool.addAll(fag);
    }

}
