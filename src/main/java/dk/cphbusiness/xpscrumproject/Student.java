/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

/**
 *
 * @author Muggi
 */
public class Student implements StudentInterface {

    private String name;
    private Fag[] firstPriority = new Fag[2];
    private Fag[] secondPriority = new Fag[2];

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setFirstPriority(Fag fag1, Fag fag2) {
        firstPriority[0] = fag1;
        firstPriority[1] = fag2;
    }

    @Override
    public void setSecondPriority(Fag fag3, Fag fag4) {
        secondPriority[0] = fag3;
        secondPriority[1] = fag4;
    }

    @Override
    public Fag[] getFirstPriority() {
        return firstPriority;
    }

    @Override
    public Fag[] getSecondPriority() {
        return secondPriority;
    }

}
