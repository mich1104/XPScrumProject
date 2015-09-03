package dk.cphbusiness.xpscrumproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.cphbusiness.xpscrumproject.Fag;
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
        List<Fag> list = new ArrayList();
         Fag fag = new Fag("test","test","test");
        list.add(fag);
        pool.setUnassignedPool(list);
        List<Fag> result = pool.getUnassignedPool();
        assertTrue(result.get(0).equals(fag));
        pool.removeFromUnassignedPool(fag);
        result = pool.getUnassignedPool();
        assertTrue(result.size()==0);

    }

    @Test
    public void addGetRemovePoolA() {
        Fag fag = new Fag("test","test","test");
        pool.addToPoolA(fag);
        List<Fag> list = pool.getPoolA();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromPoolA(fag);
        list = pool.getPoolA();
        assertTrue(list.size() == 0);
    }

    @Test
    public void addGetRemovePoolB() {
        Fag fag = new Fag("test","test","test");
        pool.addToPoolB(fag);
        List<Fag> list = pool.getPoolB();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromPoolB(fag);
        list = pool.getPoolB();
        assertTrue(list.size() == 0);
    }
    
    @Test
    public void returnsNull(){
        pool = new Pool();
        Fag fag = new Fag("test","test","test");
        Fag resultUnassigned = pool.removeFromUnassignedPool(fag);
        Fag resultA = pool.removeFromPoolA(fag);
        Fag resultB = pool.removeFromPoolB(fag);
        
        assertNull(resultUnassigned);
        assertNull(resultA);
        assertNull(resultB);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
