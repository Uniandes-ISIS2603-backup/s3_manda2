/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PayPalEntity;

/**
 * Clase que representa el medio de pago de PayPal.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombreCliente": string,
 *      "linkPayPal": string
 *   }
 * </pre> Por ejemplo un PayPal se representa así:<br>
 *
 * <pre>
 *   {
 *      "id":1,
 *      "nombreCliente":"Brien Bogies",
 *      "linkPayPal":"http://ox.ac.uk/semper/porta/volutpat.jsp?platea=ipsum&dictumst=aliquam&maecenas=non&ut=mauris&massa=morbi&quis=non&augue=lectus&luctus=aliquam&tincidunt=sit&nulla=amet&mollis=diam&molestie=in&lorem=magna&quisque=bibendum&ut=imperdiet&erat=nullam&curabitur=orci&gravida=pede&nisi=venenatis&at=non&nibh=sodales&in=sed&hac=tincidunt&habitasse=eu&platea=felis&dictumst=fusce&aliquam=posuere&augue=felis&quam=sed&sollicitudin=lacus&vitae=morbi&consectetuer=sem&eget=mauris&rutrum=laoreet&at=ut&lorem=rhoncus&integer=aliquet&tincidunt=pulvinar&ante=sed&vel=nisl&ipsum=nunc&praesent=rhoncus&blandit=dui&lacinia=vel&erat=sem&vestibulum=sed&sed=sagittis&magna=nam&at=congue&nunc=risus&commodo=semper&placerat=porta&praesent=volutpat&blandit=quam&nam=pede&nulla=lobortis&integer=ligula&pede=sit&justo=amet&lacinia=eleifend&eget=pede&tincidunt=libero&eget=quis&tempus=orci&vel=nullam&pede=molestie&morbi=nibh&porttitor=in&lorem=lectus&id=pellentesque&ligula=at&suspendisse=nulla&ornare=suspendisse&consequat=potenti&lectus=cras&in=in&est=purus&risus=eu&auctor=magna&sed=vulputate&tristique=luctus&in=cum&tempus=sociis&sit=natoque&amet=penatibus&sem=et&fusce=magnis&consequat=dis&nulla=parturient"
 *   }
 * </pre>
 *
 * @author da.ramos
 */
public class PayPalDTO extends MedioPagoDTO {

    public PayPalDTO() {
    }

    public PayPalDTO(PayPalEntity entity) {
        if( entity != null){
            this.id = entity.getId();
            this.linkPayPal = entity.getLinkPayPal();
            this.nombreCliente = entity.getNombreCliente();
        }
    }

    @Override
    public PayPalEntity toEntity() {
        PayPalEntity entity = new PayPalEntity();
        entity.setId(id);
        entity.setLinkPayPal(linkPayPal);
        entity.setNombreCliente(nombreCliente);
        return entity;
    }

    /**
     * Link de PayPal.
     */
    private String linkPayPal;

    /**
     * Retorna el link de PayPal.
     *
     * @return Link de PayPal.
     */
    public String getLinkPayPal() {
        return linkPayPal;
    }

    /**
     * Asigna el link de PayPal al dado por parámetro.
     *
     * @param linkPayPal Nuevo link de PayPal.
     */
    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }
}
