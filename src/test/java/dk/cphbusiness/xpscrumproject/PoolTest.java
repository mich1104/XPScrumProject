package dk.cphbusiness.xpscrumproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.cphbusiness.xpscrumproject.Subject;
import dk.cphbusiness.xpscrumproject.Pool;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Muggi
 */
public class PoolTest {

    Pool pool;

    public PoolTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pool = new Pool();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setGetRemoveUnassignedPool() {
        List<Subject> list = new ArrayList();
         Subject fag = new Subject("test","test","test");
        list.add(fag);
        pool.setUnassignedPool(list);
        List<Subject> result = pool.getUnassignedPool();
        assertTrue(result.get(0).equals(fag));
        pool.removeFromUnassignedPool(fag);
        result = pool.getUnassignedPool();
        assertTrue(result.size()==0);

    }

    @Test
    public void addGetRemovePoolA() {
        Subject fag = new Subject("test","test","test");
        pool.addToPoolA(fag);
        List<Subject> list = pool.getPoolA();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromPoolA(fag);
        list = pool.getPoolA();
        assertTrue(list.size() == 0);
    }

    @Test
    public void addGetRemovePoolB() {
        Subject fag = new Subject("test","test","test");
        pool.addToPoolB(fag);
        List<Subject> list = pool.getPoolB();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromPoolB(fag);
        list = pool.getPoolB();
        assertTrue(list.size() == 0);
    }
    
    @Test
    public void returnsNull(){
        pool = new Pool();
        Subject fag = new Subject("test","test","test");
        Subject resultUnassigned = pool.removeFromUnassignedPool(fag);
        Subject resultA = pool.removeFromPoolA(fag);
        Subject resultB = pool.removeFromPoolB(fag);
        
        assertNull(resultUnassigned);
        assertNull(resultA);
        assertNull(resultB);
    }
    
    @Test
    public void testAddRemoveFromUnassigned() {
        Subject fag = new Subject("test","test","test");
        pool.addToUnassigned(fag);
        List<Subject> list = pool.getUnassignedPool();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromUnassignedPool(fag);
        list = pool.getUnassignedPool();
        assertTrue(list.size() == 0);
    }
}
