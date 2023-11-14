
package Entidades;


public class Comida {
  private int idComida,cantCalorias;
  private String nombre, detalle;
  private boolean estado;

    public Comida() {
    }

    public Comida(int idComida, int cantCalorias, String nombre, String detalle,boolean estado) {
        this.idComida = idComida;
        this.cantCalorias = cantCalorias;
        this.nombre = nombre;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Comida(int cantCalorias, String nombre, String detalle) {
        this.cantCalorias = cantCalorias;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", cantCalorias=" + cantCalorias + ", nombre=" + nombre + ", detalle=" + detalle + ", estado=" + estado + '}';
    }

}
