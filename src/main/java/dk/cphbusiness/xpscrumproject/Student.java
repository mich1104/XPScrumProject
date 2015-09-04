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
    private Subject[] firstPriority = new Subject[2];
    private Subject[] secondPriority = new Subject[2];
    private int[] grades;

    public Student(String name) {
        this.name = name;
        this.grades = new int[]{0,0};
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
    public void setFirstPriority(Subject fag1, Subject fag2) {
        firstPriority[0] = fag1;
        firstPriority[1] = fag2;
    }

    @Override
    public void setSecondPriority(Subject fag3, Subject fag4) {
        secondPriority[0] = fag3;
        secondPriority[1] = fag4;
    }

    @Override
    public Subject[] getFirstPriority() {
        return firstPriority;
    }

    @Override
    public Subject[] getSecondPriority() {
        return secondPriority;
    }

    @Override
    public void setGrades(int first, int second) {
        grades[0] = first;
        grades[1] = second;
    }

    @Override
    public int[] getGrades() {
        return grades;
    }

}
