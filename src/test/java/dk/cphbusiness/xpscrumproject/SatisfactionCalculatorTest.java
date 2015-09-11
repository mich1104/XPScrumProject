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
    private ArrayList<Subject> poolC = new ArrayList();

    private Student student111;
    private Student student112;
    private Student student122;
    private Student student222;
    private Student student110;
    private Student student120;
    private Student student220;
    private Student student100;
    private Student student200;
    private Student student000;
    private Student student200E;

    private Subject subject1 = new Subject("Teori", "test", "test");
    private Subject subject2 = new Subject("Praktik", "test", "test");
    private Subject subject3 = new Subject("Fri", "test", "test");
    private Subject subject4 = new Subject("Pille navle", "test", "test");
    private Subject subject5 = new Subject("Næsepilning", "test", "test");
    private Subject subject6 = new Subject("Vaske hænder", "test", "test");
    private Subject notFound = new Subject("Kagebagning", "test", "test");

    public SatisfactionCalculatorTest() {
        calc = new SatisfactionCalculator();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        student111 = new Student("Kurt");
        student112 = new Student("Kirsten");
        student122 = new Student("Kristoffer");
        student222 = new Student("Karsten");
        student110 = new Student("Kresten");
        student120 = new Student("Karoline");
        student220 = new Student("Karina");
        student100 = new Student("Kristian");
        student200 = new Student("Kamilla");
        student000 = new Student("Kasper");
        student200E = new Student("Kent");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void sortListTest() {
        student111.setGrades(1, 1, 1);
        student112.setGrades(1, 1, 2);
        student122.setGrades(1, 2, 2);
        student222.setGrades(2, 2, 2);
        student110.setGrades(1, 1, 0);
        student120.setGrades(1, 2, 0);
        student220.setGrades(2, 2, 0);
        student100.setGrades(1, 0, 0);
        student200.setGrades(2, 0, 0);
        student000.setGrades(0, 0, 0);

        List<Student> sList = new ArrayList();
        sList.add(student111);
        sList.add(student112);
        sList.add(student122);
        sList.add(student222);
        sList.add(student110);
        sList.add(student120);
        sList.add(student220);
        sList.add(student100);
        sList.add(student200);
        sList.add(student000);

        List<Student> resultList = calc.sortList(sList);

        assertTrue(resultList.get(0).getGrades()[0] == 0);
        assertTrue(resultList.get(0).getGrades()[1] == 0);
        assertTrue(resultList.get(0).getGrades()[2] == 0);

        assertTrue(resultList.get(1).getGrades()[0] == 2);
        assertTrue(resultList.get(1).getGrades()[1] == 0);
        assertTrue(resultList.get(1).getGrades()[2] == 0);

        assertTrue(resultList.get(2).getGrades()[0] == 1);
        assertTrue(resultList.get(2).getGrades()[1] == 0);
        assertTrue(resultList.get(2).getGrades()[2] == 0);

        assertTrue(resultList.get(3).getGrades()[0] == 2);
        assertTrue(resultList.get(3).getGrades()[1] == 2);
        assertTrue(resultList.get(3).getGrades()[2] == 0);

        assertTrue(resultList.get(4).getGrades()[0] == 1);
        assertTrue(resultList.get(4).getGrades()[1] == 2);
        assertTrue(resultList.get(4).getGrades()[2] == 0);

        assertTrue(resultList.get(5).getGrades()[0] == 1);
        assertTrue(resultList.get(5).getGrades()[1] == 1);
        assertTrue(resultList.get(5).getGrades()[2] == 0);

        assertTrue(resultList.get(6).getGrades()[0] == 2);
        assertTrue(resultList.get(6).getGrades()[1] == 2);
        assertTrue(resultList.get(6).getGrades()[2] == 2);

        assertTrue(resultList.get(7).getGrades()[0] == 1);
        assertTrue(resultList.get(7).getGrades()[1] == 2);
        assertTrue(resultList.get(7).getGrades()[2] == 2);

        assertTrue(resultList.get(8).getGrades()[0] == 1);
        assertTrue(resultList.get(8).getGrades()[1] == 1);
        assertTrue(resultList.get(8).getGrades()[2] == 2);

        assertTrue(resultList.get(9).getGrades()[0] == 1);
        assertTrue(resultList.get(9).getGrades()[1] == 1);
        assertTrue(resultList.get(9).getGrades()[2] == 1);

    }

    @Test
    public void calculate() {
        student111.setFirstPriorities(subject1, subject2, subject3);
        student111.setSecondPriorities(notFound,notFound,notFound);
        
        student112.setFirstPriorities(notFound, subject2, subject3);
        student112.setSecondPriorities(subject1, notFound, notFound);
        
        student122.setFirstPriorities(notFound, notFound, subject3);
        student122.setSecondPriorities(subject1, subject2, notFound);
        
        student220.setFirstPriorities(notFound, notFound, notFound);
        student220.setSecondPriorities(subject1, notFound, subject3);
        
        student120.setFirstPriorities(notFound, subject2, notFound);
        student120.setSecondPriorities(subject1, notFound, notFound);
        
        student200.setFirstPriorities(notFound, notFound, notFound);
        student200.setSecondPriorities(notFound, subject2, notFound);
        
        student200E.setFirstPriorities(notFound, notFound, notFound);
        student200E.setSecondPriorities(notFound, notFound, subject3);
        
        student222.setFirstPriorities(notFound, notFound, notFound);
        student222.setSecondPriorities(subject1, subject2, subject3);
        
        student100.setFirstPriorities(subject1, notFound, notFound);
        student100.setSecondPriorities(notFound, notFound, notFound);
        
        student000.setFirstPriorities(notFound, notFound, notFound);
        student000.setSecondPriorities(notFound, notFound, notFound);
        
        student110.setFirstPriorities(notFound, subject2, subject3);
        student110.setSecondPriorities(notFound, notFound, notFound);
        
        studentlist.add(student111);
        studentlist.add(student112);
        studentlist.add(student122);
        studentlist.add(student220);
        studentlist.add(student120);
        studentlist.add(student200);
        studentlist.add(student200E);
        studentlist.add(student222);
        studentlist.add(student100);
        studentlist.add(student000);
        studentlist.add(student110);

        poolA.add(subject1);
        poolB.add(subject2);
        poolC.add(subject3);

        List<Student> list = calc.calculate(studentlist, poolA, poolB, poolC);
        
        assertTrue(studentlist != null);
        
        assertTrue(student111.getGrades()[0]==1);
        assertTrue(student111.getGrades()[1]==1);
        assertTrue(student111.getGrades()[2]==1);
        
        assertTrue(student112.getGrades()[0]==1);
        assertTrue(student112.getGrades()[1]==1);
        assertTrue(student112.getGrades()[2]==2);
        
        assertTrue(student122.getGrades()[0]==1);
        assertTrue(student122.getGrades()[1]==2);
        assertTrue(student122.getGrades()[2]==2);
        
        assertTrue(student220.getGrades()[0]==2);
        assertTrue(student220.getGrades()[1]==2);
        assertTrue(student220.getGrades()[2]==0);
        
        assertTrue(student120.getGrades()[0]==1);
        assertTrue(student120.getGrades()[1]==2);
        assertTrue(student120.getGrades()[2]==0);
        
        assertTrue(student200.getGrades()[0]==2);
        assertTrue(student200.getGrades()[1]==0);
        assertTrue(student200.getGrades()[2]==0);
        
        assertTrue(student200E.getGrades()[0]==2);
        assertTrue(student200E.getGrades()[1]==0);
        assertTrue(student200E.getGrades()[2]==0);
        
        assertTrue(student222.getGrades()[0]==2);
        assertTrue(student222.getGrades()[1]==2);
        assertTrue(student222.getGrades()[2]==2);

        assertTrue(student110.getGrades()[0]==1);
        assertTrue(student110.getGrades()[1]==1);
        assertTrue(student110.getGrades()[2]==0);
        
        assertTrue(student100.getGrades()[0]==1);
        assertTrue(student100.getGrades()[1]==0);
        assertTrue(student100.getGrades()[2]==0);
        
        assertTrue(student000.getGrades()[0]==0);
        assertTrue(student000.getGrades()[1]==0);
        assertTrue(student000.getGrades()[2]==0);
    }
}
