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
public class DBfacade {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    private EntityManager em = emf.createEntityManager();
    
    public SubjectEntity createSubject(String title, String description, String teacher){
        SubjectEntity e = new SubjectEntity(title, description, teacher);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }
    
    public SubjectEntity getSubject(int id){
       SubjectEntity e = em.find(SubjectEntity.class, id);
       return e;
    }
}
