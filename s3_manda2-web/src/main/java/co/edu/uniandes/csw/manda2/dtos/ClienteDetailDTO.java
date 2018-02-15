/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;
import java.util.ArrayList;
/**
 *      
 * @author na.caceres
 */
public class ClienteDetailDTO extends ClienteDTO {
    
    //Atributos
    private BilleteraDTO billetera;
    private ArrayList<ServicioDTO> servicios;
    private ArrayList<PagoDTO> pagos;
    private ArrayList<ReclamoDTO> quejasYReclamos;
    //Constructor
    public ClienteDetailDTO (double saldo, Integer puntosFidelidad)
    {
        super();
        billetera = new BilleteraDTO(saldo, puntosFidelidad);
        servicios = new ArrayList<ServicioDTO>();
        pagos = new ArrayList<PagoDTO>();
        quejasYReclamos = new ArrayList<ReclamoDTO>();
    }
    //Metodos

    /**
     * @return the billetera
     */
    public BilleteraDTO getBilletera() {
        return billetera;
    }

    /**
     * @param billetera the billetera to set
     */
    public void setBilletera(BilleteraDTO billetera) {
        this.billetera = billetera;
    }

    /**
     * @return the servicios
     */
    public ArrayList<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(ArrayList<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the pagos
     */
    public ArrayList<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(ArrayList<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the quejasYReclamos
     */
    public ArrayList<ReclamoDTO> getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(ArrayList<ReclamoDTO> quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
    }
    
}
