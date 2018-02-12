/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.DTOS;

/**
 *
 * @author cvtrujillo
 */
public class OrganizacionDetailsDTO extends OrganizacionDTO
{
    /**
     * Objeto de busqueda asociado al servicio
     */
    private OrganizacionDTO elementoBusqueda;
    /**
     * Permite obtener el elemento de busqueda
     */
    public OrganizacionDTO getElementoBusqueda()
    {
        return elementoBusqueda;
    }
    /**
     * Permite establecer el elemnto de busqueda
     * @param elementoBusqueda el elementoa establecer
     */
    public void setElementoBusqueda(OrganizacionDTO elementoBusqueda)
    {
        this.elementoBusqueda=elementoBusqueda;
    }
}
