/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;
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
public class SatisfactionCalculatorTest {

    private SatisfactionCalculator calc;
    private ArrayList<Student> studentlist = new ArrayList();
    private ArrayList<Subject> poolA = new ArrayList();
    private ArrayList<Subject> poolB = new ArrayList();

    private Student student12 = new Student("Kurt");
    private Student student20 = new Student("Kirsten");
    private Student student11 = new Student("Mikkel");
    private Student student22 = new Student("Karsten");
    private Student student10 = new Student("Kresten");
    private Student student00 = new Student("Karoline");
    
    private Subject subject1 = new Subject("Teori", "test", "test");
    private Subject subject2 = new Subject("Praktik", "test", "test");
    private Subject subject3 = new Subject("Fri", "test", "test");
    private Subject subject4 = new Subject("Lol", "test", "test");
    private Subject notfound1 = new Subject("Kagebagning", "test", "test");

    public SatisfactionCalculatorTest() {
        calc = new SatisfactionCalculator();
        student12.setFirstPriority(notfound1, subject1);
        student12.setSecondPriority(subject2, subject4);
        student20.setFirstPriority(notfound1, notfound1);
        student20.setSecondPriority(subject3, notfound1);
        student11.setFirstPriority(subject1, subject3);
        student11.setSecondPriority(notfound1, notfound1);
        student22.setFirstPriority(notfound1, notfound1);
        student22.setSecondPriority(subject3, subject1);
        student10.setFirstPriority(subject3, notfound1);
        student10.setSecondPriority(notfound1, notfound1);
        student00.setFirstPriority(notfound1, notfound1);
        student00.setSecondPriority(notfound1, notfound1);
        studentlist.add(student12);
        studentlist.add(student20);
        studentlist.add(student10);
        studentlist.add(student22);
        studentlist.add(student11);
        studentlist.add(student00);
        
        poolA.add(subject1);
        poolA.add(subject2);
        poolB.add(subject3);
        poolB.add(subject4);
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
    public void calculate() {
        List<Student> list = calc.calculate(studentlist, poolA, poolB);
        assertTrue(studentlist != null);
        
        assertTrue(student12.getGrades()[0] == 1);
        assertTrue(student12.getGrades()[1] == 2);
        
        assertTrue(student20.getGrades()[0]== 2);
        assertTrue(student20.getGrades()[1]== 0);
        
        assertTrue(student22.getGrades()[0]== 2);
        assertTrue(student22.getGrades()[1]== 2);
        
        assertTrue(student11.getGrades()[0]== 1);
        assertTrue(student11.getGrades()[1]== 1);
        
        assertTrue(student00.getGrades()[0]== 0);
        assertTrue(student00.getGrades()[1]== 0);

        assertTrue(student10.getGrades()[0]== 1);
        assertTrue(student10.getGrades()[1]== 0);
    }
}
