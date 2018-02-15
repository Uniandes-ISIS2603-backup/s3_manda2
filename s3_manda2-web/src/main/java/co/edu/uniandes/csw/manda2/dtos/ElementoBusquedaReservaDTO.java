/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author cv.trujillo
 */
public abstract class  ElementoBusquedaReservaDTO 
{
 
    /**
     * nombre del elemento de busqueda
     * */
    private String nombre;
    
    /**
     * El dato de busqueda
     * */

    private String datosBusqueda;
    /**
     * Determina si la busqueda fue exitosa
     * */
    private boolean exitosa;
    
    /**
     * Obtener del nombre del elemento a buscar
     * */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * Obtener los datos del elemento a buscar
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
     * @param datosBusqueda 
     */
    
    public void setDatos(String datosBusqueda){
        this.datosBusqueda=datosBusqueda;
    }
    /**
     * Indica si el eleme. de busq. es exitoso
     * */
    public boolean isExistosa()
    {
        
        return exitosa;
    }
    
    /**
     * Establecer si es exitosa o no
     * @param para establecer el estado
     * */
    public void setExitosa(boolean exitosa)
    {
        this.exitosa=exitosa;
    }
}
