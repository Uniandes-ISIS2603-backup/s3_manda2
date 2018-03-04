/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
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
public class BilleteraLogic {

    private static final Logger LOGGER = Logger.getLogger(BilleteraLogic.class.getName());

    @Inject
    private BilleteraPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
//
    private Long id;

    public List<BilleteraEntity> getBilleteras() {
        LOGGER.info("Inicia proceso de consultar todas las billeteras");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BilleteraEntity> billeteras = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las billeteras");
        return billeteras;
    }

    /**
     * Busca una billetera por ID
     *
     * @param id El id de la billetera a buscar
     * @return La billetera encontrada, null si no lo encuentra.
     */
    public BilleteraEntity getBilletera(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar billetera con id={0}", id);
        BilleteraEntity billetera = persistence.find(id);
        if (billetera == null) {
            LOGGER.log(Level.SEVERE, "La billetera con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar billetera con id={0}", id);
        return billetera;
    }

    /**
     * Eliminar una billetera
     *
     * @param id El ID de la billetera a eliminar
     */
    public void deleteBilletera(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar billetera con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar billetera con id={0}", id);
    }

    /**
     * Guardar una nueva billetera
     *
     * @param entity La entidad de la billetera a persistir
     * @return La entidad billetera luego de persistirla
     * @throws BusinessLogicException Si la cedula del cliente o el saldo en la
     * billetera son nulos o estaban vacios.
     */
    public BilleteraEntity createBilletera(BilleteraEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de la billetera");
        if (!validateCedula(entity.getCliente().getCedula())) {
            throw new BusinessLogicException("La cedula no puede ser vacia");
        } else if (!validateSaldo(entity.getSaldo())) {
            throw new BusinessLogicException("El saldo de la billetera no puede ser vacia/ no es valido");
        }
        BilleteraEntity billeteraAntes = persistence.find(id);
        if (billeteraAntes != null) {
            if (!billeteraAntes.getCliente().getCedula().equals(entity.getCliente().getCedula())) {
                if (persistence.findByCedula(entity.getCliente().getCedula()) != null) {
                    throw new BusinessLogicException("No se puede cambiar la cedula a una ya existente");
                }
            }
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la billetera");
        return entity;

    }

    /**
     * Actualizar billetera por iD
     *
     * @param id El ID de la billetera a actualizar
     * @param entity La entidad de la billetera con los cambios deseados
     * @return La entidad de la billetera despues de actualizarla
     * @throws BusinessLogicException Si la cedula, saldo o puntos de fidelidad
     * son nulos o estaban vacios, se intento cambiar el id que se iba a cambiar
     * ya estaba en el sistema.
     */
    public BilleteraEntity updateBilletera(Long id, BilleteraEntity entity) throws BusinessLogicException {

        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la billetera con id={0}", id);
        if (!validateCedula(entity.getCliente().getCedula())) {
            throw new BusinessLogicException("La cedula no puede ser vacia");
        } else if (!validateSaldo(entity.getSaldo())) {
            throw new BusinessLogicException("El saldo de la billetera no puede ser vacia/ no es valido");
        }
        if (id != entity.getId()) {
            throw new BusinessLogicException("No se puede cambiar el id de  la billetera");
        }
        BilleteraEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pse con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Retorna true si el saldo es un Double válido, false de lo contrario.
     *
     * @param saldo saldo de la billetera.
     * @return true si el saldo de la billetera es un Double valido, false de lo
     * contrario.
     */
    private boolean validateSaldo(Double saldo) {
        return (saldo != null && saldo > 0);
    }

    /**
     * Retorna true si la cedula del cliente es un string válido, false de lo
     * contrario. 
     *
     * @param cedula cedula del cliente
     * @return true si la cedula del cliente es un string válido, false de lo
     * contrario.
     */
    private boolean validateCedula(String cedula) {
        return (cedula != null && !cedula.isEmpty());
    }
}
