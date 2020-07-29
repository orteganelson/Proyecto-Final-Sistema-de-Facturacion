/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IDetalleDao;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class DetalleDao implements IDetalleDao {

    /**
     * Estructura del Archivo private int codigo; 4 bytes private int cantidad;
     * 4 bytes private double total; 8 bytes private int codigoProducto 4 bytes
     * private int codigoFactura 4 bytes tamaño por registro = 24 bytes
     *
     * @param Detalle
     */
    private int codigo;
    private int tamanioRegistro;
    private RandomAccessFile archivo;
    private ProductoDao productoDao;
    private FacturaDao facturaDao;

    public DetalleDao() {
        codigo = 0;
        productoDao = new ProductoDao();
        facturaDao = new FacturaDao();
        this.tamanioRegistro = 24;
        try {
            archivo = new RandomAccessFile("datos/facturas.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura: DetalleDao");

        }
    }

    @Override
    public void create(Detalle Detalle) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(Detalle.getCodigo());
            archivo.writeInt(Detalle.getCantidad());
            archivo.writeDouble(Detalle.getTotal());
            archivo.writeInt(Detalle.getProducto().getCodigo());
            archivo.writeInt(Detalle.getFactura().getCodigo());

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create: DetalleDao");
        }
    }

    @Override
    public Detalle read(int codigo) {

        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    Detalle detalle = new Detalle(codigoA, archivo.readInt(), archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = facturaDao.read(archivo.readInt());
                    detalle.setFactura(factura);

                    return detalle;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:DetalleDao");
        }
        return null;
    }

    @Override
    public void Update(Detalle Detalle) {
        int salto = 0;
        int codigo = Detalle.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {

                    archivo.writeInt(Detalle.getCantidad());
                    archivo.writeDouble(Detalle.getTotal());
                    archivo.writeInt(Detalle.getProducto().getCodigo());
                    archivo.writeInt(Detalle.getFactura().getCodigo());;

                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(Update: DetalleDao)");
        }
    }

    @Override
    public List<Detalle> listaDetalles() {
        List<Detalle> listar = new ArrayList();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                int valor = archivo.readInt();
                if (valor > 0) {

                    Detalle detalle = new Detalle(valor, archivo.readInt(), archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = facturaDao.read(archivo.readInt());
                    detalle.setFactura(factura);

                    listar.add(detalle);

                }

                salto += tamanioRegistro;
            }
            return listar;
        } catch (IOException ex) {
            System.out.println("error listarTodosProductos : ProductoDao");
        }
        return listar;

    }

    @Override
    public void Delete(Detalle detalle) {
        try {
            int codi = detalle.getCodigo();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codi) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeInt(0);
                    archivo.writeDouble(0);
                    archivo.writeInt(0);
                    archivo.writeInt(0);
                    break;
                }
                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error  Delete : ProductoDao");
        }
    }

    public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
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

    @Override
    public Detalle buscarPorFactura(String numero) {
         int salto = 20;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoFactura = archivo.readInt();
                Factura f= facturaDao.read(codigoFactura);
                if (f.getNumero().equals(numero)) {
                    archivo.seek(salto-20);
                    Detalle detalle = new Detalle(codigoFactura, archivo.readInt(), archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = facturaDao.read(archivo.readInt());
                    detalle.setFactura(factura);

                    return detalle;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:DetalleDao");
        }
        return null;
    }

}
