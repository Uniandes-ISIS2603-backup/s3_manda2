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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author na.caceres
 */
@Entity
public class ClienteEntity extends UsuarioEntity implements Serializable {

    //Atributos
    /**
     * boolean que representa si un cliente tiene dinero en su billetera virtual
    */
    private Boolean pagoAnticipado;
    /**
     * numero que representa las horas de servicio que tiene un cliente semanalmente
     */
    private Integer horasDeServicioSemanal;
    /**
     * Atributo que representa la billetera que tiene cada usuario.
     */
    @PodamExclude
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private BilleteraEntity billetera;
    /**
     * Servicios de compras en tieneda asociados al empleado.
     */
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<ComprasEnTiendaEntity> comprasEnTienda;

    /**
     * Servicios de entregas de documentos asociados al empleado.
     */
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<EntregasDeDocumentosEntity> entregasDeDocumentos;

    /**
     * Servicios de organización asociados al empleado.
     */
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<OrganizacionEntity> organizaciones;

    /**
     * Servicios de vueltas con demora en oficina asociados al empleado.
     */
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<VueltasConDemoraEnOficinaEntity> vueltasConDemoraEnOficina;;
    /**
     *  Atributo que modela una lista con todos los pagos contratados por un
     * usuario.
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PagoEntity> pagos;
    /**
     * Atributo que modela una lista con todos los reclamos hechos por un
     * usuario.
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReclamoEntity> quejasYReclamos;

    //Metodos

    /**
     * @return the pagoAnticipado
     */
    public Boolean isPagoAnticipado() {
        return pagoAnticipado;
    }

    /**
     * @param pagoAnticipado the pagoAnticipado to set
     */
    public void setPagoAnticipado(Boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    /**
     * @return the horasDeServicioSemanal
     */
    public Integer getHorasDeServicioSemanal() {
        return horasDeServicioSemanal;
    }

    /**
     * @param horasDeServicioSemanal the horasDeServicioSemanal to set
     */
    public void setHorasDeServicioSemanal(Integer horasDeServicioSemanal) {
        this.horasDeServicioSemanal = horasDeServicioSemanal;
    }

    /**
     * @return the billetera
     */
    public BilleteraEntity getBilletera() {
        return billetera;
    }

    /**
     * @param billetera the billetera to set
     */
    public void setBilletera(BilleteraEntity billetera) {
        this.billetera = billetera;
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

    
    
    
    
    /**
     * @return the pagos
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the quejasYReclamos
     */
    public List<ReclamoEntity> getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(List<ReclamoEntity> quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
    }
    
}
