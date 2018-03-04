/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ArticuloPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @Articulo cv.trujillo
 */
@Stateless
public class ArticuloLogic {
     private static final Logger LOGGER = Logger.getLogger(ArticuloLogic.class.getName());

    @Inject
    private ArticuloPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    //@Inject
    //private ArticuloLogic articuloLogic;
    
   /* public ArticuloEntity createArticulo(ArticuloEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Articulo");
        // Verifica la regla de negocio que dice que no puede haber dos cities con el mismo nombre
        if (persistence.findByNombre(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
        }
        // Invoca la persistencia para crear la Articulo
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Articulo");
        return entity;
    }
*/
     public ArticuloEntity createArticulo(ArticuloEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un autor ");
        
        return persistence.create(entity);
    }
    
    public List<ArticuloEntity> getArticulos() {
        LOGGER.info("Inicia proceso de consultar todas las cities");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ArticuloEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las cities");
        return editorials;
    }

    public ArticuloEntity getArticulo(Long id) {
        return persistence.find(id);
    }

    public ArticuloEntity updateArticulo(ArticuloEntity entity) throws BusinessLogicException  {
        if (persistence.findByNombre(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
        }
        return persistence.update(entity);
    }
   
    
    public void deleteArticulo(ArticuloEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar ciudad con id={0}", entity.getId());    
        persistence.delete(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar libro con id={0}", entity.getId());
    }
}
