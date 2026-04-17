package Modelo;

import Controlador.clsExamen;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.*;

public class ExamenDAO {

    private static final String SQL_SELECT =
        "SELECT * FROM vendedores";

    private static final String SQL_INSERT =
        "INSERT INTO vendedores VALUES(?,?,?,?,?,?)";

    private static final String SQL_UPDATE =
        "UPDATE vendedores SET nombre_vendedor=?, direccion_vendedor=?, telefono_vendedor=?, nit_vendedor=?, estatus_vendedor=? WHERE codigo_vendedor=?";

    private static final String SQL_DELETE =
        "DELETE FROM vendedores WHERE codigo_vendedor=?";

    private static final String SQL_SELECT_ID =
        "SELECT * FROM vendedores WHERE codigo_vendedor=?";

    public List<clsExamen> listar() {
        List<clsExamen> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clsExamen e = new clsExamen();
                e.setCodigo_vendedor(rs.getString("codigo_vendedor"));
                e.setNombre_vendedor(rs.getString("nombre_vendedor"));
                e.setDireccion_vendedor(rs.getString("direccion_vendedor"));
                e.setTelefono_vendedor(rs.getString("telefono_vendedor"));
                e.setNit_vendedor(rs.getString("nit_vendedor"));
                e.setEstatus_vendedor(rs.getString("estatus_vendedor"));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public int insertar(clsExamen e) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, e.getCodigo_vendedor());
            stmt.setString(2, e.getNombre_vendedor());
            stmt.setString(3, e.getDireccion_vendedor());
            stmt.setString(4, e.getTelefono_vendedor());
            stmt.setString(5, e.getNit_vendedor());
            stmt.setString(6, e.getEstatus_vendedor());

            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int actualizar(clsExamen e) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, e.getNombre_vendedor());
            stmt.setString(2, e.getDireccion_vendedor());
            stmt.setString(3, e.getTelefono_vendedor());
            stmt.setString(4, e.getNit_vendedor());
            stmt.setString(5, e.getEstatus_vendedor());
            stmt.setString(6, e.getCodigo_vendedor());

            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int eliminar(String codigo) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setString(1, codigo);
            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public clsExamen buscar(String codigo) {
        clsExamen e = null;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID)) {

            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                e = new clsExamen();
                e.setCodigo_vendedor(rs.getString("codigo_vendedor"));
                e.setNombre_vendedor(rs.getString("nombre_vendedor"));
                e.setDireccion_vendedor(rs.getString("direccion_vendedor"));
                e.setTelefono_vendedor(rs.getString("telefono_vendedor"));
                e.setNit_vendedor(rs.getString("nit_vendedor"));
                e.setEstatus_vendedor(rs.getString("estatus_vendedor"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
}