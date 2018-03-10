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
    /**
     * Devuelve todos los articulos que hay en la base de datos.
     * @return Lista de entidades de tipo articulo.
     */
    public List<ArticuloEntity> getArticulos() {
        LOGGER.info("Inicia proceso de consultar todos los articulos");
        List<ArticuloEntity> articulos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los articulos");
        return articulos;
    }
    /**
     * Busca un articulo por ID
     * @param id El id del articulo a buscar
     * @return El articulo encontrado, null si no lo encuentra.
     */
    public ArticuloEntity getArticulo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar articulo con id={0}", id);
        ArticuloEntity articulo = persistence.find(id);
        if (articulo == null) {
            LOGGER.log(Level.SEVERE, "El articulo con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar articulo"
                + " con id={0}", id);
        return articulo;
    }
    /**
     * Eliminar un Articulo
     * @param id El ID del articulo a eliminar
     */
    public void deleteArticulo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar articulo con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar articulo con id={0}", id);
    }
    /**
     * Guardar un nuevo Articulo
     * @param entity La entidad de tipo articulo del nuevo articulo a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios. 
     */
    public ArticuloEntity createArticulo(ArticuloEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación del articulo");
        if (validateNombreArticulo(entity.getNombreArticulo())) {
            throw new BusinessLogicException("El nombre o el link no pueden ser vacios");
        }
       
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de articulo");
        return entity;
    }
    /**
     * Actualizar un articulo por ID
     * @param id El ID del articulo a actualizar
     * @param entity La entidad del articulo con los cambios deseados
     * @return La entidad del articulo luego de actualizarla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios o se intento cambiar el id.
     */
    public ArticuloEntity updateArticulo(Long id, ArticuloEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar articulo con id={0}", id);
        if (validateNombreArticulo(entity.getNombreArticulo())) {
            throw new BusinessLogicException("El nombre no puede ser vacio");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del articulo");
        }
        ArticuloEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar articulo con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el nombre del cliente es un string válido, false de lo contrario.
     * @param nombreArticulo nombre del cliente
     * @return true si el nombre del cliente es un string válido, false de lo contrario.
     */
    private boolean validateNombreArticulo( String nombreArticulo ){
       return nombreArticulo==null || nombreArticulo.isEmpty();
    }
    
 
    
}
