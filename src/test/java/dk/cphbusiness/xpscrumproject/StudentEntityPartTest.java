/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class StudentEntityPartTest {
    
    Student student;

    public StudentEntityPartTest() {
        
    }
    
    @Test
    public void testEntityConstructor(){
        student = new Student();
        assertThat(student.getGrades()[0], is(0));
        assertThat(student.getGrades()[1], is(0));
        assertThat(student.getGrades()[2], is(0));
        assertNull(student.getName());
        assertNotNull(student.getId());
    }
    
    @Test
    public void testSetGetGrades(){
        student = new Student();
        int[] grades = new int[]{1,1,1};
        student.setGrades(grades);
        assertThat(student.getGrades(), is(grades));
    }
    
    @Test
    public void testSetGetPriority(){
        List<Subject> list = new ArrayList();
        list.add(new Subject("test", null, null));
        student = new Student();
        student.setFirstPriority(list);
        assertThat(student.getFirstPriority(), is(list));
        student.setSecondPriority(list);
        assertThat(student.getSecondPriority(), is(list));
    }
    
    @Test
    public void testSetGetIdHashCodeAndToString(){
        student = new Student();
        int id = 987654321;
        student.setId(id);
        assertThat(student.getId(), is(id));
        int hashCode = 0;
        hashCode +=id;
        assertThat(student.hashCode(), is(hashCode));
        String studentToString = "dk.cphbusiness.xpscrumproject.StudentEntity[ id=" + id + " ]";
        assertThat(student.toString(), is(studentToString));
    }
    
    @Test
    public void testEquals(){
        student = new Student();
        student.setId(987654321);
        Object notStudent = new Object();
        assertFalse(student.equals(notStudent));
        Student anotherStudent = new Student();
        anotherStudent.setId(123456789);
        assertFalse(student.equals(anotherStudent));
        assertTrue(student.equals(student));
        
    }
}
