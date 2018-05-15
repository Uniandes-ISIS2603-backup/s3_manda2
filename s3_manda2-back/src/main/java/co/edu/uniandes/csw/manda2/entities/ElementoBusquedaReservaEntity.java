/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author cv.trujillo
 */
@Entity
public class ElementoBusquedaReservaEntity extends BaseEntity implements Serializable {

    /**
     * nombre del elemento de busqueda
     *
     */
    private String nombre;

    /**
     * El dato de busqueda, filtro de la reserva que se quiere hcer
     *
     */
    private String datosBusqueda;
    /**
     * Determina si la busqueda fue exitosa
     *
     */

    private Boolean exitosa;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Obtener los datos del elemento a buscar
     *
     * @return datosBusqueda los datos de la busqueda.
     *
     */
        public String getDatosBusqueda() {
        return datosBusqueda;
    }

    /**
     * Establecer los datos del elemento
     *
     * @param datosBusqueda los datos de la busqueda
     */
    public void setDatosBusqueda(String datosBusqueda) {
        this.datosBusqueda = datosBusqueda;
    }

    /**
     * Indica si el eleme. de busq. es exitoso
     *
     * @return exitosa boolean si la busqueda fue exitosa.
     *
     */
    public Boolean isExistosa() {
        return exitosa;
    }

    /**
     * Establecer si es exitosa o no
     *
     * @param exitosa establecer el estado
     *
     */
    public void setExitosa(Boolean exitosa) {
        this.exitosa = exitosa;
    }
}
