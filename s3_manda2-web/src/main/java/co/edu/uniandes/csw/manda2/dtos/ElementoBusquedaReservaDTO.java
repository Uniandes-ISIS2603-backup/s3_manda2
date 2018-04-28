/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;

/**
 ** ElementoBusqudReservaDTO servicios de tipo reserva. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor. Ésta clase hace parte de la clase OrganizacionDTO
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": string,
 *      "exitosa": Boolean,
 *      "datosBusqueda": string
 *     
 *   }
 * </pre> Por ejemplo un servicio de tipo organizacion se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "nombre": "concierto Carrangueros de Ráquira",
 *      "exitosa": true,
 *      "datosBusqueda": "primera fila con meet and greet"
 *     
 *   }
 *
 * </pre>
 * @author cv.trujillo
 */
public class  ElementoBusquedaReservaDTO
{

    public ElementoBusquedaReservaDTO(){

    }


    public String getDatosBusqueda() {
        return datosBusqueda;
    }

    public void setDatosBusqueda(String datosBusqueda) {
        this.datosBusqueda = datosBusqueda;
    }

    public Boolean getExitosa() {
        return exitosa;
    }

    public ElementoBusquedaReservaDTO(ElementoBusquedaReservaEntity entity) {
        super();
        if(entity!= null)
        {

        this.id = entity.getId();
        this.nombre= entity.getNombreElementoBusquedaReserva();
        }
    }

    private Long id;
 
    /**
     * nombre del elemento de busqueda
     * */
    private String nombre;
    
    /**
     * El dato de busqueda, filtro de la reserva que se quiere hcer
     * */

    private String datosBusqueda;
    /**
     * Determina si la busqueda fue exitosa
     * */
    private Boolean exitosa;
    
    /**
     * Obtener del nombre del elemento a buscar
     * @return nombre retorna el nombre del elemento.
     * */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * Obtener los datos del elemento a buscar
     * @return datosBusqueda los datos de la busqueda.
     * */
    
    public String getDatos()
    {
        return datosBusqueda;
    }
    
    /**
     * Establecer el nombre del nombre
     * @param nombre a establecer
     * */
    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    /**
     * Establecer los datos del elemento
     * @param datosBusqueda los datos de la busqueda
     */
    
    public void setDatos(String datosBusqueda){
        this.datosBusqueda=datosBusqueda;
    }
    /**
     * Indica si el eleme. de busq. es exitoso
     * @return exitosa boolean si la busqueda fue exitosa.
     * */
    public Boolean isExistosa()
    {
        
        return exitosa;
    }
    
    /**
     * Establecer si es exitosa o no
     * @param exitosa establecer el estado
     * */
    public void setExitosa(Boolean exitosa)
    {
        this.exitosa=exitosa;
    }
     /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */

    public ElementoBusquedaReservaEntity toEntity() {
        ElementoBusquedaReservaEntity entity = new ElementoBusquedaReservaEntity();
        entity.setId(this.id);
        entity.setNombreBusquedaReserva(this.getNombre());
        return entity;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
