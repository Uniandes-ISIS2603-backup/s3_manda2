/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.DTOS;

/**
 *
 * @author cvtrujillo
 */
public class ArticuloDTO 
{

    public ArticuloDTO(String rutaImagen, String nombre, double precio) {
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
    private double precio;
    
    /**
     * Obtener la ruta de la imagen del articulo
     * */
    public String getRutaImagen()
    {
        return rutaImagen;
    }
    /**
     * Obtener el nombre del articulo
     * */
    
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Obtener el precio del articulo
     * */
    public double getPrecio()
    {
        return precio;
    }
    /**
     * Establecer la ruta de la imagen del articulo
     * */
    
    public void setRutaImagen(String rutaIm)
    {
        this.rutaImagen=rutaIm;
    }
    
    /**
     *  Establecer  el nombre del articulo
     * */
    public void setNombreArticulo(String pNombre)
    {
      this.nombre=pNombre;  
    }
    
    /**
     *  Establecer el precio del articulo
     * */
    public void setPrecio(double pPrecio)
    {
        this.precio=pPrecio;
    }
    
    
}
