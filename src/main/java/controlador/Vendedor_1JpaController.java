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
import modelo.Vendedor_1;

/**
 *
 * @author harol
 */
public class Vendedor_1JpaController implements Serializable {

    public Vendedor_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedor_1 vendedor_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vendedor_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedor_1(vendedor_1.getIdVendedor()) != null) {
                throw new PreexistingEntityException("Vendedor_1 " + vendedor_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedor_1 vendedor_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vendedor_1 = em.merge(vendedor_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vendedor_1.getIdVendedor();
                if (findVendedor_1(id) == null) {
                    throw new NonexistentEntityException("The vendedor_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor_1 vendedor_1;
            try {
                vendedor_1 = em.getReference(Vendedor_1.class, id);
                vendedor_1.getIdVendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedor_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(vendedor_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedor_1> findVendedor_1Entities() {
        return findVendedor_1Entities(true, -1, -1);
    }

    public List<Vendedor_1> findVendedor_1Entities(int maxResults, int firstResult) {
        return findVendedor_1Entities(false, maxResults, firstResult);
    }

    private List<Vendedor_1> findVendedor_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedor_1.class));
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

    public Vendedor_1 findVendedor_1(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedor_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedor_1> rt = cq.from(Vendedor_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
