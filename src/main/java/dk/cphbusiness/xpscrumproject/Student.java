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
    private Subject[] firstPriority = new Subject[3];
    private Subject[] secondPriority = new Subject[3];
    private int[] grades;

    public Student(String name) {
        this.name = name;
        this.grades = new int[]{0, 0,0};
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
    public void setFirstPriority(Subject fag1, Subject fag2,Subject fag3) {
        firstPriority[0] = fag1;
        firstPriority[1] = fag2;
        firstPriority[2] = fag3;
    }

    @Override
    public void setSecondPriority(Subject fag3, Subject fag4, Subject fag5) {
        secondPriority[0] = fag3;
        secondPriority[1] = fag4;
        secondPriority[2] = fag5;
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

}
