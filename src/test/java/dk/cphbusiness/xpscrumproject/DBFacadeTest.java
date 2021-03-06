package dk.cphbusiness.xpscrumproject;

import dk.cphbusiness.xpscrumproject.entity.Pool;
import dk.cphbusiness.xpscrumproject.entity.Student;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBFacadeTest {

    private static DBFacade dbf;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private List<Subject> persistedSubjects = new ArrayList();
    private List<Student> persistedStudents = new ArrayList();

    public DBFacadeTest() {
        
    }

    @BeforeClass
    public static void setup() {
        dbf = new DBFacade(true);
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
    }

    @After
    public void clearDatabase() {
        for (Subject p : persistedSubjects) {
            em.getTransaction().begin();
            Subject toBeRemoved = em.merge(p);
            em.remove(toBeRemoved);
            em.getTransaction().commit();
        }
        for (Student s : persistedStudents) {
            em.getTransaction().begin();
            Student toBeRemoved = em.merge(s);
            em.remove(toBeRemoved);
            em.getTransaction().commit();
        }
            persistedSubjects.removeAll(persistedSubjects);
    }

    @Test
    public void testCreateGetSubject() {
        Subject s1 = new Subject("AI", null, null);
        s1 = dbf.createSubject(s1);
        persistedSubjects.add(s1);
        assertThat(s1.getId(), instanceOf(Integer.class));
        Subject getSingleSubject = dbf.getSubject(s1.getId());
        assertThat(getSingleSubject.equals(s1), is(true));
        List<Subject> list = dbf.getAllSubjects();
        assertThat(list.size(), is(1));
        assertThat(list.get(0).equals(s1), is(true));
    }

    @Test
    public void testCreateGetPool() {
        Subject s1 = new Subject("AI", null, null);
        Subject s2 = new Subject("Test", null, null);
        Subject s3 = new Subject("C#", null, null);
        Subject s4 = new Subject("COBOL", null, null);
        
        
        
        persistedSubjects.add(s1);
        persistedSubjects.add(s2);
        persistedSubjects.add(s3);
        persistedSubjects.add(s4);

        PoolManager pm = new PoolManager();
        
        pm.getPoolUnassigned().add(s1);
        pm.getPoolUnassigned().add(s2);
        pm.getPoolUnassigned().add(s3);
        pm.getPoolUnassigned().add(s4);

        List<Pool> pools = pm.getAllPools();
        
        s1.setPool(pools.get(3));
        s2.setPool(pools.get(3));
        s3.setPool(pools.get(3));
        s4.setPool(pools.get(3));
        
        
                
        pools = dbf.createPool(pools);
        List<Pool> fromDB = dbf.getPools();
        
        for (int i = 0; i < pools.size(); i++) {
            System.out.println("pools: "+pools.get(i));
            System.out.println("fromDB: "+pools.get(i));
        }
        assertThat(pools.equals(fromDB), is(true));

        List<Subject> list = dbf.getAllSubjects();
        assertThat(list.size(), is(4));
        for (Subject s : list) {
            assertThat(s.getPool().getName().equals("Unassigned"),is(true));
        }
        
    }
    
    @Test
    public void testCreateGetStudent() {
        Student s1 = new Student("Kent");
        Student s2 = new Student("Karsten");

        persistedStudents.add(s1);
        persistedStudents.add(s2);

        dbf.createStudent(s1);
        dbf.createStudent(s2);
        List<Student> sListDB = dbf.getAllStudents();
        assertThat(sListDB.size() == 2, is(true));
        
        Student s1db = dbf.getStudent(s1.getId());
        assertThat(s1.equals(s1db), is(true));
        
    }
}
