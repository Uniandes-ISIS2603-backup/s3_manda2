/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.manda2.persistence.CityPersistence;
import co.edu.uniandes.csw.manda2.persistence.TarjetaCreditoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author na.caceres
 */
@Stateless
public class TarjetaCreditoLogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());
    //Atributos
    @Inject
    private TarjetaCreditoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos las tarjetas de credito que hay en la base de datos.
     * @return Lista de entidades de tipo TarjetaCredito.
     */
    public List<TarjetaCreditoEntity> getTarjetasCreditos() {
        LOGGER.info("Inicia proceso de consultar todas las tarjetas de credito");
        List<TarjetaCreditoEntity> tarjetas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos las tarjetas de credito");
        return tarjetas;
    }
    /**
     * Busca una tarjeta por ID
     * @param id El id de la tarjeta  a buscar
     * @return La tarjeta encontrada, null si no lo encuentra.
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar tarjeta de credito con id={0}", id);
        TarjetaCreditoEntity tarjeta = persistence.find(id);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "La tarjeta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar tarjeta con id={0}", id);
        return tarjeta;
    }
    /**
     * Eliminar una TarjetaCredito
     * @param id El ID de la tarjeta a eliminar
     */
    public void deleteTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar tarjeta de credito con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar tarjeta de credito con id={0}", id);
    }
}
