/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @OneToOne(mappedBy = "cliente")
    private BilleteraEntity billetera;
    /**
     *  Atributo que modela una lista con todos los servicios contratados por un
     * usuario.
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<ServicioEntity> servicios;
    /**
     *  Atributo que modela una lista con todos los pagos contratados por un
     * usuario.
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<PagoEntity> pagos;
    /**
     * Atributo que modela una lista con todos los reclamos hechos por un
     * usuario.
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<ReclamoEntity> quejasYReclamos;

    //Metodos

    /**
     * @return the pagoAnticipado
     */
    public Boolean isPagoAnticipado() {
        return getPagoAnticipado();
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
     * @return the pagoAnticipado
     */
    public Boolean getPagoAnticipado() {
        return pagoAnticipado;
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

    /**
     * @return the servicios
     */
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }
    
//    /**
//     * @param servicio servicio a agregar
//     */
//    public void addServicio( ServicioEntity servicio ){
//        servicios.add(servicio);
//    }

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
