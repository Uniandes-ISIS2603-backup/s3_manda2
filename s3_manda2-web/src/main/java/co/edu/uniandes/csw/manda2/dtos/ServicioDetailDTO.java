/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ServicioEntity;

/**
 * Clase que representa un servicio de la aplicación en detalle.
 *
 * @author da.ramos
 */
public abstract class ServicioDetailDTO extends ServicioDTO {

    /**
     * Cliente que pide el servicio.
     */
    protected ClienteDTO cliente;

    /**
     * Empleado que realiza el servicio.
     */
    protected EmpleadoDTO empleado;

    public ServicioDetailDTO() {
        super();
    }

    public ServicioDetailDTO(ServicioEntity entity) {
        super(entity);
        if (entity != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
            this.empleado = new EmpleadoDTO(entity.getEmpleado());
        }
    }

    /**
     * Método para convertir el ServicioDetailDTO a ServicioEntity.
     *
     * @return ServicioEntity
     */
    @Override
    public ServicioEntity toEntity() {
        ServicioEntity entity = super.toEntity();
        if (cliente != null) {
            entity.setCliente(this.cliente.toEntity());
        }
        if (empleado != null) {
            entity.setEmpleado(this.empleado.toEntity());
        }
        return entity;
    }

    

    /**
     * Retorna el cliente que pide el servicio.
     *
     * @return Cliente que pide el servicio.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente que pide el servicio al dado por parámetro.
     *
     * @param cliente Nuevo cliente que pide el servicio.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el empleado que realiza el servicio.
     *
     * @return Empleado que realiza el servicio.
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * Asigna el empleado que realiza el servicio al dado por parámetro.
     *
     * @param empleado Nuevo empleado que realiza el servicio.
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
}
