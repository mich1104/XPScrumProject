/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.jmock.Expectations;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.assertThat;
import org.jmock.lib.legacy.ClassImposteriser;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Michael
 */
public class ControllerTest {

    private final PoolInterface pool;
    private final Controller control;
    private final Mockery context = new JUnitRuleMockery();
    private final Mockery contextForClassMocking = new Mockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    public ControllerTest() {

        pool = context.mock(PoolInterface.class, "pool");
        control = new Controller();
    }

    @Test
    public void testInjector() {
        control.setPool(pool);
        assertThat(control.getPool(), is(pool));
    }

    @Test
    public void testGetUnassignedList() {

        control.setPool(pool);
        List<SubjectInterface> expectationReturn = new ArrayList<SubjectInterface>() {
            {
                add(context.mock(SubjectInterface.class, "Android"));
                add(context.mock(SubjectInterface.class, "AI"));
            }
        };

        context.checking(new Expectations() {
            {
                oneOf(pool).getUnassignedPool();
                will(returnValue(expectationReturn));
            }
        });

        List<Subject> listOfSubjects = control.getUnassignedList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolAList() {
        control.setPool(pool);
        List<SubjectInterface> expectationReturn = new ArrayList<SubjectInterface>() {
            {
                add(context.mock(SubjectInterface.class, "Android"));
                add(context.mock(SubjectInterface.class, "AI"));
            }
        };

        context.checking(new Expectations() {
            {
                oneOf(pool).getPoolA();
                will(returnValue(expectationReturn));
            }
        });

        List<Subject> listOfSubjects = control.getPoolAList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolBList() {
        control.setPool(pool);
        List<SubjectInterface> expectationReturn = new ArrayList<SubjectInterface>() {
            {
                add(context.mock(SubjectInterface.class, "Android"));
                add(context.mock(SubjectInterface.class, "AI"));
            }
        };

        context.checking(new Expectations() {
            {
                oneOf(pool).getPoolB();
                will(returnValue(expectationReturn));
            }
        });

        List<Subject> listOfSubjects = control.getPoolBList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testAddToAndRemoveFromPoolA() {
        control.setPool(pool);

        Subject android = contextForClassMocking.mock(Subject.class, "android");

        context.checking(new Expectations() {
            {
                oneOf(pool).addToPoolA(android);
                oneOf(pool).removeFromPoolA(android);
                will(returnValue(android));
            }
        });

        control.addtoPoolA(android);
        Subject returned = control.removeFromPoolA(android);

        assertThat(returned, is(android));
    }

    @Test
    public void testAddToAndRemoveFromPoolB() {
        control.setPool(pool);

        Subject android = contextForClassMocking.mock(Subject.class, "android");

        context.checking(new Expectations() {
            {
                oneOf(pool).addToPoolB(android);
                oneOf(pool).removeFromPoolB(android);
                will(returnValue(android));
            }
        });

        control.addtoPoolB(android);
        Subject returned = control.removeFromPoolB(android);

        assertThat(returned, is(android));
    }

    @Test
    public void testAddToAndRemoveFromUnassigned() {
        control.setPool(pool);

        Subject android = contextForClassMocking.mock(Subject.class, "android");

        context.checking(new Expectations() {
            {
                oneOf(pool).addToUnassigned(android);
                oneOf(pool).removeFromUnassignedPool(android);
                will(returnValue(android));
            }
        });

        control.addToUnassigned(android);
        Subject returned = control.removeFromUnassigned(android);

        assertThat(returned, is(android));
    }

    @Test
    public void testLoadStudentsAndGetStudents() throws Exception {
        

        assertNull(control.getStudents());
        control.loadStudents();
        assertThat(control.getStudents().size(), is(2));
    }

}
