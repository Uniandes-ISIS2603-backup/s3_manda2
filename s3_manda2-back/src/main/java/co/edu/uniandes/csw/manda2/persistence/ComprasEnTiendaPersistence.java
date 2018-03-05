/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dv.gonzalez10
 */
@Stateless
public class ComprasEnTiendaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
     /**
     * @param entity objeto city que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ComprasEnTiendaEntity create(ComprasEnTiendaEntity entity) {
        LOGGER.info("Creando una compra nueva");
        em.persist(entity);
        LOGGER.info("Creando una compra nueva");
        return entity;
    }
    
    /**
     * Busca si existe alguna compra en tienda con el id que se envia de argumento
     * @param id el id correspondiente a la compra en tienda
     * @return una compra en tienda
     */
    public ComprasEnTiendaEntity find(Long id) {
        return em.find(ComprasEnTiendaEntity.class, id);
    
    
        
        
     /**
     * Busca si hay alguna compras en tienda con el nombre que se envía de argumento
     *
     * @param name: Nombre de la compra en tienda que se está buscando
     * @return null si no existe ninguna compra en tienda con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    }
    public ComprasEnTiendaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando city por nombre ", name);

        // Se crea un query para buscar compras con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ComprasEnTiendaEntity e where e.name = :name", ComprasEnTiendaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<ComprasEnTiendaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
    
    /**
     * Devuelve todos las compras en tienda de la base de datos.
     *
     * @return una lista con todos las compras en tienda que encuentre en la base de
     * datos
     */
    public List<ComprasEnTiendaEntity> findAll() {
        LOGGER.info("Consultando todas las compras");
        TypedQuery query = em.createQuery("select u from ComprasEnTiendaEntity u", ComprasEnTiendaEntity.class);
        return query.getResultList();
    }
    
    /**
     * Actualiza una compra en tienda.
     *
     * @param entity: la compra en tienda que viene con los nuevos cambios. Por ejemplo
     * el articulo pudo cambiar. En ese caso, se haria uso del método update.
     * @return la compra en tienda con los cambios aplicados.
     */
    
    public ComprasEnTiendaEntity update(ComprasEnTiendaEntity entity) {
         return em.merge(entity);
    }
    
    
    /**
     * Borra la compra en tienda recibida como argumento
     * @param entity 
     */
    public void delete(Long id) {
       LOGGER.log(Level.INFO, "Borrando paypal con id={0}", id);
        ComprasEnTiendaEntity entity = em.find(ComprasEnTiendaEntity.class, id);
        em.remove(entity);
    }
    
}