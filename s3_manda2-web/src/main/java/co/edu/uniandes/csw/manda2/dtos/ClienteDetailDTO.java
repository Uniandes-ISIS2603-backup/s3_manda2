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
    public ClienteDetailDTO ()
    {
        super();
        billetera = new BilleteraDTO();
        servicios = new ArrayList<ServicioDTO>();
        pagos = new ArrayList<PagoDTO>();
        quejasYReclamos = new ArrayList<Reclamo>();
    }
    //Metodos
    
}
