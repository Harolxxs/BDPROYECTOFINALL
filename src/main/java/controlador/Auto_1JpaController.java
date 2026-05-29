/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import modelo.Auto_1;

public class Auto_1JpaController implements Serializable {

    public Auto_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Auto_1 auto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(auto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAuto_1(auto.getIdAuto()) != null) {
                throw new PreexistingEntityException("Auto_1 " + auto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Auto_1 auto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(auto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = auto.getIdAuto();
                if (findAuto_1(id) == null) {
                    throw new NonexistentEntityException("El auto con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Auto_1 auto;
            try {
                auto = em.getReference(Auto_1.class, id);
                auto.getIdAuto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El auto con id " + id + " no existe.", enfe);
            }
            em.remove(auto);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Auto_1> findAuto_1Entities() {
        return findAuto_1Entities(true, -1, -1);
    }

    public List<Auto_1> findAuto_1Entities(int maxResults, int firstResult) {
        return findAuto_1Entities(false, maxResults, firstResult);
    }

    private List<Auto_1> findAuto_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Auto_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Auto_1 findAuto_1(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Auto_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuto_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Auto_1> rt = cq.from(Auto_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}


