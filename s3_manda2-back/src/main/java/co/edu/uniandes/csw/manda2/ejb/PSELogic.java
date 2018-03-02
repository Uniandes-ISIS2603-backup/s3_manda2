/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.PSEEntity;
import co.edu.uniandes.csw.manda2.persistence.PSEPersistence;
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
public class PSELogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(PSELogic.class.getName());
    //Atributos
    @Inject
    private PSEPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los pses que hay en la base de datos.
     * @return Lista de entidades de tipo pse.
     */
    public List<PSEEntity> getPSEs() {
        LOGGER.info("Inicia proceso de consultar todos los pses");
        List<PSEEntity> pses = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los pses");
        return pses;
    }
    /**
     * Busca un pse por ID
     * @param id El id del pse a buscar
     * @return El pse encontrado, null si no lo encuentra.
     */
    public PSEEntity getPSE(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar pse con id={0}", id);
        PSEEntity pse = persistence.find(id);
        if (pse == null) {
            LOGGER.log(Level.SEVERE, "El pse con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar libro con id={0}", id);
        return pse;
    }
    /**
     * Eliminar un PSE
     * @param id El ID del pse a eliminar
     */
    public void deletePSE(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar pse con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar pse con id={0}", id);
    }
    
}
