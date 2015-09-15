/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.ArrayList;
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
public class CSVFileSaverTest {

    private CSVFileSaver save;

    public CSVFileSaverTest() {
        save = new CSVFileSaver();
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

    /*@Test
    public void saveFileManual() {
        ArrayList<Subject> poolA = new ArrayList();
        ArrayList<Subject> poolB = new ArrayList();
        ArrayList<Subject> unaPool = new ArrayList();

        Subject subject1 = new Subject("Teori", "test", "test");
        Subject subject2 = new Subject("Praktik", "test", "test");
        Subject subject3 = new Subject("Fri", "test", "test");
        Subject subject4 = new Subject("Lol", "test", "test");
        Subject notfound1 = new Subject("Kagebagning", "test", "test");

        poolA.add(subject1);

        poolA.add(subject2);

        poolB.add(subject3);

        poolB.add(subject4);

        unaPool.add(notfound1);

        assertTrue(save.saveFile(true, unaPool, poolA, poolB));
    }*/

    @Test
    public void saveFileAuto() {
        ArrayList<Subject> poolA = new ArrayList();
        ArrayList<Subject> poolB = new ArrayList();
        ArrayList<Subject> poolC = new ArrayList();

        ArrayList<Subject> unaPool = new ArrayList();

        Subject subject1 = new Subject("Teori", "test", "test");
        Subject subject2 = new Subject("Praktik", "test", "test");
        Subject subject3 = new Subject("Fri", "test", "test");
        Subject subject4 = new Subject("Lol", "test", "test");
        Subject subject5 = new Subject("Yolo", "test", "test");
        Subject subject6 = new Subject("Tintin", "test", "test");
        Subject notfound1 = new Subject("Kagebagning", "test", "test");

        poolA.add(subject1);
        poolA.add(subject2);
        poolB.add(subject3);
        poolB.add(subject4);
        poolC.add(subject5);
        poolC.add(subject6);

        unaPool.add(notfound1);

        assertTrue(save.saveFile(false, unaPool, poolA, poolB,poolC));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
