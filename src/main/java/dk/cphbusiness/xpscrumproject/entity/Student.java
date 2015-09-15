/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.entity;

import dk.cphbusiness.xpscrumproject.interfaces.StudentInterface;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author Michael
 */
@Entity
public class Student implements Serializable, StudentInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @ManyToMany(mappedBy = "studentFirstPrio", cascade = CascadeType.ALL)
    private List<Subject> firstPriority = new ArrayList();
    @ManyToMany(mappedBy = "studentSecondPrio", cascade = CascadeType.ALL)
    private List<Subject> secondPriority = new ArrayList();
    @Transient
    private int[] grades;

    public Student(){
        this.grades = new int[]{0,0,0};
    }
    
    public Student(String name) {
        this.name = name;
        this.grades = new int[]{0,0,0};
    }
    @Override
    public void setFirstPriorities(Subject fag1, Subject fag2,Subject fag3) {
        firstPriority.add(fag1);
        firstPriority.add(fag2);
        firstPriority.add(fag3);
    }

    @Override
    public void setSecondPriorities(Subject fag3, Subject fag4, Subject fag5) {
        secondPriority.add(fag3);
        secondPriority.add(fag4);
        secondPriority.add(fag5);
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    @Override
    public List<Subject> getFirstPriority() {
        return firstPriority;
    }

    @Override
    public List<Subject> getSecondPriority() {
        return secondPriority;
    }

    @Override
    public void setGrades(int first, int second,int third) {
        grades[0] = first;
        grades[1] = second;
        grades[2] = third;
    }

    @Override
    public int[] getGrades() {
        return grades;
    }

    @Override
    public void setFirstGrade(int grade) {
        grades[0] = grade;
    }

    @Override
    public void setSecondGrade(int grade) {
        grades[1] = grade;
    }

    @Override
    public void setThirdGrade(int grade) {
        grades[2] = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstPriority(List<Subject> firstPriority) {
        this.firstPriority = firstPriority;
    }

    public void setSecondPriority(List<Subject> secondPriority) {
        this.secondPriority = secondPriority;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.xpscrumproject.StudentEntity[ id=" + id + " ]";
    }
    
}
