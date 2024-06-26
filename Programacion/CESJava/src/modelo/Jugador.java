package modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Representa un jugador de un equipo.
 */

public class Jugador {
    private int codJugador;
    private String nombreJugador;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String nickname;
    private String rol;
    private int sueldo;
    private Equipo codEquipo;

    /**
     * Constructor para crear una instancia de Jugador con todos los atributos.
     *
     * @param codJugador       el código del jugador
     * @param nombreJugador    el nombre del jugador
     * @param nacionalidad     la nacionalidad del jugador
     * @param fechaNacimiento  la fecha de nacimiento del jugador
     * @param nickname         el apodo del jugador
     * @param rol              el rol del jugador
     * @param sueldo           el sueldo del jugador
     * @param codEquipo        el equipo al que pertenece el jugador
     */

    public Jugador(int codJugador, String nombreJugador, String nacionalidad, LocalDate fechaNacimiento, String nickname, String rol, int sueldo, Equipo codEquipo) {
        this.codJugador = codJugador;
        this.nombreJugador = nombreJugador;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
        this.codEquipo = codEquipo;
    }

    public Jugador() {

    }

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipo codEquipo) {
        this.codEquipo = codEquipo;
    }
}
