package mx.uv.model;

public class Sucursal {
    private Integer idProvedor;
    private String nombreEmpresa;
    private String nombreRepresetante;
    private String categoria;

    public Sucursal(Integer idProvedor, String nombreEmpresa, String nombreRepresetante, String categoria) {
        this.idProvedor = idProvedor;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreRepresetante = nombreRepresetante;
        this.categoria = categoria;
    }
    
    public Sucursal() {
    }

    public Integer getIdProvedor() {
        return idProvedor;
    }
    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getNombreRepresetante() {
        return nombreRepresetante;
    }
    public void setNombreRepresetante(String nombreRepresetante) {
        this.nombreRepresetante = nombreRepresetante;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    } 

    
}
