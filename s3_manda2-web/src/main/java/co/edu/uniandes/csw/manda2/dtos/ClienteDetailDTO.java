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
    // Con errores no puedo generar los getters y setters.
}
