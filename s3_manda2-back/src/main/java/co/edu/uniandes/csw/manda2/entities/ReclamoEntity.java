/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author n.bello
 */
@Entity
public class ReclamoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String mensaje;
    
    private Integer numero;
    
    @PodamExclude
    @ManyToOne
    protected EmpleadoEntity empleado;
    
    @PodamExclude
    @ManyToOne
    protected ServicioEntity servicio;
    
    @PodamExclude
    @ManyToOne
    protected ClienteEntity cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public ServicioEntity getServicio() {
        return servicio;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    
}
