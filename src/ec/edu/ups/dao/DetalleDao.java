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
     * private String numeroFactura 17 caracteres +2 bytes tamaño por registro = 39 bytes
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
        this.tamanioRegistro = 39;
        try {
            archivo = new RandomAccessFile("datos/detalles.dat", "rw");
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
            archivo.writeUTF(Detalle.getFactura().getNumero());

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
                    Detalle detalle = new Detalle();
                    detalle.setCodigo(codigoA);
                    detalle.setCantidad(archivo.readInt());
                    detalle.setTotal(archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = new Factura();
                    factura.setNumero(archivo.readUTF().trim());
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
                    archivo.writeUTF(Detalle.getFactura().getNumero());

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
                if (valor != 0) {

                    Detalle detalle = new Detalle();
                    detalle.setCodigo(valor);
                    detalle.setCantidad(archivo.readInt());
                    detalle.setTotal(archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = new Factura();
                    factura.setNumero(archivo.readUTF().trim());
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
                    archivo.writeUTF(llenarEspacios(17));
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
 
    boolean f=false;
        try {
             long pos= archivo.length() - tamanioRegistro;
             if (archivo.length()==tamanioRegistro){
             archivo.seek(pos);
             codigo=archivo.readInt();
             }else if (archivo.length() > tamanioRegistro) {
              
              
            while(f==false){
                archivo.seek(pos);
               
               if (archivo.readInt()!=0){
                   break;
               }
                pos-=tamanioRegistro;
            }
                archivo.seek(pos);
                codigo=archivo.readInt();
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
                String  numFactura = archivo.readUTF();
                
                if (numFactura.equals(numero)) {
                    archivo.seek(salto-20);
                    Detalle detalle = new Detalle();
                     detalle.setCodigo(archivo.readInt());
                    detalle.setCantidad(archivo.readInt());
                    detalle.setTotal(archivo.readDouble());
                    Producto producto = productoDao.read(archivo.readInt());
                    detalle.setProducto(producto);
                    Factura factura = new Factura();
                    factura.setNumero(numero);
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
    public Double obtenerSubtotal(String numero) {
        
        double subtotal=0;
        int salto = 20;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String numeroA=archivo.readUTF().trim();
                if (numeroA.equals(numero)) {
                    archivo.seek(salto-12);
                   subtotal+=archivo.readDouble();
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:DetalleDao");
        }
        return subtotal;
    }
       
    }

