/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class Factura {

    private int codigo;
    private String numero;
    private String fecha;
    private String estado;
    private double subtotal;
    private double iva;
    private double valorAPagar;
    private Cliente cliente;

    public Factura() {
    }

    public Factura(int codigo, String numero, String estado, double subtotal, double iva, double valorAPagar) {
        this.codigo = codigo;
        this.numero = numero;
        this.setFecha();
        this.setEstado(estado);
        this.subtotal = subtotal;
        this.iva = iva;
        this.valorAPagar = valorAPagar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = validarEspacios(numero, 17);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha() {
        Date fecha = new Date();
        String strDateFormat; // El formato de fecha está especificado  
        strDateFormat = "dd-MMM-aaaa";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        this.fecha = validarEspacios(objSDF.format(fecha), 12);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = validarEspacios(estado, 8);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", numero=" + numero + ", fecha=" + fecha + ", estado=" + estado + ", subtotal=" + subtotal + ", iva=" + iva + ", valorAPagar=" + valorAPagar + ", cliente=" + cliente + '}';
    }

}
