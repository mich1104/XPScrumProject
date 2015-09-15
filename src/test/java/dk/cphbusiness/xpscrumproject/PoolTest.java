package dk.cphbusiness.xpscrumproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
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
        pool = new Pool("");
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testSetName(){
       pool.setName("Test");
       String result = pool.getName();
       assertThat(result,  is("Test"));
    }

    @Test
    public void addGetRemovePool() {
        Subject fag = new Subject("test", "test", "test");
        pool.addToPool(fag);
        List<Subject> list = pool.getPool();
        assertTrue(list.get(0).equals(fag));
        pool.removeFromPool(fag);
        list = pool.getPool();
        assertTrue(list.size() == 0);
    }

    @Test
    public void returnsNull() {
        pool = new Pool("");
        Subject fag = new Subject("test", "test", "test");
        Subject result = pool.removeFromPool(fag);

        assertNull(result);
    }

    @Test
    public void removeAll() {
        pool = new Pool("");
        Subject fag1 = new Subject("test", "test", "test");
        Subject fag2 = new Subject("test", "test", "test");
        pool.addToPool(fag1);
        pool.addToPool(fag2);
        List<Subject> result = pool.removeAll();
        
        assertThat(result.size(), is(2));
        assertThat(pool.getPool().size(), is(0));
    }

        @Test
    
        public void AddList() {
        pool = new Pool("");
        Subject fag1 = new Subject("test", "test", "test");
        Subject fag2 = new Subject("test", "test", "test");
        List<Subject> newList = new ArrayList();
        newList.add(fag1);
        newList.add(fag2);
        
        assertThat(pool.getPool().size(), is(0));
        pool.addToPool(newList);
        assertThat(pool.getPool().size(), is(2));
    }
    
//    @Test
//    public void reset(){
//        Pool p = new Pool();
//        Subject one = new Subject("test","test","test");
//        Subject two = new Subject("test","test","test");
//        Subject three = new Subject("test","test","test");
//        Subject four = new Subject("test","test","test");
//        p.addToPoolA(one);
//        p.addToPoolB(two);
//        p.addToPoolC(three);
//        p.addToUnassigned(four);
//        p.reset();
//        assertTrue(p.getUnassignedPool().size()==4);
//    }
}
