/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;
import java.util.ArrayList;
/**
 * Clase que extiende de {@link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ClienteDTO}
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaDeIngreso": date,
 *      "calificacion": double,
 *      "pagoAnticipado": boolean,
 *      "horasDeServicioSemanal": number,
 *      "quejasYReclamos": [{
 *      "mensaje": string, 
 *      "numero": number,
 *      "id": number
 *   }],
 *      "servicios": [],
 *      "pagos": [{
 *      "id": long,
 *      "estadoTransaccion: string,
 *      "fecha": date
 *   }],
 *      "billetera" [{
 *      "saldo": double,
 *      "puntosFidelidad": integer
 *   }]
 *   }
 * </pre> Por ejemplo un cliente detallado se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 084156584,
 *      "nombre": Nicolas Bello,
 *      "cedula": 1020839175,
 *      "fechaDeIngreso": 15/07/06,
 *      "calificacion": 5,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 20,
 *      "quejasYReclamos": [{
 *      "mensaje": "El servicio se demoro mucho", 
 *      "numero": 001,
 *      "id": 001
 *   }],
 *      "servicios": [],
 *      "pagos": ["id": 91852,
 *      "estadoTransaccion: "cancelado",
 *      "fecha": "02/06/2018"],
 *      "billetera" [{
 *      "saldo": 37000,
 *      "puntosFidelidad": "100"
 *   }]
 *   }
 *
 * </pre>
 * @author na.caceres
 */
public class ClienteDetailDTO extends ClienteDTO {
    
    //Atributos
    /**
     * Atributo que representa la billetera que tiene cada usuario.
     */
    private BilleteraDTO billetera;
    /**
     *  Atributo que modela una lista con todos los servicios contratados por un
     * usuario.
     */
    private ArrayList<ServicioDTO> servicios;
    /**
     *  Atributo que modela una lista con todos los pagos contratados por un
     * usuario.
     */
    private ArrayList<PagoDTO> pagos;
    /**
     * Atributo que modela una lista con todos los reclamos hechos por un
     * usuario.
     */
    private ArrayList<ReclamoDTO> quejasYReclamos;
    //Constructor
    /**
     * Constructor por defecto
     * 
     * @param saldo
     * @param puntosFidelidad
     */
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
