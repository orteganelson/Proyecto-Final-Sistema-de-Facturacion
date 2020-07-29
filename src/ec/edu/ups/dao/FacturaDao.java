/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IFacturaDao;
import ec.edu.ups.modelo.Factura;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class FacturaDao implements IFacturaDao {

    /**
     * Estructura del Archivo private int codigo; 4 bytes private String numero;
     * 17 caracteres (Nro 000-000-000005022) + 2 bytes extras private String
     * fecha 12 caracteres + 2 bytes extras; private String estado; 8 caracteres
     * + 2 bytes extras private double subtotal; 8 bytes private double iva; 8
     * bytes private double valorAPagar 8 bytes 65 bytes + 6 bytes por String =
     * 71 bytes por registro
     *
     * @param factura
     */
    private int codigo;
    private int tamanioRegistro;
    private RandomAccessFile archivo;

    public FacturaDao() {
        codigo = 0;
        this.tamanioRegistro = 71;
        try {
            archivo = new RandomAccessFile("datos/facturas.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura: FacturaDao");

        }
    }

    @Override
    public void create(Factura factura) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(factura.getCodigo());
            archivo.writeUTF(factura.getNumero());
            archivo.writeUTF(factura.getFecha());
            archivo.writeDouble(factura.getSubtotal());
            archivo.writeDouble(factura.getIva());
            archivo.writeDouble(factura.getValorAPagar());

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create: ProductoDao");
        }
    }

    @Override
    public Factura read(int codigo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    Factura bodega = new Factura(codigoA, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readDouble(), archivo.readDouble(), archivo.readDouble());

                    return bodega;
                }

                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:BodegaDao");
        }
        return null;

    }

    @Override
    public void anularFactura(Factura factura) {
        int salto = 0;
        int codigo = factura.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    archivo.seek(salto + 37);
                    archivo.writeUTF(validarEspacios("anulado", 8));
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura Update :BodegaDao");
        }
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
    public List<Factura> listarTodasFacturas() {
        return null;

    }

    @Override
    public Double obtenerSubTotal(int codigo) {
        return null;

    }

    @Override
    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() >= tamanioRegistro) {
                archivo.seek(archivo.length() - tamanioRegistro);
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
        }

        return codigo;
    }

}
