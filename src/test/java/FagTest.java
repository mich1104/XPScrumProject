/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.cphbusiness.xpscrumproject.Fag;
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
public class FagTest {

    Fag fag;

    public FagTest() {
        fag = new Fag("test","test","test");
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
        fag.setTitle(title);
        String result = fag.getTitle();
        assertTrue(title.equals(result));
    }

    @Test
    public void setGetTeacher() {
        String teacher = "testTeacher";
        fag.setTeacher(teacher);
        String result = fag.getTeacher();
        assertTrue(teacher.equals(result));
    }
    
    @Test
    public void setGetDescription(){
        String description = "TestDescription";
        fag.setDescription(description);
        String result = fag.getDescription();
        assertTrue(description.equals(result));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
