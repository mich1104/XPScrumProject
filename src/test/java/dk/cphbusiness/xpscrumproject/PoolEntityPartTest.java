/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class PoolEntityPartTest {
    
    Pool pool;
    
    public PoolEntityPartTest() {
        
    }
    
    @Test
    public void testEntityConstructor(){
        pool = new Pool();
        assertThat(pool.getPool().isEmpty(), is(true));
    }
    
    @Test
    public void testSetGetIdHashCodeAndToString(){
        pool = new Pool();
        int id = 987654321;
        pool.setId(id);
        assertThat(pool.getId(), is(id));
        int hashCode = 0;
        hashCode +=id;
        assertThat(pool.hashCode(), is(hashCode));
        String poolToString = "dk.cphbusiness.xpscrumproject.PoolEntity[ id=" + id + " ]";
        assertThat(pool.toString(), is(poolToString));
    }
    
    @Test
    public void testEquals(){
        pool = new Pool();
        pool.setId(987654321);
        Object notPool = new Object();
        assertFalse(pool.equals(notPool));
        Pool AnotherPool = new Pool();
        AnotherPool.setId(123456789);
        assertFalse(pool.equals(AnotherPool));
        assertTrue(pool.equals(pool));
    }
    @Test
    public void testSetGetPriority(){
        List<Subject> list = new ArrayList();
        list.add(new Subject("test", null, null));
        pool = new Pool();
        pool.setPool(list);
        assertThat(pool.getPool(), is(list));
    }
}
