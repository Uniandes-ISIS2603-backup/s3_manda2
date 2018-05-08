/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;

/**
 * Clase que extiende de {@link PagoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link PagoDTO}
 *
 * @author m.moreno
 */
public class PagoDetailDTO extends PagoDTO {

    /**
     * Servicio por el que se realiza el pago.
     */
    private ServicioDTO servicio;

    /**
     * PayPal asociado al pago.
     */
    private PayPalDTO payPal;
    
    /**
     * PSE asociado al pago.
     */
    private PSEDTO pse;
    
    /**
     * Tarjeta de crédito asociada al pago.
     */
    private TarjetaCreditoDTO tarjetaDeCredito;

    /**
     * Cliente que realiza el pago
     */
    private ClienteDTO cliente;

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);

        if (entity != null) {
            if (entity.getPayPal() != null) {
                this.payPal = new PayPalDTO(entity.getPayPal());
            }
            if (entity.getPse() != null) {
                this.pse = new PSEDTO(entity.getPse());
            }
            if (entity.getTarjetaDeCredito() != null) {
                this.tarjetaDeCredito = new TarjetaCreditoDTO(entity.getTarjetaDeCredito());
            }   
            if (entity.getServicio() != null) {
                this.servicio = new ServicioDTO(entity.getServicio());
            }
            if (entity.getCliente() != null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            }
        }
    }

    /**
     * Constructor vacío con llamado al super.
     */
    public PagoDetailDTO() {
        super();
    }

    /**
     * Retorna el servicio relacionado al pago.
     *
     * @return servicio relacionado al pago.
     */
    public ServicioDTO getServicio() {
        return servicio;
    }

    /**
     * Asigna el servicio por el que se realiza pago.
     *
     * @param pServicio servicio por el que se realiza pago.
     */
    public void setServicio(ServicioDTO pServicio) {
        this.servicio = pServicio;
    }

    /**
     * Retorna el cliente 
     * @return cliente.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente a pCliente.
     * @param pCliente nuevo cliente
     */
    public void setCliente(ClienteDTO pCliente) {
        this.cliente = pCliente;
    }

    /**
     * Retorna el paypal.
     * @return paypal.
     */
    public PayPalDTO getPayPal() {
        return payPal;
    }

    /**
     * Asigna el paypal al valor dado por parámetro.
     * @param payPal nuevo paypal.
     */
    public void setPayPal(PayPalDTO payPal) {
        this.payPal = payPal;
    }

    /**
     * Retorna el pse.
     * @return pse.
     */
    public PSEDTO getPse() {
        return pse;
    }

    /**
     * Asigna el pse al valor dado por parámetro.
     * @param pse nuevo pse.
     */
    public void setPse(PSEDTO pse) {
        this.pse = pse;
    }

    /**
     * Retorna la tarjeta de crédito.
     * @return Tarjeta de crédito.
     */
    public TarjetaCreditoDTO getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * Asigna la tarjeta de crédito al valor dado por parámetro.
     * @param tarjetaCredito nueva tarjeta de crédito.
     */
    public void setTarjetaDeCredito(TarjetaCreditoDTO tarjetaCredito) {
        this.tarjetaDeCredito = tarjetaCredito;
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public PagoEntity toEntity() {
        PagoEntity pagoE = super.toEntity();
        if (payPal != null) {
            pagoE.setPayPal(payPal.toEntity());
        }
        if (pse != null) {
            pagoE.setPse(pse.toEntity());
        }
        if (tarjetaDeCredito != null) {
            pagoE.setTarjetaDeCredito(tarjetaDeCredito.toEntity());
        }
        if (servicio != null) {
            pagoE.setServicio(servicio.toEntity());
        }
        if (cliente != null) {
            pagoE.setCliente(cliente.toEntity());
        }
        return pagoE;
    }
}
