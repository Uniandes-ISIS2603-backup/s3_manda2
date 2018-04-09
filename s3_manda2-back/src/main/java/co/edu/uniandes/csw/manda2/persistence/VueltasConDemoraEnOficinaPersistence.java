/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
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
public class VueltasConDemoraEnOficinaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
     /**
     * @param entity objeto city que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public VueltasConDemoraEnOficinaEntity create(VueltasConDemoraEnOficinaEntity entity) {
        LOGGER.info("Creando una vuelta con demora en oficina nueva");
        em.persist(entity);
        LOGGER.info("Creando una vuelta con demora en oficina nueva");
        return entity;
    }
    
     /**
     * Busca si existe alguna vuelta con demora en oficina con el id que se envia de argumento
     * @param id el id correspondiente a la vuelta con demora en oficina
     * @return una vuelta con demora en oficina
     */
    public VueltasConDemoraEnOficinaEntity find(Long id) {
       return em.find(VueltasConDemoraEnOficinaEntity.class, id);
    }

    
    /**
     * Busca si hay alguna vuelta con demora en oficina con el nombre que se envía de argumento
     *
     * @param name: Nombre de la vuelta con demora en oficina que se está buscando
     * @return null si no existe ninguna vuelta con demora en oficina con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public VueltasConDemoraEnOficinaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando vueltas por nombre ", name);

        // Se crea un query para buscar vueltas con el nombre que recibe el método como argumento. ":nombre" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From VueltasConDemoraEnOficinaEntity e where e.name = :nombre", VueltasConDemoraEnOficinaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("nombre", name);
        // Se invoca el query se obtiene la lista resultado
        List<VueltasConDemoraEnOficinaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
    
    /**
     * Devuelve todos las vueltas con demora de la base de datos.
     *
     * @return una lista con todos las vueltas con demora que encuentre en la base de
     * datos
     */
        public List<VueltasConDemoraEnOficinaEntity> findAll() {
        LOGGER.info("Consultando todas las vueltas");
        TypedQuery query = em.createQuery("select u from VueltasConDemoraEnOficinaEntity u", VueltasConDemoraEnOficinaEntity.class);
        return query.getResultList();
    }
        
        
     /**
     * Actualiza una vuelta con demora en oficina.
     *
     * @param entity: la vuelta con demora en oficina que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return la vuelta con demora en oficina con los cambios aplicados.
     */
     public VueltasConDemoraEnOficinaEntity update(VueltasConDemoraEnOficinaEntity entity) {
     LOGGER.log(Level.INFO, "Actualizando vuelta con id={0}", entity.getId());
        return em.merge(entity);
    }
    
     /**
     * Borra la vuelta con demora recibida como argumento
     * @param id 
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando vuelta con id={0}", id);
        VueltasConDemoraEnOficinaEntity entity = em.find(VueltasConDemoraEnOficinaEntity.class, id);
        em.remove(entity);
    }
}
