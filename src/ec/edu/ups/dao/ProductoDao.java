/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IProductoDao;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Producto;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class ProductoDao implements IProductoDao {

    /**
     * Estructura del Archivo private int codigo; 4 bytes private String
     * nombre;25 caracteres + 2 bytes extras private double precio; 8 bytes
     * private int cantidad; 4 bytes private String descripcion; 80 caracteres +
     * 2 bytes extras private int codigoBodega 4 bytes 125 + 4 bytes extras por
     * String = 129 bytes por registro
     */
    private int codigo;
    private int tamanioRegistro;
    private RandomAccessFile archivo;
    //Atributos de Relacion
    private BodegaDao bodegaDao;

    public ProductoDao() {
        codigo = 0;
        bodegaDao = new BodegaDao();
        this.tamanioRegistro = 129;
        try {
            archivo = new RandomAccessFile("datos/productos.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura: ProductoDao");

        }
    }

    @Override
    public void create(Producto producto) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(producto.getCodigo());
            archivo.writeUTF(producto.getNombre());
            archivo.writeDouble(producto.getPrecio());
            archivo.writeInt(producto.getCantidad());
            archivo.writeUTF(producto.getDescripcion());
            archivo.writeInt(producto.getBodega().getCodigo());

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create: ProductoDao");
        }
    }

    @Override
    public Producto read(int codigo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    Producto producto = new Producto(codigoA, archivo.readUTF().trim(), archivo.readDouble(),
                            archivo.readInt(), archivo.readUTF().trim());
                    Bodega bodega = bodegaDao.read(archivo.readInt());
                    producto.asignarBodega(bodega);
                    return producto;
                }

                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:ProductoDao");
        }
        return null;

    }

    @Override
    public void update(Producto producto) {
        int salto = 0;
        int codi = producto.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codi) {

                    archivo.writeUTF(producto.getNombre());
                    archivo.writeDouble(producto.getPrecio());
                    archivo.writeInt(producto.getCantidad());
                    archivo.writeUTF(producto.getDescripcion());

                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(Update: ProductoDao)");
        }
    }

    @Override
    public void delete(Producto producto) {
        try {
            int cod = producto.getCodigo();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == cod) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeDouble(0);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(80));
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
    public List<Producto> listarTodosProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                int valor = archivo.readInt();
                if (valor > 0) {
                    Producto producto = new Producto(valor, archivo.readUTF().trim(), archivo.readDouble(),
                            archivo.readInt(), archivo.readUTF().trim());
                    Bodega bodega = bodegaDao.read(archivo.readInt());
                    producto.asignarBodega(bodega);
                    listaProductos.add(producto);

                }

                salto += tamanioRegistro;
            }
            return listaProductos;
        } catch (IOException ex) {
            System.out.println("error listarTodosProductos : ProductoDao");
        }
        return listaProductos;

    }

    @Override
    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() >= tamanioRegistro) {
                archivo.seek(archivo.length() - tamanioRegistro);
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura:ProductoDao");
        }

        return codigo;
    }

    @Override
    public List<Producto> listarPorBodega(int codigo) {
        List<Producto> listar = new ArrayList();
        int salto = 125;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    archivo.seek(salto);
                    archivo.seek(salto - 125);
                    int c = archivo.readInt();
                    if (c != 0) {
                        Producto producto = new Producto(codigoA, archivo.readUTF().trim(), archivo.readDouble(),
                                archivo.readInt(), archivo.readUTF().trim());
                        Bodega bodega = bodegaDao.read(archivo.readInt());
                        producto.asignarBodega(bodega);
                        listar.add(producto);
                    }
                }

                salto += tamanioRegistro;
            }
            return listar;
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura listarPorBodega :ProductoDao");
        }
        return listar;

    }

}
