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

        if (!validateCalificacion(entity.getCalificacion())) {
            throw new BusinessLogicException("La calificación del servicio no es válida");
        } else if (!validateCliente(entity.getCliente())) {
            throw new BusinessLogicException("El cliente asociado al servicio no es válido");
        } else if (!validateCosto(entity.getCosto())) {
            throw new BusinessLogicException("El costo del servicio no es válido");
        } else if (!validateDescripcion(entity.getDescripcion())) {
            throw new BusinessLogicException("La descripción del servicio no es válida");
        } else if (!validateEmpleado(entity.getEmpleado())) {
            throw new BusinessLogicException("El empleado asociado al servicio no es válido");
        } else if (!validateEstado(entity.getEstado())) {
            throw new BusinessLogicException("El estado del servicio no es válido");
        } else if (!validateNombre(entity.getNombre())) {
            throw new BusinessLogicException("El nombre del servicio no es válido");
        }
        else if (!validatePuntoDeEncuentro(entity.getPuntoDeEncuentro())) {
            throw new BusinessLogicException("El punto de encuentro del servicio no es válido");
        } else if (!validatePuntoDeRealizacion(entity.getPuntoDeRealizacion())) {
            throw new BusinessLogicException("El punto de realización del servicio no es válido");
        } else if (servicioPersistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un servicio con el id dado.");
        }
        servicioPersistence.create(entity);
        LOGGER.info("Termina proceso de creación de servicio");
        return entity;
    }

    public ServicioEntity updateServicio(Long id, ServicioEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualización del servicio con id={0}", id);
        if (!validateCalificacion(entity.getCalificacion())) {
            throw new BusinessLogicException("La calificación del servicio no es válida");
        } else if (!validateCliente(entity.getCliente())) {
            throw new BusinessLogicException("El cliente asociado al servicio no es válido");
        } else if (!validateCosto(entity.getCosto())) {
            throw new BusinessLogicException("El costo del servicio no es válido");
        } else if (!validateDescripcion(entity.getDescripcion())) {
            throw new BusinessLogicException("La descripción del servicio no es válida");
        } else if (!validateEmpleado(entity.getEmpleado())) {
            throw new BusinessLogicException("El empleado asociado al servicio no es válido");
        } else if (!validateEstado(entity.getEstado())) {
            throw new BusinessLogicException("El estado del servicio no es válido");
        } else if (!validateNombre(entity.getNombre())) {
            throw new BusinessLogicException("El nombre del servicio no es válido");
        } else if (!validatePuntoDeEncuentro(entity.getPuntoDeEncuentro())) {
            throw new BusinessLogicException("El punto de encuentro del servicio no es válido");
        } else if (!validatePuntoDeRealizacion(entity.getPuntoDeRealizacion())) {
            throw new BusinessLogicException("El punto de realización del servicio no es válido");
        }
        else if( !id.equals(entity.getId()) ){
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

    private boolean validateNombre(String nombre) {
        return nombre != null && !nombre.isEmpty();
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

    private boolean validatePuntoDeEncuentro(String puntoDeEncuentro) {
        return puntoDeEncuentro != null && !puntoDeEncuentro.isEmpty();
    }

    private boolean validatePuntoDeRealizacion(String puntoDeRealizacion) {
        return puntoDeRealizacion != null && !puntoDeRealizacion.isEmpty();
    }

    private boolean validateCalificacion(Double calificacion) {
        return calificacion != null && calificacion >= 0;
    }

    private boolean validateDescripcion(String descripcion) {
        return descripcion != null && !descripcion.isEmpty();
    }

    private boolean validatePago(PagoEntity pago) {
        return pago != null;
    }

    private boolean validateEmpleado(EmpleadoEntity empleado) {
        return empleado != null;
    }

    private boolean validateCliente(ClienteEntity cliente) {
        return cliente != null;
    }
}
