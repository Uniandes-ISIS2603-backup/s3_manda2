/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author n.bello
 */
@Entity
public class EmpleadoEntity extends UsuarioEntity implements Serializable{
    
    private String identificacio;
    
    private String foto;
    
    private String EPS;
    
    @OneToMany(mappedBy = "empleado")
    @PodamExclude
    private List<PagoEntity> pagos;
    
    @OneToMany(mappedBy="empleado")
    @PodamExclude
    private List<ReclamoEntity> reclamos;
    
    @OneToMany(mappedBy="empleado")
    @PodamExclude
    private List<ServicioEntity> servicios;
    
    public String getIdentificacio() {
        return identificacio;
    }

    public void setIdentificacio(String identificacio) {
        this.identificacio = identificacio;
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

//    public void addServicio( ServicioEntity servicio ){
//        servicios.add(servicio);
//    }
    
    public List<ServicioEntity> getServicios(){
        return servicios;
    }
    
    public void setServicios( List<ServicioEntity> servicios ){
        this.servicios = servicios;
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
  
   
}
