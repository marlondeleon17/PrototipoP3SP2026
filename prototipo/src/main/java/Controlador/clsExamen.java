package Controlador;

public class clsExamen {
    private String codigo_vendedor;
    private String nombre_vendedor;
    private String direccion_vendedor;
    private String telefono_vendedor;
    private String nit_vendedor;
    private String estatus_vendedor;

    public clsExamen() {}

    public clsExamen(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public clsExamen(String codigo_vendedor, String nombre_vendedor, String direccion_vendedor,
                     String telefono_vendedor, String nit_vendedor, String estatus_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.direccion_vendedor = direccion_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.nit_vendedor = nit_vendedor;
        this.estatus_vendedor = estatus_vendedor;
    }

    public String getCodigo_vendedor() { return codigo_vendedor; }
    public void setCodigo_vendedor(String codigo_vendedor) { this.codigo_vendedor = codigo_vendedor; }

    public String getNombre_vendedor() { return nombre_vendedor; }
    public void setNombre_vendedor(String nombre_vendedor) { this.nombre_vendedor = nombre_vendedor; }

    public String getDireccion_vendedor() { return direccion_vendedor; }
    public void setDireccion_vendedor(String direccion_vendedor) { this.direccion_vendedor = direccion_vendedor; }

    public String getTelefono_vendedor() { return telefono_vendedor; }
    public void setTelefono_vendedor(String telefono_vendedor) { this.telefono_vendedor = telefono_vendedor; }

    public String getNit_vendedor() { return nit_vendedor; }
    public void setNit_vendedor(String nit_vendedor) { this.nit_vendedor = nit_vendedor; }

    public String getEstatus_vendedor() { return estatus_vendedor; }
    public void setEstatus_vendedor(String estatus_vendedor) { this.estatus_vendedor = estatus_vendedor; }
}