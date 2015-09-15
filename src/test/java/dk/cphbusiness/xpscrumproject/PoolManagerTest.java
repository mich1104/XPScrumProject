/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dennis
 */
public class PoolManagerTest {

    private PoolManager pm;

    public PoolManagerTest() {
        
    }

    @Before
    public void setUp() {
        pm = new PoolManager();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getMoveSubjectsFromA() {
        Subject sub1 = new Subject("Android", "", "");
        Subject sub2 = new Subject("AI", "", "");
        Subject sub3 = new Subject("Games", "", "");
        pm.getPoolA().add(sub1);
        pm.getPoolA().add(sub2);
        pm.getPoolA().add(sub3);
        pm.moveSubject(sub1, "A", "B");
        pm.moveSubject(sub2, "A", "C");
        pm.moveSubject(sub3, "A", "Unassigned");

        assertThat(pm.getPoolA().size(), is(0));
        assertThat(pm.getPoolB().get(0), is(sub1));
        assertThat(pm.getPoolC().get(0), is(sub2));
        assertThat(pm.getPoolUnassigned().get(0), is(sub3));

    }

    @Test
    public void getMoveSubjectsFromB() {
        Subject sub1 = new Subject("Android", "", "");
        Subject sub2 = new Subject("AI", "", "");
        Subject sub3 = new Subject("Games", "", "");
        pm.getPoolB().add(sub1);
        pm.getPoolB().add(sub2);
        pm.getPoolB().add(sub3);
        pm.moveSubject(sub1, "B", "A");
        pm.moveSubject(sub2, "B", "C");
        pm.moveSubject(sub3, "B", "Unassigned");

        assertThat(pm.getPoolB().size(), is(0));
        assertThat(pm.getPoolA().get(0), is(sub1));
        assertThat(pm.getPoolC().get(0), is(sub2));
        assertThat(pm.getPoolUnassigned().get(0), is(sub3));

    }

    @Test
    public void getMoveSubjectsFromC() {
        Subject sub1 = new Subject("Android", "", "");
        Subject sub2 = new Subject("AI", "", "");
        Subject sub3 = new Subject("Games", "", "");
        pm.getPoolC().add(sub1);
        pm.getPoolC().add(sub2);
        pm.getPoolC().add(sub3);
        pm.moveSubject(sub1, "C", "A");
        pm.moveSubject(sub2, "C", "B");
        pm.moveSubject(sub3, "C", "Unassigned");

        assertThat(pm.getPoolC().size(), is(0));
        assertThat(pm.getPoolA().get(0), is(sub1));
        assertThat(pm.getPoolB().get(0), is(sub2));
        assertThat(pm.getPoolUnassigned().get(0), is(sub3));

    }

    @Test
    public void getMoveSubjectsFromUnassigned() {
        Subject sub1 = new Subject("Android", "", "");
        Subject sub2 = new Subject("AI", "", "");
        Subject sub3 = new Subject("Games", "", "");
        pm.getPoolUnassigned().add(sub1);
        pm.getPoolUnassigned().add(sub2);
        pm.getPoolUnassigned().add(sub3);
        pm.moveSubject(sub1, "Unassigned", "A");
        pm.moveSubject(sub2, "Unassigned", "B");
        pm.moveSubject(sub3, "Unassigned", "C");

        assertThat(pm.getPoolUnassigned().size(), is(0));
        assertThat(pm.getPoolA().get(0), is(sub1));
        assertThat(pm.getPoolB().get(0), is(sub2));
        assertThat(pm.getPoolC().get(0), is(sub3));

    }
    @Test
    public void testReset(){
        Subject sub1 = new Subject("Android", "", "");
        Subject sub2 = new Subject("AI", "", "");
        Subject sub3 = new Subject("Games", "", "");
        pm.getPoolA().add(sub1);
        pm.getPoolB().add(sub2);
        pm.getPoolC().add(sub3);
        pm.reset();
        
        assertThat(pm.getPoolA().size(), is(0));
        assertThat(pm.getPoolB().size(), is(0));
        assertThat(pm.getPoolC().size(), is(0));
        
        assertThat(pm.getPoolUnassigned().size(), is(3));
    }
    
    @Test
    public void testWrongFrom(){
        Subject s = new Subject("test", null, null);
        assertThat(pm.getPoolA().size(), is(0));
        pm.moveSubject(s, "NoPoolNamedThis", "A");
        assertThat(pm.getPoolA().size(), is(0));
    }

    @Test
    public void testSetPools(){
        Pool p1 = new Pool("pool1");
        Pool p2 = new Pool("pool2");
        Pool p3 = new Pool("pool3");
        Pool p4 = new Pool("pool4");
        
        Subject s1 = new Subject("test1",null,null);
        Subject s2 = new Subject("test2",null,null);
        Subject s3 = new Subject("test3",null,null);
        Subject s4 = new Subject("test4",null,null);
        
        pm.getPoolA().add(s1);
        pm.getPoolB().add(s2);
        pm.getPoolC().add(s3);
        pm.getPoolUnassigned().add(s4);
        
        assertThat(pm.getPoolA().size(), is(1));
        assertThat(pm.getPoolB().size(), is(1));
        assertThat(pm.getPoolC().size(), is(1));
        assertThat(pm.getPoolUnassigned().size(), is(1));
        
        pm.setPools(p1, p2, p3, p4);
        
        assertThat(pm.getPoolA().size(), is(0));
        assertThat(pm.getPoolB().size(), is(0));
        assertThat(pm.getPoolC().size(), is(0));
        assertThat(pm.getPoolUnassigned().size(), is(0));
    }
}
