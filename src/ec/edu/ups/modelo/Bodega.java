/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;


/**
 *
 * @author Usuario
 */
public class Bodega {

    private int codigo;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int stock;
    

 

    public Bodega() {
   
    }

    public Bodega(int codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCiudad(ciudad);

    
        
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarEspacios(nombre, 25);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = validarEspacios(direccion, 60);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = validarEspacios(ciudad, 25);
    }

    public String validarEspacios(String cadena, int n) {
        if (cadena.length() == n) {
            return cadena;
        } else {
            if (cadena.length() < n) {
                return LlenarEspacios(cadena, n);
            } else {
                return cortarEspacios(cadena, n);
            }
        }

    }

    public String cortarEspacios(String cadena, int n) {
        return cadena.substring(0, n);

    }

    public String LlenarEspacios(String cadena, int n) {
        return String.format("%-" + n + "s", cadena);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bodega other = (Bodega) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bodega{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" 
                + direccion + ", ciudad=" + ciudad + '}';
    }

}
