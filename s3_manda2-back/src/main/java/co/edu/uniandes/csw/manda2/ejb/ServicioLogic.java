/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ServicioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author da.ramos
 */
@Stateless
public class ServicioLogic {

    private static final Logger LOGGER = Logger.getLogger(ServicioLogic.class.getName());

    @Inject
    ServicioPersistence servicioPersistence;

    public List<ServicioEntity> getServicios() {
        LOGGER.info("Inicia proceso de consultar servicios");
        List<ServicioEntity> list = servicioPersistence.findAll();
        LOGGER.info("Termina proceso de consultar servicios");
        return list;
    }

    public ServicioEntity getServicio(Long id) {
        LOGGER.log(Level.INFO, "Inicia el proceso de consultar el servicio con id={0}", id);
        ServicioEntity servicio = servicioPersistence.find(id);
        if (servicio == null) {
            LOGGER.log(Level.SEVERE, "El servicio con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina el proceso de consultar el servicio con id={0}", id);
        return servicio;
    }

    public ServicioEntity createServicio(ServicioEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia el proceso de creación de servicio");

        if (!validateServicio(entity)) {
            throw new BusinessLogicException("Uno o varios atributos del servicio no son válidos");
        } if (servicioPersistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un servicio con el id dado.");
        }
        servicioPersistence.create(entity);
        LOGGER.info("Termina proceso de creación de servicio");
        return entity;
    }

    public ServicioEntity updateServicio(Long id, ServicioEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualización del servicio con id={0}", id);
        
        if (!validateServicio(entity)) {
            throw new BusinessLogicException("Uno o varios atributos del servicio no son válidos");
        } if (!id.equals(entity.getId())) {
            throw new BusinessLogicException("El id del servicio no puede ser modificado.");
        }
        ServicioEntity newEntity = servicioPersistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualización de servicio con id={0}", id);
        return newEntity;
    }

    public void deleteServicio(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrado de servicio con id={0}", id);
        servicioPersistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrado de servicio con id={0]", id);
    }

    private boolean validateServicio(ServicioEntity entity) {
        return validateString(entity.getNombre())
                && validateCosto(entity.getCosto())
                && validateEstado(entity.getEstado())
                && validateCalificacion(entity.getCalificacion())
                && validateString(entity.getDescripcion())
                && validateString(entity.getPuntoDeEncuentro())
                && validateString(entity.getPuntoDeRealizacion());
    }

    private boolean validateCosto(Double costo) {
        return costo != null && costo > 0;
    }

    private boolean validateEstado(String estado) {
        return estado != null
                && (ServicioEntity.EN_DESARROLLO.equals(estado)
                || ServicioEntity.EN_ESPERA.equals(estado)
                || ServicioEntity.FINALIZADO.equals(estado));
    }

    private boolean validateString(String string) {
        return string != null && !string.isEmpty();
    }

    private boolean validateCalificacion(Double calificacion) {
        return calificacion != null && calificacion >= 0;
    }
}
