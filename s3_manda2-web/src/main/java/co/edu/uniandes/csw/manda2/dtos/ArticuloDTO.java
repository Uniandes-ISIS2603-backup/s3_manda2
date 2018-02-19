/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * ArticuloDTO Encargado de guardar los articulos a pedir por el usuario. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor. Ésta clase pertence a compraEnTiendaDTO.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "rutaImagen": string,
 *      "nombre": string,
 *      "precio": Double
 *     
 *   }
 * </pre> Por ejemplo un articulo se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "rutaImagen": "C:\Users\Public\Pictures\Imagenes\morcilla",
 *      "nombre": "morcilla",
 *      "precio": 5000
 *     
 *   }
 *
 * </pre>
 
 * @author cv.trujillo
 */
public class ArticuloDTO extends ComprasEnTiendaDTO
{
    
    public ArticuloDTO(){
        this("", "", 0D);
    }

    public ArticuloDTO(String rutaImagen, String nombre, Double precio) {
        this.rutaImagen = rutaImagen;
        this.nombre = nombre;
        this.precio = precio;
    }    
    
    
    /**
     * La ruta de la imágen del artículo
     * */
    private String rutaImagen;
    /**
     * Nombre del articulo
     * */
    private String nombre;
    
    /**
     * El precio del articulo
     * */
    private Double precio;
    
    /**
     * Obtener la ruta de la imagen del articulo
     * @return ruta de la imagen
     * */
    public String getRutaImagen()
    {
        return rutaImagen;
    }
    /**
     * Obtener el nombre del articulo
     * @return nombre
     * */
    
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Obtener el precio del articulo
     * @return precio
     * */
    public Double getPrecio()
    {
        return precio;
    }
    /**
     * Establecer la ruta de la imagen del articulo
     * @param rutaIm nueva ruta 
     * */
    
    public void setRutaImagen(String rutaIm)
    {
        this.rutaImagen=rutaIm;
    }
    
    /**
     *  Establecer  el nombre del articulo
     * @param pNombre nuevo nombre
     * */
    public void setNombreArticulo(String pNombre)
    {
      this.nombre=pNombre;  
    }
    
    /**
     *  Establecer el precio del articulo
     * @param pPrecio nuevo precio
     * */
    public void setPrecio(Double pPrecio)
    {
        this.precio=pPrecio;
    }
    
    
}
