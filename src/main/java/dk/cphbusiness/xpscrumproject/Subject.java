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
public class Subject implements SubjectInterface {

    private String title;
    private String description;
    private String teacher;

    public Subject(String title, String description, String teacher) {
        this.title = title;
        this.description = description;
        this.teacher = teacher;
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getTeacher() {
        return teacher;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
