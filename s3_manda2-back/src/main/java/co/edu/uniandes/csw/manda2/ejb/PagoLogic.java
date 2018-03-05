/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.PagoPersistence;
import java.util.Date;
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
public class PagoLogic {

    //Constantes
    private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());
    //Atributos
    @Inject
    private PagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Devuelve todos los pagos que hay en la base de datos.
     *
     * @return Lista de entidades de tipo pago.
     */
    public List<PagoEntity> getPagos() {
        LOGGER.info("Inicia proceso de consultar todos los pagos");
        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los pagos");
        return pagos;
    }

    /**
     * Busca un pago por ID
     *
     * @param id El id del cl a buscar
     * @return El pago encontrado, null si no lo encuentra.
     */
    public PagoEntity getPago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar pago de credito con id={0}", id);
        PagoEntity pago = persistence.find(id);
        if (pago == null) {
            LOGGER.log(Level.SEVERE, "La pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar pago con id={0}", id);
        return pago;
    }

    /**
     * Eliminar un pago
     *
     * @param id El ID del pago a eliminar
     */
    public void deletePago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar pago con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar pago con id={0}", id);
    }

    /**
     * Guardar un nuevo pago
     *
     * @param entity La entidad de tipo pago del nuevo pago a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban
     * vacios.
     */
    public PagoEntity createPago(PagoEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación del pago");
//        if (!validateNombreCliente(entity.getCliente().getNombre())) {
//            throw new BusinessLogicException("El nombre del cliente no puede ser vacio");
//        } else
            if (!validateFecha(entity.getFecha())) {
            throw new BusinessLogicException("La fecha del pago no puede ser vacio");
        } else if (!validateEstado(entity.getEstadoTransaccion())) {
            throw new BusinessLogicException("El estaod del pago no puede ser vacio");
        }

         if(getPago(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos pagos con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del pago");
        return entity;
    }

    /**
     * Actualizar un pago por ID
     *
     * @param id El ID del pago a actualizar
     * @param entity La entidad del pago con los cambios deseados
     * @return La entidad del pagoluego de actualizarla
     * @throws BusinessLogicException Si el nombre o la cedula son nulos o
     * estaban vacios, se intento cambiar el id o la cedula que se iba a cambiar
     * ya estaba en el sistema.
     */
    public PagoEntity updatePago(Long id, PagoEntity entity) throws BusinessLogicException {

        LOGGER.log(Level.INFO, "Inicia proceso de actualizar pago con id={0}", id);
//        if (!validateNombreCliente(entity.getCliente().getNombre())) {
//            throw new BusinessLogicException("El nombre del cliente no puede ser vacio");
//        } else
            
         if (!validateFecha(entity.getFecha())) {
            throw new BusinessLogicException("La fecha del pago no puede ser vacio");
        } else if (!validateEstado(entity.getEstadoTransaccion())) {
            throw new BusinessLogicException("El estaDd del pago no puede ser vacio");
        }
        if (id != entity.getId()) {
            throw new BusinessLogicException("No se puede cambiar el id del pago");
        }
 
    
        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pago con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Retorna true si el nombre del cliente que realiza el pago es un string
     * válido, false de lo contrario.
     *
     * @param nombreCliente nombre del cliente que realiza el pago
     * @return true si el nombre del cliente que realiza el pagodel pago es un
     * string válido, false de lo contrario.
     */
    private boolean validateNombreCliente(String nombreCliente) {
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }

    /**
     * Retorna true si la fecha del pago es un string válido, false de lo
     * contrario.
     *
     * @param fecha fecha del pago
     * @return true si la fecha del pago es un string válido, false de lo
     * contrario.
     */
    private boolean validateFecha(Date fecha) {
        return (fecha != null);
    }

    /**
     * Retorna true si el estado del pago es un string válido, false de lo
     * contrario.
     *
     * @param estado estado de transaccion
     * @return true si el estado del pago es un string válido, false de lo
     * contrario.
     */
    private boolean validateEstado(String estado) {
        return (estado != null && !estado.isEmpty());
    }
}
