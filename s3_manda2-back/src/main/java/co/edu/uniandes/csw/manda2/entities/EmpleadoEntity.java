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

    /**
     * Identificación del empleado
     */
    private String identificacion;

    /**
     * Foto del empleado
     */
    private String foto;

    /**
     * eps del empleado
     */
    private String eps;

    /**
     * Listado de todos los pagos que ha hecho el empleado.
     */
    @OneToMany
    @PodamExclude
    private List<PagoEntity> pagos;

   
    

    /**
     * Reclamos del empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    private List<ReclamoEntity> reclamos;

    /**
     * Servicios de compras en tieneda asociados al empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<ComprasEnTiendaEntity> comprasEnTienda;

    /**
     * Servicios de entregas de documentos asociados al empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<EntregasDeDocumentosEntity> entregasDeDocumentos;

    /**
     * Servicios de organización asociados al empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<OrganizacionEntity> organizaciones;

    /**
     * Servicios de vueltas con demora en oficina asociados al empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<VueltasConDemoraEnOficinaEntity> vueltasConDemoraEnOficina;

    /**
     * Retorna la identificación del empleado.
     *
     * @return identificación del empleado
     */
    public String getIdentificacion() {
        return identificacion;

    }

    /**
     * Asigna la identificación al valor dado por parámetro
     * @param identificacion identificación.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Retorna la foto del empleado.
     *
     * @return foto del empleado
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Asigna la foto al valor dado por parámetro.
     * @param foto foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Retorna la eps del empleado.
     *
     * @return eps del empleado
     */
    public String getEps() {
        return eps;
    }

    /**
     * Asigna la eps al valor dado por parámetro.
     * @param eps eps
     */
    public void setEps(String eps) {
        this.eps = eps;
    }

    /**
     * Retorna los pagos del empleado.
     *
     * @return pagos del empleado
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }

    /**
     * se asigna la lista de pagos al empleado
     *
     * @param pagos Lista de pagos != null
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    /**
     * Retorna los reclamos del empleado.
     *
     * @return reclamos del empleado
     */
    public List<ReclamoEntity> getReclamos() {
        return reclamos;
    }

    /**
     * Asigna los reclamos al valor dado por parámtetro.
     *
     * @param reclamos reclamos
     */
    public void setReclamos(List<ReclamoEntity> reclamos) {
        this.reclamos = reclamos;
    }

    /**
     * Retorna las compras en tienda del empleado.
     *
     * @return compras en tienda del empleado
     */
    public List<ComprasEnTiendaEntity> getComprasEnTienda() {
        return comprasEnTienda;
    }

    /**
     * Asigna las compras en tienda al valor dado por parámetro
     *
     * @param comprasEnTienda compras en tienda
     */
    public void setComprasEnTienda(List<ComprasEnTiendaEntity> comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    /**
     * Retorna los servicios entregas de documentos asociados al empleado.
     *
     * @return entregas de documentos
     */
    public List<EntregasDeDocumentosEntity> getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    /**
     * Asigna las entregas de documentos al valor dado por parámetro
     *
     * @param entregasDeDocumentos entregas de documentos.
     */
    public void setEntregasDeDocumentos(List<EntregasDeDocumentosEntity> entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    /**
     * Retorna los servicios de organizacion asociados al empleado.
     *
     * @return organizaciones
     */
    public List<OrganizacionEntity> getOrganizaciones() {
        return organizaciones;
    }

    /**
     * Asigna las organizaciones al valor dado por parámetro
     *
     * @param organizaciones organizaciones
     */
    public void setOrganizaciones(List<OrganizacionEntity> organizaciones) {
        this.organizaciones = organizaciones;
    }

    /**
     * Retorna los servicios de vueltas con demora en oficina asociados al
     * empleado.
     *
     * @return vueltas con demora en oficina
     */
    public List<VueltasConDemoraEnOficinaEntity> getVueltasConDemoraEnOficina() {
        return vueltasConDemoraEnOficina;
    }

    /**
     * Asigna las vueltas con demora en oficina al valor dado por parámetro
     *
     * @param vueltasConDemoraEnOficina vueltas con demora en oficina
     */
    public void setVueltasConDemoraEnOficina(List<VueltasConDemoraEnOficinaEntity> vueltasConDemoraEnOficina) {
        this.vueltasConDemoraEnOficina = vueltasConDemoraEnOficina;
    }
}
