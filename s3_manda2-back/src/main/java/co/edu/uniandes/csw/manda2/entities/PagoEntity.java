/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;
import java.util.Date;

/**
 *
 * @author m.moreno
 */
public class PagoEntity {
    

    private Long id;

    private String estadoTransaccion;
    
    private Date fecha; 
    
      public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public String estadoTransaccion() {
        return estadoTransaccion;
    }

    public void estadoTransaccion(String estadoTransaccion) {
        this.estadoTransaccion= estadoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEPS(Date fecha) {
        this.fecha = fecha;
    }
}
