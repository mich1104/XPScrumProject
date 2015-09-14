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
import org.junit.Before;

/**
 *
 * @author Michael
 */
public class ControllerTest {

//    private final Pool poolA;
//    private final Pool poolB;
//    private final Pool poolC;
//    private final Pool poolUnassigned;
    private final Controller control;
    private PoolManager pm;
//    private final Mockery context = new JUnitRuleMockery();
//    private final Mockery contextForClassMocking = new Mockery() {
//        {
//            setImposteriser(ClassImposteriser.INSTANCE);
//        }
//}

    public ControllerTest() {

//        pool = context.mock(PoolInterface.class, "pool");
        control = new Controller();
        pm = new PoolManager();
//        poolA = new Pool("A");
//        poolB = new Pool("B");
//        poolC = new Pool("C");
//        poolUnassigned = new Pool("Unassigned");
    }

    @Test
    public void testInjector() {
        pm = new PoolManager();
        control.setPm(pm);
        assertThat(control.getPm(), is(pm));
    }

    @Test
    public void testGetUnassignedList() {

        pm = new PoolManager();

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pm.getPoolUnassigned().add(ai);
        pm.getPoolUnassigned().add(android);
        control.setPm(pm);
//        control.setPool(pool);
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
//        control.setPool(pool);
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
        pm = new PoolManager();

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pm.getPoolA().add(ai);
        pm.getPoolA().add(android);
        control.setPm(pm);

        List<Subject> listOfSubjects = control.getPoolAList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolBList() {
//        control.setPool(pool);
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
        pm = new PoolManager();

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pm.getPoolB().add(ai);
        pm.getPoolB().add(android);
        control.setPm(pm);

        List<Subject> listOfSubjects = control.getPoolBList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testGetPoolCList() {
//        control.setPool(pool);
        pm = new PoolManager();

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pm.getPoolC().add(ai);
        pm.getPoolC().add(android);
        control.setPm(pm);
        List<Subject> listOfSubjects = control.getPoolCList();

        assertThat(listOfSubjects.size(), is(2));
    }

    @Test
    public void testMoveFromTO() {

        pm = new PoolManager();

        Subject android = new Subject("android", "test", "test");
        Subject ai = new Subject("ai", "test", "test");
        pm.getPoolUnassigned().add(ai);
        pm.getPoolUnassigned().add(android);
        control.setPm(pm);
        
        assertThat(control.getUnassignedList().size(),is(2));
        
        control.moveFromTo(ai, "Unassigned", "B");
        
        assertThat(control.getPoolBList().size(),is(1));
        assertThat(control.getUnassignedList().size(),is(1));
        
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

//    @Test
//    public void testSubmitPools() {
//        Pool p = new Pool();
//        assertTrue(control.submitPools(false));
//    }
//    @Test
//    public void testReset() {
//        assertTrue(control.resetPools());
//    }
}
