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

        if (!validateFecha(entity.getFecha())) {
            throw new BusinessLogicException("La fecha del pago no puede ser vacio");
        } else if (!validateEstado(entity.getEstadoTransaccion())) {
            throw new BusinessLogicException("El estado del pago no puede ser vacio");
        } else if (!validateMedioDePago(entity)) {
            throw new BusinessLogicException("El pago no tiene medio de pago asociado o tiene varios medios de pago");
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
        if (!validateFecha(entity.getFecha())) {
            throw new BusinessLogicException("La fecha del pago no puede ser vacio");
        } else if (!validateEstado(entity.getEstadoTransaccion())) {
            throw new BusinessLogicException("El estado del pago no puede ser vacio");
        } else if (!validateMedioDePago(entity)) {
            throw new BusinessLogicException("El pago no tiene medio de pago asociado o tiene varios medios de pago");
        }
        if (!entity.getId().equals(id)) {
            throw new BusinessLogicException("No se puede cambiar el id del pago");
        }

        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pago con id={0}", entity.getId());
        return newEntity;
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
        return fecha != null;
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
        return estado != null && !estado.isEmpty();
    }

    /**
     * Valida que el pago sólo tenga un tipo de medio de pago.
     *
     * @param entity Pago qu(PagoEntity entity) { return entity.getPayPal() !=
     * null && entity.getPse() == null && entity.getTarjetaDeCredito() == null;
     * }
     *
     * private boolean validatePse(PagoEntity entity) { return entity.getPse()
     * != null && entity.getPayPal() == null && entity.getTarjetaDeCredito() ==
     * null; }
     *
     * private boolean validateTarjetaDeCredito(PagoEntity entity) { return
     * entity.getTarjetaDeCredito() != null && entity.getPayPal() == null &&
     * entity.getPse() == null; } }e se va a validar.
     * @return true si el pago sólo tiene un medio de pago, false de lo
     * contrario.
     */
    private boolean validateMedioDePago(PagoEntity entity) {
        return validatePayPal(entity) || validatePse(entity) || validateTarjetaDeCredito(entity);
    }

    private boolean validatePayPal(PagoEntity entity) {
        return entity.getPayPal() != null && entity.getPse() == null && entity.getTarjetaDeCredito() == null;
    }

    private boolean validatePse(PagoEntity entity) {
        return entity.getPse() != null && entity.getPayPal() == null && entity.getTarjetaDeCredito() == null;
    }

    private boolean validateTarjetaDeCredito(PagoEntity entity) {
        return entity.getTarjetaDeCredito() != null && entity.getPayPal() == null && entity.getPse() == null;
    }
}
