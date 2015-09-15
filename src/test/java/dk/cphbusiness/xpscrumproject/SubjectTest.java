package dk.cphbusiness.xpscrumproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dk.cphbusiness.xpscrumproject.entity.Subject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Muggi
 */
public class SubjectTest {

    Subject subject;

    public SubjectTest() {
        subject = new Subject("test","test","test");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setGetTitle() {
        String title = "Testtitle";
        subject.setTitle(title);
        String result = subject.getTitle();
        assertTrue(title.equals(result));
    }

    @Test
    public void setGetTeacher() {
        String teacher = "testTeacher";
        subject.setTeacher(teacher);
        String result = subject.getTeacher();
        assertTrue(teacher.equals(result));
    }
    
    @Test
    public void setGetDescription(){
        String description = "TestDescription";
        subject.setDescription(description);
        String result = subject.getDescription();
        assertTrue(description.equals(result));
    }
    
    @Test
    public void subjecToString(){
        assertTrue(subject.toString().equals("test"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
