/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Cliente;
import control.EmpleadoDetalle;
import control.OrdenCliente;
import control.Persona;
import control.ProductosOrden;
import control.SucursalDetalle;
import control.menuSucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Conexion {

    //Creamos nuestros objetos para la comunicacion y ejecucion de codigo SQL
    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    //Constructor    
    public Conexion() {
        stmt = null;
        con = null;
        rs = null;
    }

    /*
     * Metodo que nos permite abrir la conexion con una base de datos 
     * especificada en el parametro de entrada del metodo que ha sido
     * invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   nombrebase - nombre de la base de datos a la cual nos 
     *          conectaremos
     */
    public void conectar()
            throws Exception {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;"
                    + "database=pastorenchilado;"
                    + "user=sa;"
                    + "password=n0m3l0";
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " conectar =(");
        }
    }

    /*
     * Metodo que nos permite cerrar la conexion con una base de datos 
     * el metodo debe ser invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   sin parametros     
     */
    public void desconectar()
            throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " desconectar =(");
        }
    }

    public ArrayList getPersonas() throws Exception {
        ArrayList personas = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdPersona, sApp, sNombre, dFechaNacimiento FROM persona;");
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setApp(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setFecha_nac(rs.getString(4));
                personas.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return personas;
    }

    public ArrayList getOrdenes() throws Exception {
        ArrayList personas = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT sApp + ' ' + sNombre FROM persona;");
            while (rs.next()) {
                Persona p = new Persona();
                p.setNombre(rs.getString(1));
                personas.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return personas;
    }

    public int setEstado(String estado) throws SQLException {
        int b = 0;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO CEstado(sestado) VALUES ('" + estado + "');");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }

    public Persona setPersona(String monedero) {
        Persona p = new Persona();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdCliente, sNombre, sApp FROM "
                    + "Cliente INNER JOIN Persona ON Cliente.nIdPersona = "
                    + "Persona.nIdPersona WHERE sMonedero = '" + monedero
                    + "';");
            if (!rs.next()) {
                return null;
            }
            p.setId(rs.getInt(1));
            p.setApp(rs.getString(3));
            p.setNombre(rs.getString(2));
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return p;
    }

    public ArrayList<OrdenCliente> getOrdenCliente(int idCliente) {
        ArrayList<OrdenCliente> aoc = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DISTINCT Orden.nIdOrden, mTotal, "
                    + "bDomicilio FROM DetalleOrden INNER JOIN Orden ON "
                    + "Orden.nIdOrden = DetalleOrden.nIdOrden WHERE "
                    + "DetalleOrden.nIdCliente = " + idCliente + ";");
            while (rs.next()) {
                OrdenCliente oc = new OrdenCliente();
                oc.setIdOrden(rs.getInt(1));
                oc.setTotal(rs.getFloat(2));
                oc.setADomicilio(rs.getString(3));
                aoc.add(oc);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return aoc;
    }

    public ArrayList<ProductosOrden> productoOrden(int idOrden) {
        ArrayList<ProductosOrden> apo = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT sProducto, mPrecio, nCantidad FROM "
                    + "DetalleOrden INNER JOIN Sucursal_Producto ON "
                    + "DetalleOrden.nIdSucursalProducto = "
                    + "Sucursal_Producto.nIdSucursalProducto INNER JOIN Producto "
                    + "ON Producto.nIdProducto = Sucursal_Producto.nIdProducto "
                    + "WHERE DetalleOrden.nIdOrden = " + idOrden + ";");

            while (rs.next()) {
                ProductosOrden po = new ProductosOrden();
                po.setProducto(rs.getString(1));
                po.setPrecio(rs.getFloat(2));
                po.setCantidad(rs.getInt(3));
                apo.add(po);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return apo;
    }

    public ArrayList proveedorSucursal(String nombreSucursal) {
        ArrayList<String> proveedores = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdSucursal FROM Sucursal WHERE "
                    + "sNombre LIKE '" + nombreSucursal + "';");
            if (!rs.next()) {
                return null;
            }
            int nIdSucursal = rs.getInt(1);
            rs = stmt.executeQuery("SELECT sProveedor FROM Proveedor_Ingrediente "
                    + "INNER JOIN Proveedor ON Proveedor_Ingrediente.nIdProveedor "
                    + "= Proveedor.nIdProveedor WHERE "
                    + "Proveedor_Ingrediente.nIdSucursal = " + nIdSucursal + ";");
            while (rs.next()) {
                proveedores.add(rs.getString(1));
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return proveedores;
    }

    public ArrayList sucursalMenu(String nombreSucursal) {
        ArrayList<menuSucursal> ams = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdSucursal FROM Sucursal WHERE "
                    + "sNombre LIKE '" + nombreSucursal + "';");
            if (!rs.next()) {
                return null;
            }
            int nIdSucursal = rs.getInt(1);
            rs = stmt.executeQuery("SELECT sProducto, mPrecio FROM Sucursal_Producto "
                    + "INNER JOIN Producto ON Sucursal_Producto.nIdProducto = "
                    + "Producto.nIdProducto WHERE Sucursal_Producto.nIdSucursal "
                    + "= " + nIdSucursal + ";");

            while (rs.next()) {
                menuSucursal ms = new menuSucursal();
                ms.setProducto(rs.getString(1));
                ms.setPrecio(rs.getFloat(2));
                ams.add(ms);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return ams;

    }

    public boolean updateProductoSucursal(String sucursal, String producto,
            float precio) throws SQLException {
        boolean b = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdSucursal FROM Sucursal WHERE "
                    + "sNombre LIKE '" + sucursal + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdSucursal = rs.getInt(1);
            rs = stmt.executeQuery("SELECT nIdProducto FROM Producto WHERE "
                    + "sProducto LIKE '" + producto + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdProducto = rs.getInt(1);
            stmt.executeUpdate("UPDATE Sucursal_Producto SET mPrecio = "
                    + precio + ",dFechaActualizacion = GETDATE() WHERE "
                    + "nIdSucursal = " + nIdSucursal + " AND nIdProducto = "
                    + nIdProducto + ";");
            b = true;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return b;
    }

    public boolean setOrden(String cliente, String empleado, String sucursal,
            String producto1, int cantidad1, String producto2,
            int cantidad2, String producto3, int cantidad3, String fecha,
            int bDomicilio) {

        boolean b = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdSucursal FROM Sucursal WHERE "
                    + "sNombre LIKE '" + sucursal + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdSucursal = rs.getInt(1);

            rs = stmt.executeQuery("SELECT nIdProducto FROM Producto WHERE "
                    + "sProducto LIKE '" + producto1 + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdProducto = rs.getInt(1);
            rs = stmt.executeQuery("SELECT nIdSucursalProducto, mPrecio "
                    + "FROM Sucursal_Producto WHERE nIdProducto = "
                    + nIdProducto + " AND nIdSucursal = " + nIdSucursal + ";");
            if (!rs.next()) {
                return false;
            }
            int nIdSucursalProducto1 = rs.getInt(1);
            float subTotal1 = rs.getFloat(2) * cantidad1;

            rs = stmt.executeQuery("SELECT nIdProducto FROM Producto WHERE "
                    + "sProducto LIKE '" + producto2 + "';");
            if (!rs.next()) {
                return false;
            }
            nIdProducto = rs.getInt(1);
            rs = stmt.executeQuery("SELECT nIdSucursalProducto, mPrecio "
                    + "FROM Sucursal_Producto WHERE nIdProducto = "
                    + nIdProducto + " AND nIdSucursal = " + nIdSucursal + ";");
            if (!rs.next()) {
                return false;
            }
            int nIdSucursalProducto2 = rs.getInt(1);
            float subTotal2 = rs.getFloat(2) * cantidad2;

            rs = stmt.executeQuery("SELECT nIdProducto FROM Producto WHERE "
                    + "sProducto LIKE '" + producto3 + "';");
            if (!rs.next()) {
                return false;
            }
            nIdProducto = rs.getInt(1);
            rs = stmt.executeQuery("SELECT nIdSucursalProducto, mPrecio "
                    + "FROM Sucursal_Producto WHERE nIdProducto = "
                    + nIdProducto + " AND nIdSucursal = " + nIdSucursal + ";");
            if (!rs.next()) {
                return false;
            }
            int nIdSucursalProducto3 = rs.getInt(1);
            float subTotal3 = rs.getFloat(2) * cantidad3;
            float total = subTotal1 + subTotal2 + subTotal3;

            rs = stmt.executeQuery("SELECT nIdEmpleado FROM Empleado INNER JOIN "
                    + "CTipo_Empleado ON Empleado.nIdTipoempleado = "
                    + "CTipo_Empleado.nIdTipoEmpleado WHERE sTipoEmpleado = "
                    + "'Mesero' AND sRFC LIKE '" + empleado + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdEmpleado = rs.getInt(1);

            rs = stmt.executeQuery("SELECT nIdDia FROM CDia WHERE sDia LIKE "
                    + "DATENAME(dw,'" + fecha + "');");
            if (!rs.next()) {
                return false;
            }
            int nIdDia = rs.getInt(1);

            rs = stmt.executeQuery("SELECT nIdCliente FROM Cliente WHERE "
                    + "sMonedero LIKE '" + cliente + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdCliente = rs.getInt(1);

            stmt.executeUpdate("INSERT INTO Orden (mTotal, dFecha, "
                    + "nIdEmpleado, nIdDia) VALUES (" + total + ",'" + fecha
                    + "'," + nIdEmpleado + "," + nIdDia + ");");

            stmt.executeUpdate("INSERT INTO DetalleOrden (nCantidad, bDomicilio, "
                    + "nIdSucursalProducto, nIdOrden, nIdCliente) VALUES ("
                    + cantidad1 + "," + bDomicilio + "," + nIdSucursalProducto1
                    + ", (SELECT TOP 1 nIdOrden FROM Orden ORDER BY nIdOrden "
                    + "DESC)," + nIdCliente + ");");

            stmt.executeUpdate("INSERT INTO DetalleOrden (nCantidad, bDomicilio, "
                    + "nIdSucursalProducto, nIdOrden, nIdCliente) VALUES ("
                    + cantidad2 + "," + bDomicilio + "," + nIdSucursalProducto2
                    + ", (SELECT TOP 1 nIdOrden FROM Orden ORDER BY nIdOrden "
                    + "DESC)," + nIdCliente + ");");

            stmt.executeUpdate("INSERT INTO DetalleOrden (nCantidad, bDomicilio, "
                    + "nIdSucursalProducto, nIdOrden, nIdCliente) VALUES ("
                    + cantidad3 + "," + bDomicilio + "," + nIdSucursalProducto3
                    + ", (SELECT TOP 1 nIdOrden FROM Orden ORDER BY nIdOrden "
                    + "DESC)," + nIdCliente + ");");

            b = true;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return b;
    }

    public boolean deleteTelefono(String telefono) {
        boolean b = false;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdTelefono FROM Telefono WHERE "
                    + "sTelefono LIKE '" + telefono + "';");
            if (!rs.next()) {
                return false;
            }
            int nIdTelefono = rs.getInt(1);

            stmt.executeUpdate("UPDATE Telefono SET bActivo = 0 WHERE "
                    + "nIdTelefono = " + nIdTelefono + ";");
            stmt.executeUpdate("UPDATE Persona_Telefono SET bActivo = 0 WHERE "
                    + "nIdTelefono = " + nIdTelefono + ";");
            stmt.executeUpdate("UPDATE Telefono_Proveedor SET bActivo = 0 WHERE "
                    + "nIdTelefono = " + nIdTelefono + ";");
            stmt.executeUpdate("UPDATE Proveedor_Telefono SET bActivo = 0 WHERE "
                    + "nIdTelefono = " + nIdTelefono + ";");
            stmt.executeUpdate("UPDATE Sucursal SET bActivo = 0 WHERE "
                    + "nIdTelefono = " + nIdTelefono + ";");
            b = true;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return b;
    }

    public ArrayList getClientes() throws Exception {
        ArrayList clientes = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdCliente, sMonedero, mSaldo, dFechaRegistro,nIdPersona FROM Cliente;");
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setId(rs.getInt(1));
                p.setMonedero(rs.getString(2));
                p.setSaldo(rs.getDouble(3));
                p.setFecha_reg(rs.getString(4));
                p.setIdPersona(rs.getInt(5));
                clientes.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return clientes;
    }

    public ArrayList todosLosEmpleados() throws SQLException {
        String s = "SELECT Persona.sNombre AS nombre, sApp, sApm, dFechaNacimiento, sCorreo, dFechaContratacion, sRFC, Empleado.bActivo AS Activo, Sucursal.sNombre AS Sucursal, sTipoEmpleado "
                + "FROM Empleado JOIN Persona ON Empleado.nIdPersona=Persona.nIdPersona "
                + "JOIN CTipo_Empleado ON Empleado.nIdTipoempleado=CTipo_Empleado.nIdTipoEmpleado "
                + "JOIN Sucursal ON Empleado.nIdSucursal=Sucursal.nIdSucursal "
                + "ORDER BY sTipoEmpleado;";
        ArrayList listaEmpleados = new ArrayList();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(s);
            while (rs.next()) {
                EmpleadoDetalle e = new EmpleadoDetalle();
                e.setNombre(rs.getString(1));
                e.setaP(rs.getString(2));
                e.setaM(rs.getString(3));
                e.setfNacimiento(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setfContratacion(rs.getString(6));
                e.setRFC(rs.getString(7));
                e.setActivo(rs.getInt(8));
                e.setSucursal(rs.getString(9));
                e.setTipoEmpleado(rs.getString(10));
                listaEmpleados.add(e);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return listaEmpleados;
    }

    public ArrayList sucursalesDetalle() {
        String s = "SELECT nIdSucursal,sNombre,bAdomicilio, Sucursal.bACtivo, "
                + "sCalle, sColonia, sCp, sObservaciones, sMunicipio, sEstado, "
                + "sTelefono, sTipoSucursal FROM Sucursal JOIN Direccion ON "
                + "Sucursal.nIdDireccion = Direccion.nIdDireccion JOIN Telefono "
                + "ON Sucursal.nIdTelefono = Telefono.nIdTelefono JOIN "
                + "CTipo_Sucursal ON Sucursal.nIdTipoSucursal = "
                + "CTipo_Sucursal.nIdTipoSucursal JOIN CMunicipio ON "
                + "Direccion.nIdMunicipio = CMunicipio.nIdMunicipio JOIN CEstado "
                + "ON CMunicipio.nIdEstado = CEstado.nIdEstado ORDER BY sEstado;";
        ArrayList listaSucursales = new ArrayList();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(s);
            while (rs.next()) {
                SucursalDetalle suc = new SucursalDetalle();
                suc.setIdSucursal(rs.getInt(1));
                suc.setNombre(rs.getString(2));
                suc.setaDomicilio(rs.getInt(3));
                suc.setActivo(rs.getInt(4));
                suc.setCalle(rs.getString(5));
                suc.setColonia(rs.getString(6));
                suc.setcP(rs.getString(7));
                suc.setObservaciones(rs.getString(8));
                suc.setMunicipio(rs.getString(9));
                suc.setEstado(rs.getString(10));
                suc.setTelefono(rs.getString(11));
                suc.setTipoSucursal(rs.getString(12));
                listaSucursales.add(suc);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return listaSucursales;
    }

    public int setCliente(String monedero, double saldo, String registro, int idPersona) throws SQLException {
        int b = 0;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Cliente(sMonedero,mSaldo,dFechaRegistro,bActivo,nIdPersona) VALUES ('" + monedero + "'," + saldo + "," + "'" + registro + "'," + "1" + "," + idPersona + ");");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }

    /**
     *
     * @param app
     * @param apm
     * @param nombre
     * @param fechaNacimiento
     * @param correo
     * @return
     * @throws SQLException
     */
    public int setPersona(String app, String apm, String nombre, String fechaNacimiento, String correo) throws SQLException {
        int b = 0;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Persona(sApp,sApm,sNombre,dFechaNacimiento,sCorreo) VALUES ('" + app + "'," + "'" + apm + "'," + "'" + nombre + "'," + "'" + fechaNacimiento + "'," + "'" + correo + "');");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }

    public int getUltimoIdPersona() {
        int ultimo = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT MAX(nIdPersona) FROM persona;");
            if (!rs.next()) {
                return 0;
            }
            ultimo = rs.getInt(1);

            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getUltimoIdPersona");
        }
        return ultimo;
    }

    public boolean registrarProveedor(String nombre, String rfc, String sucursal,
            String fecha, double costo, String cantidad, String calle,
            String colonia, String cp, String obs, String municipio, String estado) {
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO CEstado (sEstado) VALUES ('" + estado + "');");
            rs = stmt.executeQuery("SELECT nIdEstado FROM CEstado WHERE sEstado = '" + estado + "';");
            rs.next();
            int idEstado = rs.getInt(1);
            stmt.executeUpdate("INSERT INTO CMunicipio (sMunicipio, nIdEstado) VALUES ('" + municipio + "', " + idEstado + ");");
            rs = stmt.executeQuery("SELECT nIdMunicipio FROM CMunicipio WHERE sMunicipio = '" + municipio + "';");
            rs.next();
            int idMunicipio = rs.getInt(1);
            stmt.executeUpdate("INSERT INTO Direccion (sCalle, sColonia, sCp, sObservaciones, bActivo, nIdMunicipio) VALUES ('" + calle + "', '" + colonia + "', ' " + cp + "', ' " + obs + "', " + 1 + ", " + idMunicipio + ");");
            rs = stmt.executeQuery("SELECT TOP 1 nIdDireccion FROM Direccion ORDER BY nIdDireccion DESC;");
            rs.next();
            int idDireccion = rs.getInt(1);
            rs = stmt.executeQuery("SELECT nIdSucursal FROM Sucursal WHERE sNombre = '" + sucursal + "';");
            rs.next();
            int idSucursal = rs.getInt(1);
            stmt.executeUpdate("INSERT INTO Proveedor (sProveedor, sRFC, bActivo, nIdDireccion) VALUES ('" + nombre + "', '" + rfc + "', " + 1 + ", " + idDireccion + ");");
            rs = stmt.executeQuery("SELECT nIdProveedor FROM Proveedor WHERE sProveedor = '" + nombre + "' AND sRFC = '" + rfc + "' AND nIdDireccion = " + idDireccion + ";");
            rs.next();
            int idProveedor = rs.getInt(1);
            stmt.executeUpdate("INSERT INTO Proveedor_Ingrediente (dFecha, mCosto, sCantidad, nIdProveedor, nIdIngrediente, nIdSucursal) VALUES ('" + fecha + "', " + costo + ", '" + cantidad + "', " + idProveedor + ", " + 2 + ", " + idSucursal + ");");
            b = true;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }

}
