/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
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
 * @author cv.trujillo
 */
@Stateless
public class ArticuloPersistence {
      
    private static final Logger LOGGER = Logger.getLogger(ArticuloPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public ArticuloEntity find(String nombre) {
        LOGGER.log(Level.INFO, "Consultando articulo con nombre={null}", nombre);
        return em.find(ArticuloEntity.class, nombre);
    }

    public ArticuloEntity findByName(String nombre) {
        LOGGER.log(Level.INFO, "Consultando articulo con nombre= ", nombre);
        TypedQuery<ArticuloEntity> q
                = em.createQuery("select u from ArticuloEntity u where u.nombre = :nombre", ArticuloEntity.class);
        q = q.setParameter("nombre", nombre);
        return q.getSingleResult();
    }

    public List<ArticuloEntity> findAll() {
        LOGGER.info("Consultando todos los articulos");
        Query q = em.createQuery("select u from ArticuloEntity u");
        return q.getResultList();
    }

    public ArticuloEntity create(ArticuloEntity entity) {
        LOGGER.info("Creando un articulo nuevo");
        em.persist(entity);
        LOGGER.info("articulo creado");
        return entity;
    }

    public ArticuloEntity update(ArticuloEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando articulo con nombre={null}", entity.getPrecio());
        return em.merge(entity);
    }

    public void delete(String nombre) {
        LOGGER.log(Level.INFO, "Borrando articulo con nombre={null}", nombre);
        ArticuloEntity entity = em.find(ArticuloEntity.class, nombre);
        em.remove(entity);
    }
}
