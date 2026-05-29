
package modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "auto_nuevo")
@NamedQueries({
    @NamedQuery(name = "Auto_1.findAll",        query = "SELECT a FROM Auto_1 a"),
    @NamedQuery(name = "Auto_1.findByIdAuto",   query = "SELECT a FROM Auto_1 a WHERE a.idAuto = :idAuto"),
    @NamedQuery(name = "Auto_1.findByPlaca",    query = "SELECT a FROM Auto_1 a WHERE a.placa = :placa"),
    @NamedQuery(name = "Auto_1.findByMarca",    query = "SELECT a FROM Auto_1 a WHERE a.marca = :marca"),
    @NamedQuery(name = "Auto_1.findByCondicion",query = "SELECT a FROM Auto_1 a WHERE a.condicion = :condicion")
})
public class Auto_1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Long idAuto;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private int modelo;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "condicion", nullable = false)
    private String condicion;  // "Nuevo" o "Usado"

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "precio", nullable = false)
    private double precio;

    public Auto_1() {}

    public Auto_1(String marca, int modelo, String color, String condicion, String placa, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.condicion = condicion;
        this.placa = placa;
        this.precio = precio;
    }

    public Long getIdAuto() { return idAuto; }
    public void setIdAuto(Long idAuto) { this.idAuto = idAuto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getModelo() { return modelo; }
    public void setModelo(int modelo) { this.modelo = modelo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getCondicion() { return condicion; }
    public void setCondicion(String condicion) { this.condicion = condicion; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}