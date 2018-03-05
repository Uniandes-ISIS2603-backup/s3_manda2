/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la persistencia para EntregasDeDocumentos.
 * Se conecta a través del Entity Manager de javax.persistance con la base de datos
 * SQL.
 * @author dv.gonzalez10
 */
@Stateless
public class EntregasDeDocumentosPersistence {
        
    private static final Logger LOGGER = Logger.getLogger(EntregasDeDocumentosPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    
    /**
     * Metodo para persistir la entidad en la base de datos
     * 
     * @param entity objeto entregas de documentos que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EntregasDeDocumentosEntity create(EntregasDeDocumentosEntity entity) {
        LOGGER.info("Creando una entrega de documento nueva");
        em.persist(entity);
        LOGGER.info("Creando una entrega de documento nueva");
        return entity;
    }
    
    /**
     * Busca si existe alguna entrega de documento con el id que se envia de argumento
     * @param id el id correspondiente a la entrega de documentos
     * @return una entrega de documento
     */
    public EntregasDeDocumentosEntity find(Long id) {
        return em.find(EntregasDeDocumentosEntity.class, id);
        
    }
    
    
        /**
     * Busca si hay alguna entrega de documento con el nombre que se envía de argumento
     *
     * @param name: Nombre de la entrega de documento que se está buscando
     * @return null si no existe ninguna entrega de documento con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    
    public EntregasDeDocumentosEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando city por nombre ", name);

        // Se crea un query para buscar cities con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From CityEntity e where e.name = :name", EntregasDeDocumentosEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<EntregasDeDocumentosEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
     /**
     * Devuelve todos las entregas de documentos de la base de datos.
     *
     * @return una lista con todos las entregas de documentos que encuentre en la base de
     * datos
     */
     public List<EntregasDeDocumentosEntity> findAll() {
        LOGGER.info("Consultando todas las vueltas");
        TypedQuery query = em.createQuery("select u from EntregasDeDocumentosEntity u", EntregasDeDocumentosEntity.class);
        return query.getResultList();
    }
    
     
     /**
     * Actualiza una entrega de documento.
     *
     * @param entity: la entrega de documento que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return la entrega de documento con los cambios aplicados.
     */
    public EntregasDeDocumentosEntity update(EntregasDeDocumentosEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * Borra la entrega de documento recibida como argumento
     * @param entity 
     */
    public void delete(Long id) {
         LOGGER.log(Level.INFO, "Borrando paypal con id={0}", id);
        EntregasDeDocumentosEntity entity = em.find(EntregasDeDocumentosEntity.class, id);
        em.remove(entity);
    }
}