/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 Clase que representa la organiazación . 
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "mensaje": string, 
 *      "numero": number,
 *      "id": number,
 *      "empleado": "EmpleadoDTO",
 *      "servicio": "ServicioDTO"  
 * }
 * </pre>
 * Por ejemplo reclamo se representa así:<br>
 * 
 * <pre>
 *   {
 *      ""mensaje": "El servicio se demoro mucho", 
 *      "numero": 001,
 *      "id": 001,
 *      "empleado"[{ "nombre": "nicolas_caceres", 
 *      "cedula": "1014563321",
 *      "fechaingreso": date,
 *      "calificacion": 5.0,
 *      "id": 001,
 *      "identificacion": "nicolascaceres001",
 *      "foto": "nicolascaceres.jpg",
 *      "eps: "millossaludprepagada"]},
 *      "servicio": [{{"costoduracion": 15000, "costodetransporte": 25000, "pago": "paypal", 
 *      "cliente"[{"id": 001,
 *      "nombre": nicolascaceres,
 *      "cedula": 2104565210,
 *      "fechaDeIngreso": Mayo 21,2017,
 *      "calificacion": 5.0,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 5}],
 *      "id":100, "puntodeencuentro": "usaquen", "puntoderealizacion": "usaquen",
 *      "exitodiligencia": true,
 *      "calificacion":5.0, "descripcion": "entregar documentos"}]
 *   }
 * </pre>
 * @author cv.trujillo
 */
public class OrganizacionDetailsDTO extends OrganizacionDTO
{
    
    public OrganizacionDetailsDTO(){
        this(null, 0D, 0D, false, 0L);
    }

    public OrganizacionDetailsDTO(OrganizacionDTO elementoBusqueda, Double costoDeTransporte, Double costoDeDuracion, Boolean desplazamiento, Long id) {
        super(costoDeTransporte, costoDeDuracion, desplazamiento, id);
        this.elementoBusqueda = elementoBusqueda;
    }
    /**
     * Objeto de busqueda asociado al servicio
     */
    private OrganizacionDTO elementoBusqueda;
    /**
     * Permite obtener el elemento de busqueda
     */
    public OrganizacionDTO getElementoBusqueda()
    {
        return elementoBusqueda;
    }
    /**
     * Permite establecer el elemnto de busqueda
     * @param elementoBusqueda el elementoa establecer
     */
    public void setElementoBusqueda(OrganizacionDTO elementoBusqueda)
    {
        this.elementoBusqueda=elementoBusqueda;
    }
}
