/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author n.bello
 */
@Entity
public class EmpleadoEntity extends UsuarioEntity implements Serializable {

    private String identificacion;

    private String foto;

    private String EPS;

    @OneToMany(mappedBy = "empleado")
    @PodamExclude
    private List<PagoEntity> pagos;

    @OneToMany(mappedBy = "empleado")
    @PodamExclude
    private List<ReclamoEntity> reclamos;

    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<ComprasEnTiendaEntity> comprasEnTienda;

    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<EntregasDeDocumentosEntity> entregasDeDocumentos;

    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<OrganizacionEntity> organizaciones;

    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<VueltasConDemoraEnOficinaEntity> vueltasConDemoraEnOficina;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public List<PagoEntity> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    public List<ReclamoEntity> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<ReclamoEntity> reclamos) {
        this.reclamos = reclamos;
    }

    public List<ComprasEnTiendaEntity> getComprasEnTienda() {
        return comprasEnTienda;
    }

    public void setComprasEnTienda(List<ComprasEnTiendaEntity> comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    public List<EntregasDeDocumentosEntity> getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    public void setEntregasDeDocumentos(List<EntregasDeDocumentosEntity> entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    public List<OrganizacionEntity> getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(List<OrganizacionEntity> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public List<VueltasConDemoraEnOficinaEntity> getVueltasConDemoraEnOficina() {
        return vueltasConDemoraEnOficina;
    }

    public void setVueltasConDemoraEnOficina(List<VueltasConDemoraEnOficinaEntity> vueltasConDemoraEnOficina) {
        this.vueltasConDemoraEnOficina = vueltasConDemoraEnOficina;
    }
}
