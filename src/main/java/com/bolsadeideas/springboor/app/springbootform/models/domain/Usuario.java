package com.bolsadeideas.springboor.app.springbootform.models.domain;

import com.bolsadeideas.springboor.app.springbootform.validation.IdentificadorRegex;
import com.bolsadeideas.springboor.app.springbootform.validation.Requerido;
import jakarta.validation.constraints.*;
// import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Usuario {

    // esto hace que validemos un campo en un formato especifico
    // en este caso (12.123.123-A) va a tener un formato asi
    // @Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String identificador;

    @Requerido
    @Size(min = 3, max = 8)
    private String username;

    @Requerido
    private String password;

    @Requerido
    @Email
    private String email;

    // esta anotacion, valída solamente String
    // @NotEmpty
    private String nombre;

    @Requerido
    private String apellido;

    @NotNull // se utiliza en enteros o datos numéricos con clases como Integer, no int
    @Min(5)
    @Max(5000 )
    private Integer cuenta;

    @NotNull
    @Past // valida que la fecha sea pasada
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    // lambien sirve para validar si un arreglo tiene o no elementos
    @NotEmpty
    private List<Role> roles;

    private Boolean habilitar;

    @NotEmpty
    private String genero;

    private String valorSecreto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {this.habilitar = habilitar;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    public String getValorSecreto() {
        return valorSecreto;
    }

    public void setValorSecreto(String valorSecreto) {
        this.valorSecreto = valorSecreto;
    }
}
