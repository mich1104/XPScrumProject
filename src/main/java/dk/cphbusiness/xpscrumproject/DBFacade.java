/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Michael
 */
public class DBFacade {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DBFacade(boolean test) {
        if (!test) {
            emf = Persistence.createEntityManagerFactory("PU");
            em = emf.createEntityManager();
        } else {
            emf = Persistence.createEntityManagerFactory("testPU");
            em = emf.createEntityManager();
        }
    }

    public Subject createSubject(Subject s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        return s;
    }

    public Subject getSubject(int id) {
        Subject e = em.find(Subject.class, id);
        return e;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects;
        Query query = em.createQuery("SELECT s FROM Subject s");
        subjects = query.getResultList();
        return subjects;
    }

    public Student createStudent(Student s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        return s;
    }

    public Student getStudent(int id) {
        Student e = em.find(Student.class, id);
        return e;
    }

    public List<Student> getAllStudents() {
        List<Student> students;
        Query query = em.createQuery("SELECT s FROM Student s");
        students = query.getResultList();
        return students;
    }

    public List<Pool> createPool(List<Pool> pools) {

        for (Pool p : pools) {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }

        return pools;
    }

    public List<Pool> getPool() {
        Query query = em.createQuery("SELECT p FROM Pool p");
        List<Pool> list = query.getResultList();
        return list;
    }
}
