/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.CityEntity;
import co.edu.uniandes.csw.manda2.entities.MedioPagoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.CityPersistence;
import co.edu.uniandes.csw.manda2.persistence.MedioPagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.moreno
 */
@Stateless
public class MedioPagoLogic {

    private static final Logger LOGGER = Logger.getLogger(MedioPagoLogic.class.getName());

    @Inject
    private MedioPagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    
    
     /**
     * Devuelve todos los medios de pago que hay en la base de datos.
     * @return Lista de entidades de tipo medioPago.
     */
    public List<MedioPagoEntity> getMediosPagos() {
        LOGGER.info("Inicia proceso de consultar todos los medios de pago");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<MedioPagoEntity> medios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los medios de pago");
        return medios;
    }
    
    
    /**
     * Busca un medioPago por ID
     * @param id El id del medio pago a buscar
     * @return El medio pago  encontrado, null si no lo encuentra.
     */
    public MedioPagoEntity getMedioPago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el medio de pago con id={0}", id);
        MedioPagoEntity tarjeta = persistence.find(id);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "El medio de pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el  medio con id={0}", id);
        return tarjeta;
    }

     /**
     * Eliminar un medio de pago
     * @param id El ID del medio de pago a eliminar
     */
    public void deleteMedioPago(Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar medio pago con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar medio pago con id={0}", id);
    }
    
     /**
     * Guardar un nuevo medio de pago
     * @param entity La entidad de tipo pse del nuevo medio de pago a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre es nulo o esta vacio. 
     */

    public MedioPagoEntity createMedioPago(MedioPagoEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación del medio de pago");
        if (!validateNombreCliente(entity.getNombreCliente())) {
            throw new BusinessLogicException("El nombre no puede ser vacio");
        }
        if(getMedioPago(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos medios de pago con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del medio de pago");
        return entity;
    }

     /**
     * Actualizar un medio de pago por ID
     * @param id El ID del medio de pago a actualizar
     * @param entity La entidad del medio de pago con los cambios deseados
     * @return La entidad del medio de pago luego de actualizarla
     * @throws BusinessLogicException Si el nombre es nulo o esta vacio o se intento cambiar el nombre.
     */
    public MedioPagoEntity updateMedioPago(Long id, MedioPagoEntity entity) throws BusinessLogicException {
        
       LOGGER.log(Level.INFO, "Inicia proceso de actualizar medio de pago con id={0}", id);
       
       
        if (!validateNombreCliente(entity.getNombreCliente())) {
            throw new BusinessLogicException("El nombre no puede ser vacio");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del medio de pago");
        }
        MedioPagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar medio de pago con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Retorna true si el nombre del cliente es un string válido, false de lo
     * contrario.
     * @param nombreCliente nombre del cliente
     * @return true si el nombre del cliente es un string válido, false de lo
     * contrario.
     */
    private boolean validateNombreCliente(String nombreCliente) {
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }
}
