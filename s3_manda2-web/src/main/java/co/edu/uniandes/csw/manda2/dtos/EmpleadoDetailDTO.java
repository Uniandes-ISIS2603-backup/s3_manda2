/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.util.ArrayList;

/**
 *
 * @author n.bello
 */
public class EmpleadoDetailDTO extends EmpleadoDTO{
    //ATRIBUTOS
    /**
     * Listado de todos los pagos que ha hecho el empleado
     */
    private ArrayList<PagoDTO> pagos;
     /**
     * Listado de todos los servicios del empleado
     */
    private ArrayList<ServicioDetailDTO>servicios;
    //CONSTRUCTOR
    /**
     * 
     **/
    public EmpleadoDetailDTO()
    {   
        super();
        pagos = new ArrayList<PagoDTO>();
        servicios = new ArrayList<ServicioDetailDTO>();
    }

    public ArrayList<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    public ArrayList<ServicioDetailDTO> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<ServicioDetailDTO> servicios) {
        this.servicios = servicios;
    }
    
    
}
