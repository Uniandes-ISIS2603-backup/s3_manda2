/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.persistence.PSEPersistence;
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
}
