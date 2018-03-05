/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dv.gonzalez10
 */

@Stateless
public class ComprasEnTiendaLogic {
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaLogic.class.getName());
    
    @Inject
    private ComprasEnTiendaPersistence persistence;
    
    public List<ComprasEnTiendaEntity> getCompras ();
}
