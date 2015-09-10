package dk.cphbusiness.xpscrumproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.cphbusiness.xpscrumproject.Subject;
import dk.cphbusiness.xpscrumproject.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Muggi
 */
public class StudentTest {

    Student student;

    public StudentTest() {
        student = new Student("Test");
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
    public void setGetFirstPriorities() {
        Subject fag1 = new Subject("test1", "test1", "test1");
        Subject fag2 = new Subject("test2", "test2", "test2");
        Subject fag3 = new Subject("test3", "test3", "test3");

        student.setFirstPriority(fag1, fag2, fag3);
        Subject[] array = student.getFirstPriority();
        assertTrue(array[0].equals(fag1));
        assertTrue(array[1].equals(fag2));
        assertTrue(array[2].equals(fag3));

    }

    @Test
    public void setGetSecondPriorities() {
        Subject fag1 = new Subject("test1", "test1", "test1");
        Subject fag2 = new Subject("test2", "test2", "test2");
        Subject fag3 = new Subject("test3", "test3", "test3");
        student.setSecondPriority(fag1, fag2, fag3);
        Subject[] array = student.getSecondPriority();
        assertTrue(array[0].equals(fag1));
        assertTrue(array[1].equals(fag2));
        assertTrue(array[2].equals(fag3));
    }

    @Test
    public void setGetName() {
        String name = "kurt";
        student.setName(name);
        String result = student.getName();
        assertTrue(name.equals(result));
    }

    @Test
    public void setGetGrades() {
        int first = 1;
        int second = 2;
        int third = 0;
        student.setGrades(first, second, third);
        int[] result = student.getGrades();
        assertTrue(result.length == 3);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 2);
        assertTrue(result[2] == 0);
        student.setFirstGrade(3);
        student.setSecondGrade(4);
        student.setThirdGrade(5);
        int[] result2 = student.getGrades();
        assertTrue(result2.length == 3);
        assertTrue(result2[0] == 3);
        assertTrue(result2[1] == 4);
        assertTrue(result2[2] == 5);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
