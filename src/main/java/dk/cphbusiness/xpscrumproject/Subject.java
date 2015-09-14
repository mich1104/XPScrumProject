/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Michael
 */
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @Transient
    private String description;
    @Transient
    private String teacher;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> studentFirstPrio;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> studentSecondPrio;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Pool pool;
    


    public Subject() {
    }

    public Subject(String title, String description, String teacher ) {
        this.title = title;
        this.description = description;
        this.teacher = teacher;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentFirstPrio() {
        return studentFirstPrio;
    }

    public void setStudentFirstPrio(List<Student> studentFirstPrio) {
        this.studentFirstPrio = studentFirstPrio;
    }

    public List<Student> getStudentSecondPrio() {
        return studentSecondPrio;
    }

    public void setStudentSecondPrio(List<Student> studentSecondPrio) {
        this.studentSecondPrio = studentSecondPrio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
