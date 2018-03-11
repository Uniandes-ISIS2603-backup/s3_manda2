/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;


import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.persistence.EntregasDeDocumentosPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dv.gonzalez10
 */

@Stateless
public class EntregasDeDocumentosLogic {
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaLogic.class.getName());
    
    @Inject
    private EntregasDeDocumentosPersistence persistence;
    
    
    /**
     * Devuelve las entregas que hay en la base de datos
     * @return 
     */
    public List<EntregasDeDocumentosEntity> getEntregas (){
        LOGGER.info("Inicia proceso de consultar todas las entregas");
        List<EntregasDeDocumentosEntity> entregas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las entregas");
        return entregas;
    }
    
    /**
     * Buscar una entregas por el id dado 
     * @param id el id de la entregas a buscar    
     * @return La entrega encontrada, si no se encuentra retorna null
     */
    public EntregasDeDocumentosEntity getEntrega (Long id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar entregas con id={0}", id);
        EntregasDeDocumentosEntity entrega = persistence.find(id);
        if (entrega == null) {
            LOGGER.log(Level.SEVERE, "Las entregas con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la entregas con id={0}", id);
        return entrega;
    }
    
    
    /**
     * 
     * @param entity
     * @return 
     */
    public EntregasDeDocumentosEntity createEntrega (EntregasDeDocumentosEntity entity ) {
        LOGGER.info("Inicia proceso de creación de entrega");
       // if (!validateISBN(entity.getIsbn())) {
         //   throw new BusinessLogicException("El ISBN es inválido");
        //}
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de entrega");
        return entity;
    }
    
    
    public EntregasDeDocumentosEntity updateEntrega (Long id, EntregasDeDocumentosEntity entity ) {
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar una entrega con id={0}", id);
        //if (!validateISBN(entity.getIsbn())) {
          //  throw new BusinessLogicException("El ISBN es inválido");
        //}
        EntregasDeDocumentosEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar una entrega con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Elimina la entrega dada por el id 
     * @param id el id de la entrega a eliminar
     */
    public void deleteEntrega (Long id ){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una entrega con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar una entrega con id={0}", id);
    }
    
    
    
}
