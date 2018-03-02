/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ClienteDTO} Al
 * serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaDeIngreso": date,
 *      "calificacion": Double,
 *      "pagoAnticipado": boolean,
 *      "horasDeServicioSemanal": number,
 *
 *      "quejasYReclamos": [{
 *      "mensaje": string,
 *      "numero": number,
 *      "id": number
 *   }],
 *      "servicios": [{
 *      "costoDeTransporte": 500,
 *      "id": Long,
 *      "nombre": String,
 *      "costo": Double,
 *      "puntoDeEncuentro": String,
 *      "puntoDeRealizacion": String,
 *      "exitoDiligencia": Boolean,
 *      "calification": Double,
 *      "descripcion": String,
 * }],
 *      "pagos": [{
 *      "id": long,
 *      "estadoTransaccion: string,
 *      "fecha": date
 *   }],
 *      "billetera" [{
 *      "saldo": Double,
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
 *      "servicios": [{
 *      "costoDeTransporte": 500,
 *      "id": 525252145256,
 *      "nombre": "Nicolas Bello",
 *      "costo": 58455452,
 *      "puntoDeEncuentro": "C.C mazuren",
 *      "puntoDeRealizacion": "Las vegas",
 *      "exitoDiligencia": true,
 *      "calification": 5,
 *      "descripcion": "Hamburguesa grande",
 * }],
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
 *
 * @author na.caceres
 */
public class ClienteDetailDTO extends ClienteDTO {

    //Atributos
    /**
     * Atributo que representa la billetera que tiene cada usuario.
     */
    private BilleteraDTO billetera;
    /**
     * Atributo que modela una lista con todos los servicios contratados por un
     * usuario.
     */
    private List<ServicioDTO> servicios;
    /**
     * Atributo que modela una lista con todos los pagos contratados por un
     * usuario.
     */
    private List<PagoDTO> pagos;
    /**
     * Atributo que modela una lista con todos los reclamos hechos por un
     * usuario.
     */
    private List<ReclamoDTO> quejasYReclamos;

    //Constructor
    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public ClienteDetailDTO(ClienteEntity entity) {

        super(entity);
        if (entity != null) {
            if (entity.getBilletera() != null) {
                this.billetera = new BilleteraDTO(entity.getBilletera());
            }
            //Cada servicio tiene un constructuro a partir de un entity diferente¿? Preguntar a Rubby.

            //if (entity.getServicios() != null) {
              //  this.servicios = new ArrayList<>();
                //for (ServicioEntity entityServicio : entity.getServicios()) {
                  //  entityServicio.class()==EntregasDeDocumentosEntity.class();
                   
                   //{
                     //   servicios.add(new EntregasDeDocumentosDTO(entityServicio));
                   //}
                    
                //}
           // }

            if (entity.getPagos() != null) {
                this.pagos = new ArrayList<>();
                for (PagoEntity entityPago : entity.getPagos()) {
                    pagos.add(new PagoDTO(entityPago));
                }
            }
            if (entity.getQuejasYReclamos() != null) {
                this.quejasYReclamos = new ArrayList<>();
                for (ReclamoEntity entityReclamo : entity.getQuejasYReclamos()) {
                    quejasYReclamos.add(new ReclamoDTO(entityReclamo));
                }
            }
        }
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
    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the pagos
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the quejasYReclamos
     */
    public List<ReclamoDTO> getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(List<ReclamoDTO> quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity clienteE = super.toEntity();
//        if (billetera != null) {
//            clienteE.setBilletera(billetera.toEntity());
//        }
//        //Mismo problema que en el constructor que hago¿?
//        if (servicios != null) {
//            List<ServicioEntity> serviciosEntity = new ArrayList<>();
//            for (ServicioDTO dtoServicio : servicios) {
//                serviciosEntity.add(dtoServicio.toEntity());
//            }
//            clienteE.setServicios(serviciosEntity);
//        }
//        if (pagos != null) {
//            List<PagoEntity> pagosEntity = new ArrayList<>();
//            for (PagoDTO dtoPago : pagos) {
//                pagosEntity.add(dtoPago.toEntity());
//            }
//            clienteE.setPagos(pagosEntity);
//        }
//        if (quejasYReclamos != null) {
//            List<ReclamoEntity> reclamosEntity = new ArrayList<>();
//            for (ReclamoDTO dtoReclamo : quejasYReclamos) {
//                reclamosEntity.add(dtoReclamo.toEntity());
//            }
//            clienteE.setQuejasYReclamos(reclamosEntity);
//        }
        return clienteE;
    }
}
