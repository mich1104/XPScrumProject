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
public class SubjectEntityPartTest {
    
    Subject subject;
    Pool pool;
    
    public SubjectEntityPartTest() {
    }
    
    @Test
    public void setGetPool(){
        subject = new Subject();
        pool = new Pool("");
        subject.setPool(pool);
        Pool result = subject.getPool();
        assertThat(result.equals(pool),is(true));
    }
    
    @Test
    public void testEntityConstructor(){
        subject = new Subject();
        assertNull(subject.getTitle());
        assertNull(subject.getDescription());
        assertNull(subject.getTeacher());
        assertNull(subject.getStudentFirstPrio());
        assertNull(subject.getStudentSecondPrio());
        assertNotNull(subject.getId());
    }
    
    @Test
    public void testSetGetStudentPriority(){
        List<Student> list = new ArrayList();
        list.add(new Student("name"));
        subject = new Subject();
        subject.setStudentFirstPrio(list);
        assertThat(subject.getStudentFirstPrio(), is(list));
        subject.setStudentSecondPrio(list);
        assertThat(subject.getStudentSecondPrio(), is(list));
    }
    
    @Test
    public void testSetGetIdHashCodeAndToString(){
        subject = new Subject();
        int id = 987654321;
        subject.setId(id);
        assertThat(subject.getId(), is(id));
        int hashCode = 0;
        hashCode +=id;
        assertThat(subject.hashCode(), is(hashCode));
        String subjectToString = "testTitle";
        subject.setTitle(subjectToString);
        assertThat(subject.toString(), is(subjectToString));
    }
    
    @Test
    public void testEquals(){
        subject = new Subject();
        subject.setId(987654321);
        Object notSubject = new Object();
        assertFalse(subject.equals(notSubject));
        Subject anotherSubject = new Subject();
        anotherSubject.setId(123456789);
        assertFalse(subject.equals(anotherSubject));
        assertTrue(subject.equals(subject));
    }
}
