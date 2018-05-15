/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    
      /**
     * Servicio de compras en tieneda asociados al Reclamo.
     */
    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private ComprasEnTiendaEntity comprasEnTienda;

    /**
     * Servicio de entregas de documentos asociados al Reclamo.
     */
    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private EntregasDeDocumentosEntity entregasDeDocumentos;

    /**
     * Servicios de organización asociados al Reclamo.
     */
    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private OrganizacionEntity organizacion;

    /**
     * Servicio de vueltas con demora en oficina asociados al reclamo.
     */
    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private VueltasConDemoraEnOficinaEntity vueltaConDemoraEnOficina;

    
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


    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ComprasEnTiendaEntity getComprasEnTienda() {
        return comprasEnTienda;
    }

    public void setComprasEnTienda(ComprasEnTiendaEntity comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    public EntregasDeDocumentosEntity getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    public void setEntregasDeDocumentos(EntregasDeDocumentosEntity entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    public OrganizacionEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEntity organizacion) {
        this.organizacion = organizacion;
    }

    public VueltasConDemoraEnOficinaEntity getVueltaConDemoraEnOficina() {
        return vueltaConDemoraEnOficina;
    }

    public void setVueltaConDemoraEnOficina(VueltasConDemoraEnOficinaEntity vueltaConDemoraEnOficina) {
        this.vueltaConDemoraEnOficina = vueltaConDemoraEnOficina;
    }
    
    
}
