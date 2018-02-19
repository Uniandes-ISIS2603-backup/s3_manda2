/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author n.bello
 */
@Stateless
public class EmpleadoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public EmpleadoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando employee con id={0}", id);
        return em.find(EmpleadoEntity.class, id);
    }

    public EmpleadoEntity findByName(String nombre) {
        LOGGER.log(Level.INFO, "Consultando empleado con nombre= ", nombre);
        TypedQuery<EmpleadoEntity> q
                = em.createQuery("select u from EmpleadoEntity u where u.nombre = :nombre", EmpleadoEntity.class);
        q = q.setParameter("nombre", nombre);
        return q.getSingleResult();
    }

    public List<EmpleadoEntity> findAll() {
        LOGGER.info("Consultando todos los empleados");
        Query q = em.createQuery("select u from EmpleadoEntity u");
        return q.getResultList();
    }

    public EmpleadoEntity create(EmpleadoEntity entity) {
        LOGGER.info("Creando un empleado nuevo");
        em.persist(entity);
        LOGGER.info("empleado creado");
        return entity;
    }

    public EmpleadoEntity update(EmpleadoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando empleado con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando empleado con id={0}", id);
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, id);
        em.remove(entity);
    }
}
