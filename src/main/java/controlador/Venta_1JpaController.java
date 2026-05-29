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
import modelo.Venta_1;

public class Venta_1JpaController implements Serializable {

    public Venta_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta_1 venta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(venta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVenta_1(venta.getIdVenta()) != null) {
                throw new PreexistingEntityException("Venta_1 " + venta + " already exists.", ex);
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
            Venta_1 venta;
            try {
                venta = em.getReference(Venta_1.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La venta con id " + id + " no existe.", enfe);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Venta_1> findVenta_1Entities() {
        return findVenta_1Entities(true, -1, -1);
    }

    public List<Venta_1> findVenta_1Entities(int maxResults, int firstResult) {
        return findVenta_1Entities(false, maxResults, firstResult);
    }

    private List<Venta_1> findVenta_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta_1.class));
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

    public Venta_1 findVenta_1(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta_1.class, id);
        } finally {
            em.close();
        }
    }

    // Busca si ya existe una venta para ese auto
    public boolean autoYaVendido(Long idAuto) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Venta_1.findByIdAuto");
            q.setParameter("idAuto", idAuto);
            return !q.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    public int getVenta_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta_1> rt = cq.from(Venta_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}