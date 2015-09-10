/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Michael
 */
public class ControllerTest {

    private final Pool pool;
    private final Controller control;
//    private final Mockery context = new JUnitRuleMockery();
//    private final Mockery contextForClassMocking = new Mockery() {
//        {
//            setImposteriser(ClassImposteriser.INSTANCE);
//        }
//}

    public ControllerTest() {

//        pool = context.mock(PoolInterface.class, "pool");
        control = new Controller();
        pool = new Pool();
    }

    @Test
    public void testInjector() {
        control.setPool(pool);
        assertThat(control.getPool(), is(pool));
    }

    @Test
    public void testGetUnassignedList() {

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pool.addToUnassigned(ai);
        pool.addToUnassigned(android);
        control.setPool(pool);
//        List<Subject> expectationReturn = new ArrayList<Subject>();
//        {
//            {
//                add(context.mock(SubjectInterface.class, "Android"));
//                add(context.mock(SubjectInterface.class, "AI"));
//            }
//        };

//        context.checking(new Expectations() {
//            {
//                oneOf(pool).getUnassignedPool();
//                will(returnValue(expectationReturn));
//            }
//        });
        List<Subject> listOfSubjects = control.getUnassignedList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolAList() {
        control.setPool(pool);
//        List<SubjectInterface> expectationReturn = new ArrayList<SubjectInterface>() {
//            {
//                add(context.mock(SubjectInterface.class, "Android"));
//                add(context.mock(SubjectInterface.class, "AI"));
//            }
//        };

//        context.checking(new Expectations() {
//            {
//                oneOf(pool).getPoolA();
//                will(returnValue(expectationReturn));
//            }
//        });
        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        control.addtoPoolA(ai);
        control.addtoPoolA(android);
        List<Subject> listOfSubjects = control.getPoolAList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolBList() {
        control.setPool(pool);
//        List<SubjectInterface> expectationReturn = new ArrayList<SubjectInterface>() {
//            {
//                add(context.mock(SubjectInterface.class, "Android"));
//                add(context.mock(SubjectInterface.class, "AI"));
//            }
//        };
//
//        context.checking(new Expectations() {
//            {
//                oneOf(pool).getPoolB();
//                will(returnValue(expectationReturn));
//            }
//        });
        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        control.addtoPoolB(ai);
        control.addtoPoolB(android);
        List<Subject> listOfSubjects = control.getPoolBList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testAddToAndRemoveFromPoolA() {
        control.setPool(pool);

//        Subject android = contextForClassMocking.mock(Subject.class, "android");
//
//        context.checking(new Expectations() {
//            {
//                oneOf(pool).addToPoolA(android);
//                oneOf(pool).removeFromPoolA(android);
//                will(returnValue(android));
//            }
//        });
        Subject subject = new Subject("android", "test", "test");

        control.addtoPoolA(subject);
        Subject returned = control.removeFromPoolA(subject);

        assertThat(returned, is(subject));
    }

    @Test
    public void testAddToAndRemoveFromPoolB() {
        control.setPool(pool);

//        Subject android = contextForClassMocking.mock(Subject.class, "android");
//
//        context.checking(new Expectations() {
//            {
//                oneOf(pool).addToPoolB(android);
//                oneOf(pool).removeFromPoolB(android);
//                will(returnValue(android));
//            }
//        });
        Subject android = new Subject("android", "test", "test");
        control.addtoPoolB(android);
        Subject returned = control.removeFromPoolB(android);

        assertThat(returned, is(android));
    }

    @Test
    public void testAddToAndRemoveFromUnassigned() {
        control.setPool(pool);

//        Subject android = contextForClassMocking.mock(Subject.class, "android");
//
//        context.checking(new Expectations() {
//            {
//                oneOf(pool).addToUnassigned(android);
//                oneOf(pool).removeFromUnassignedPool(android);
//                will(returnValue(android));
//            }
//        });
        Subject android = new Subject("android", "test", "test");
        control.addToUnassigned(android);
        Subject returned = control.removeFromUnassigned(android);

        assertThat(returned, is(android));
    }

    @Test
    public void testLoadStudentsAndGetStudents() throws Exception {
        String fileName = "testFileChooserThroughContoller.csv";
        String path = System.getProperty("user.dir") + System.getProperty("path.seperator") + fileName;
        createTestFile(path);

        assertThat(control.getStudents().size(), is(0));
        control.loadStudents(fileName);
        assertThat(control.getStudents().size(), is(2));
    }

    @Test
    public void testLoadStudentsCathingIO() throws Exception {

        String fileName = "testFileChooserThroughContoller.txt";

        control.loadStudents(fileName);
        assertThat(control.getStudents().size(), is(0));
    }

    public void createTestFile(String path) throws IOException {
        String toFile = "name, prio1, prio1.1,prio1.1.1, prio2, prio2.1,prio2.1.1;name2, prio1, prio1.1,prio1.1.1, prio2, prio2.1,prio2.1.1";
        PrintWriter pw = new PrintWriter(path);
        pw.print(toFile);
        pw.flush();
        pw.close();
    }

    @Test
    public void testCalculate() {
        assertTrue(control.calculate().size() == 0);
    }

    @Test
    public void testSubmitPools(){
        Pool p = new Pool();
        assertTrue(control.submitPools(false));
    }
}
