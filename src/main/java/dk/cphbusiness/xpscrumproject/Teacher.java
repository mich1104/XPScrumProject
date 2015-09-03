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
public class Teacher implements TeacherInterface{

    private String name;

    public Teacher(String name) {
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
    
}
