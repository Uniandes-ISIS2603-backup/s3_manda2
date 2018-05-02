/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.entities.PSEEntity;
import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.entities.TarjetaCreditoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link BilleteraDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link BilleteraDTO}
 *
 * @author m.moreno
 */
public class BilleteraDetailDTO extends BilleteraDTO {

    /**
     * Medio de pago para realizar la transaccion
     */
    private List<PayPalDTO> payPals;

    private List<PSEDTO> pses;

    private List<TarjetaCreditoDTO> tarjetasDeCredito;

    //Constructor
    /**
     * Constructor por defecto
     */
    public BilleteraDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public BilleteraDetailDTO(BilleteraEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getPayPals() != null) {
                for(PayPalEntity paypal: entity.getPayPals()){
                    payPals.add(new PayPalDTO(paypal));
                }
            }
            if (entity.getPses() != null) {
                for(PSEEntity pse: entity.getPses()){
                    pses.add(new PSEDTO(pse));
                }
            }
            if (entity.getTarjetasDeCredito() != null) {
                for(TarjetaCreditoEntity tarjetaDeCredito: entity.getTarjetasDeCredito()){
                    tarjetasDeCredito.add(new TarjetaCreditoDTO(tarjetaDeCredito));
                }
            }
        }
    }

    public List<PayPalDTO> getPayPals() {
        return payPals;
    }

    public void setPayPals(List<PayPalDTO> payPals) {
        this.payPals = payPals;
    }

    public List<PSEDTO> getPses() {
        return pses;
    }

    public void setPses(List<PSEDTO> pses) {
        this.pses = pses;
    }

    public List<TarjetaCreditoDTO> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    public void setTarjetasDeCredito(List<TarjetaCreditoDTO> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }

    public BilleteraEntity toEntity() {
        BilleteraEntity billeteraEntity = super.toEntity();
        if (payPals != null) {
            List<PayPalEntity> entities = new ArrayList<>();
            for (PayPalDTO dto : payPals) {
                entities.add(dto.toEntity());
            }
            billeteraEntity.setPayPals(entities);
        }
        if (pses != null) {
            List<PSEEntity> entities = new ArrayList<>();
            for (PSEDTO dto : pses) {
                entities.add(dto.toEntity());
            }
            billeteraEntity.setPses(entities);
        }
        if (tarjetasDeCredito != null) {
            List<TarjetaCreditoEntity> entities = new ArrayList<>();
            for (TarjetaCreditoDTO dto : tarjetasDeCredito) {
                entities.add(dto.toEntity());
            }
            billeteraEntity.setTarjetasDeCredito(entities);
        }
        return billeteraEntity;
    }
}
