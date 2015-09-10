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
    private Student student11;
    private Student student1;
    private Student student112;
    private Student student122;
    private Student student222;
    private Student student110;
    private Student student120;
    private Student student220;
    private Student student100;
    private Student student200;
    private Student student000;

    private Subject subject1 = new Subject("Teori", "test", "test");
    private Subject subject2 = new Subject("Praktik", "test", "test");
    private Subject subject3 = new Subject("Fri", "test", "test");
    private Subject subject4 = new Subject("Pille navle", "test", "test");
    private Subject subject5 = new Subject("Næsepilning", "test", "test");
    private Subject subject6 = new Subject("Vaske hænder", "test", "test");
    private Subject notfound = new Subject("Kagebagning", "test", "test");

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

        student11 = new Student("Curt");
        student1 = new Student("Furt");

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
        student111.setFirstPriority(subject1, subject2, subject3);
        student111.setSecondPriority(subject4, subject5, subject6);
        student112.setFirstPriority(subject1, subject2, subject4);
        student112.setSecondPriority(subject5, subject3, subject6);
        student122.setFirstPriority(subject1, subject4, notfound);
        student122.setSecondPriority(subject5, subject2, subject3);
        student222.setFirstPriority(notfound, notfound, notfound);
        student222.setSecondPriority(subject4, subject5, subject6);
        student110.setFirstPriority(subject5, subject1, notfound);
        student110.setSecondPriority(subject2, subject4, notfound);
        student120.setFirstPriority(notfound, subject4, subject1);
        student120.setSecondPriority(notfound, subject5, subject2);
        student220.setFirstPriority(notfound, notfound, notfound);
        student220.setSecondPriority(subject2, subject1, subject5);
        student100.setFirstPriority(subject3, subject6, notfound);
        student100.setSecondPriority(notfound, notfound, notfound);
        student200.setFirstPriority(notfound, notfound, notfound);
        student200.setSecondPriority(subject6, subject3, notfound);
        student000.setFirstPriority(notfound, notfound, notfound);
        student000.setSecondPriority(notfound, notfound, notfound);

        student11.setFirstPriority(subject1, subject3, notfound);
        student11.setSecondPriority(notfound, notfound, notfound);
        student1.setFirstPriority(subject3, notfound, subject2);
        student1.setSecondPriority(subject4, subject5, subject6);

        studentlist.add(student111);
        studentlist.add(student112);
        studentlist.add(student122);
        studentlist.add(student222);
        studentlist.add(student110);
        studentlist.add(student120);
        studentlist.add(student220);
        studentlist.add(student100);
        studentlist.add(student200);
        studentlist.add(student000);

        studentlist.add(student1);
        studentlist.add(student11);

        poolA.add(subject1);
        poolA.add(subject4);
        poolB.add(subject2);
        poolB.add(subject5);
        poolC.add(subject3);
        poolC.add(subject6);

        List<Student> list = calc.calculate(studentlist, poolA, poolB, poolC);
        System.out.println("test");
        assertTrue(studentlist != null);
        System.out.println("test");
        assertTrue(student111.getGrades()[0] == 1);
        assertTrue(student111.getGrades()[1] == 1);
        assertTrue(student111.getGrades()[2] == 1);

        assertTrue(student112.getGrades()[0] == 1);
        assertTrue(student112.getGrades()[1] == 1);
        assertTrue(student112.getGrades()[2] == 2);

        assertTrue(student122.getGrades()[0] == 1);
        assertTrue(student122.getGrades()[1] == 2);
        assertTrue(student122.getGrades()[2] == 2);

        assertTrue(student222.getGrades()[0] == 2);
        assertTrue(student222.getGrades()[1] == 2);
        assertTrue(student222.getGrades()[2] == 2);

        assertTrue(student110.getGrades()[0] == 1);
        assertTrue(student110.getGrades()[1] == 1);
        assertTrue(student110.getGrades()[2] == 0);

        assertTrue(student120.getGrades()[0] == 1);
        assertTrue(student120.getGrades()[1] == 2);
        assertTrue(student120.getGrades()[2] == 0);

        assertTrue(student220.getGrades()[0] == 2);
        assertTrue(student220.getGrades()[1] == 2);
        assertTrue(student220.getGrades()[2] == 0);

        assertTrue(student100.getGrades()[0] == 1);
        assertTrue(student100.getGrades()[1] == 0);
        assertTrue(student100.getGrades()[2] == 0);

        assertTrue(student200.getGrades()[0] == 2);
        assertTrue(student200.getGrades()[1] == 0);
        assertTrue(student200.getGrades()[2] == 0);

        assertTrue(student000.getGrades()[0] == 0);
        assertTrue(student000.getGrades()[1] == 0);
        assertTrue(student000.getGrades()[2] == 0);
        System.out.println(student1.getGrades()[0]);
        System.out.println(student1.getGrades()[1]);
        System.out.println(student1.getGrades()[2]);
        assertTrue(student1.getGrades()[0] == 1);
        assertTrue(student1.getGrades()[1] == 1);
        assertTrue(student1.getGrades()[2] == 2);
        assertTrue(student11.getGrades()[0] == 1);
        assertTrue(student11.getGrades()[1] == 1);
        assertTrue(student11.getGrades()[2] == 0);

    }
}
