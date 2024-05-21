package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ControladorPrincipal gestiona la interacción entre la vista y la base de datos a través de ControladorVista y ControladorBaseDeDatos.
 */

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;

    /**
     * Constructor de ControladorPrincipal.
     */

    public ControladorPrincipal() {
        cv = new ControladorVista(this);
        cbd = new ControladorBaseDeDatos(this);

    }

    /**
     * Método para realizar el login de un usuario.
     *
     * @param usu El usuario que intenta iniciar sesión.
     * @return El resultado del login.
     * @throws SQLException Si hay un error en la base de datos.
     */

    public String login(Usuario usu) throws SQLException {
        return cbd.login(usu);
    }

    /**
     * Método para dar de alta un equipo.
     *
     * @param eq El equipo a dar de alta.
     */

    public void altaEquipo(Equipo eq) {
        cbd.altaEquipo(eq);
    }

    /**
     * Método para dar de baja un equipo.
     *
     * @param eq El equipo a dar de baja.
     */

    public void bajaEquipo(Equipo eq) {
        cbd.bajaEquipo(eq);
    }

    /**
     * Método para modificar un equipo.
     *
     * @param eq    El equipo a modificar.
     * @param fecha La nueva fecha del equipo.
     */

    public void modiEquipo(Equipo eq, String fecha) {
        cbd.modiEquipo(eq, fecha);
    }

    /**
     * Método para consultar la información de un equipo.
     *
     * @param nombreEq El nombre del equipo a consultar.
     * @return La información del equipo.
     */

    public String consultaEquipo(String nombreEq) {
        return cbd.consultaEquipo(nombreEq).toString();
    }

    /**
     * Método para obtener la última jornada de una competición.
     *
     * @param com La competición de la cual obtener la última jornada.
     * @return La lista de enfrentamientos de la última jornada.
     */

    public ArrayList ultimaJornada(Competicion com) {
        return cbd.ultimaJornada(com);
    }

    /**
     * Método para obtener todas las jornadas de una competición.
     *
     * @param com La competición de la cual obtener todas las jornadas.
     * @return La lista de todas las jornadas.
     */

    public ArrayList todasJornadas(Competicion com) {
        return cbd.todasJornadas(com);
    }

    /**
     * Método para buscar un equipo por su nombre.
     *
     * @param nombreEq El nombre del equipo a buscar.
     * @return El equipo encontrado.
     */

    public Equipo buscarEquipo(String nombreEq) {
        return cbd.buscarEquipo(nombreEq);
    }

    /**
     * Método para dar de alta a un miembro del staff.
     *
     * @param staff El miembro del staff a dar de alta.
     */

    public void altaStaff(Staff staff) {
        cbd.altaStaff(staff);
    }

    /**
     * Método para dar de baja a un miembro del staff.
     *
     * @param staff El miembro del staff a dar de baja.
     */

    public void bajaStaff(Staff staff) {
        cbd.bajaStaff(staff);
    }

    /**
     * Método para modificar un miembro del staff.
     *
     * @param staff    El miembro del staff a modificar.
     * @param cargo    El nuevo cargo del miembro del staff.
     * @param sueldo   El nuevo sueldo del miembro del staff.
     * @param cod_equipo El equipo asociado al miembro del staff.
     */

    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        cbd.modiStaff(staff, cargo, sueldo, cod_equipo);
    }

    /**
     * Método para consultar la información de un miembro del staff.
     *
     * @param nombreSt El nombre del miembro del staff a consultar.
     * @return La información del miembro del staff.
     */

    public String consultaStaff(String nombreSt) {
        return cbd.consultaStaff(nombreSt).toString();
    }

    /**
     * Método para dar de alta a un jugador.
     *
     * @param ju El jugador a dar de alta.
     */

    public void altaJugador(Jugador ju) {
        cbd.altaJugador(ju);
    }

    /**
     * Método para dar de baja a un jugador.
     *
     * @param ju El jugador a dar de baja.
     */

    public void bajaJugador(Jugador ju) {
        cbd.bajaJugador(ju);
    }

    /**
     * Método para modificar un jugador.
     *
     * @param ju El jugador a modificar.
     */

    public void modiJugador(Jugador ju) {
        cbd.modiJugador(ju);
    }

    /**
     * Método para consultar la información de un jugador.
     *
     * @param nombre El nombre del jugador a consultar.
     * @return La información del jugador.
     */

    public String consultaJugador(String nombre) {
        return cbd.consultaJugador(nombre).toString();
    }

    /**
     * Método para dar de alta a un juego.
     *
     * @param juego El juego a dar de alta.
     */

    public void altaJuego(Juego juego) {
        cbd.altaJuego(juego);
    }

    /**
     * Método para dar de baja a un juego.
     *
     * @param juego El juego a dar de baja.
     */

    public void bajaJuego(Juego juego) {
        cbd.bajaJuego(juego);
    }

    /**
     * Método para modificar un juego.
     *
     * @param juego El juego a modificar.
     */

    public void modiJuego(Juego juego) {
        cbd.modiJuego(juego);
    }

    /**
     * Método para consultar la información de un juego.
     *
     * @param nombreJu El nombre del juego a consultar.
     * @return La información del juego.
     */

    public Object consultaJuego(String nombreJu) {
        return cbd.consultaJuego(nombreJu).toString();
    }

    /**
     * Método para buscar un juego por su nombre.
     *
     * @param nombreJu El nombre del juego a buscar.
     * @return El juego encontrado.
     */

    public Juego buscarJuego(String nombreJu) {
        return cbd.buscarJuego(nombreJu);
    }

    /**
     * Método para dar de alta a un patrocinador.
     *
     * @param patr El patrocinador a dar de alta.
     */

    public void altaPatrocinador(Patrocinador patr) {
        cbd.altaPatrocinador(patr);
    }

    /**
     * Método para dar de baja a un patrocinador.
     *
     * @param patr El patrocinador a dar de baja.
     */

    public void bajaPatrocinador(Patrocinador patr) {
        cbd.bajaPatrocinador(patr);
    }

    /**
     * Método para dar de alta a una competición.
     *
     * @param compe La competición a dar de alta.
     */

    public void altaCompeticion(Competicion compe) {
        cbd.altaCompeticion(compe);
    }

    /**
     * Método para dar de baja a una competición.
     *
     * @param compe La competición a dar de baja.
     */

    public void bajaCompeticion(Competicion compe) {
        cbd.bajaCompeticion(compe);
    }


    /**
     * Método para modificar una competición.
     *
     * @param compe La competición a modificar.
     */

    public void modiCompeticion(Competicion compe) {
        cbd.modiCompeticion(compe);
    }

    /**
     * Método para consultar la información de una competición.
     *
     * @param nombreCo El nombre de la competición a consultar.
     * @return La información de la competición.
     */

    public String consultaCompeticion(String nombreCo) {
        return cbd.consultaCompeticion(nombreCo).toString();
    }

    /**
     * Método para obtener la clasificación de una competición.
     *
     * @param com La competición de la cual obtener la clasificación.
     * @return La lista de clasificación.
     */

    public ArrayList clasificacion(Competicion com) {
        return cbd.calsificacion(com);
    }

    /**
     * Método para asociar un equipo a una competición.
     *
     * @param nombreEquipo       El nombre del equipo a asociar.
     * @param nombreCompeticion  El nombre de la competición.
     */

    public void asociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cbd.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    /**
     * Método para desasociar un equipo de una competición.
     *
     * @param nombreEquipo       El nombre del equipo a desasociar.
     * @param nombreCompeticion  El nombre de la competición.
     */

    public void desasociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cbd.desasociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    /**
     * Método para dar de alta a un usuario.
     *
     * @param usu El usuario a dar de alta.
     * @throws Exception Si hay un error en la base de datos.
     */

    public void altaUsu(Usuario usu) throws Exception {
        cbd.altaUsu(usu);
    }


    /**
     * Método para comprobar un usuario.
     *
     * @param usu El usuario a comprobar.
     * @return El usuario comprobado.
     * @throws Exception Si hay un error en la base de datos.
     */

    public Usuario comprobarUsu(Usuario usu) throws Exception {
        return cbd.comprobarUsu(usu);
    }

    /**
     * Método para obtener el nombre de un juego por su código.
     *
     * @param cod El código del juego.
     * @return El juego encontrado.
     */

    public Juego getNombreJuegoPorCodigo(int cod) {
        return cbd.getNombreJuegoPorCodigo(cod);
    }

    /**
     * Método para obtener el nombre de un equipo por su código.
     *
     * @param codEquipo El código del equipo.
     * @return El equipo encontrado.
     */

    public Equipo getNombreEquipoPorCodigo(int codEquipo) {
        return cbd.getNombreEquipoPorCodigo(codEquipo);
    }

    /**
     * Método para obtener la clasificación de equipos.
     *
     * @return La lista de clasificación de equipos.
     * @throws Exception Si hay un error en la base de datos.
     */

    public ArrayList clasiEquipos() throws Exception {
        return cbd.clasiEquipo();
    }

    /**
     * Método para obtener la clasificación de una competición para un administrador.
     *
     * @param com La competición de la cual obtener la clasificación.
     * @return La lista de clasificación.
     */

    public ArrayList clasificacionAdmin(Competicion com) {
        return cbd.calsificacionAdmin(com);
    }

    /**
     * Método para asociar un patrocinador a un equipo.
     *
     * @param nombreEquipo        El nombre del equipo.
     * @param nombrePatrocinador  El nombre del patrocinador.
     */

    public void asociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cbd.asociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    /**
     * Método para desasociar un patrocinador de un equipo.
     *
     * @param nombreEquipo        El nombre del equipo.
     * @param nombrePatrocinador  El nombre del patrocinador.
     */

    public void desasociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cbd.desasociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    /**
     * Método para obtener los equipos asociados a un patrocinador.
     *
     * @param nombrePatrocinador El nombre del patrocinador.
     * @return La lista de equipos asociados.
     */

    public List<String> getEquiposPorPatrocinador(String nombrePatrocinador) {
        return cbd.getEquiposPorPatrocinador(nombrePatrocinador);
    }

    /**
     * Método para obtener los patrocinadores asociados a un equipo.
     *
     * @param nombreEquipo El nombre del equipo.
     * @return La lista de patrocinadores asociados.
     */

    public List<String> getPatrocinadoresPorEquipo(String nombreEquipo) {
        return cbd.getPatrocinadoresPorEquipo(nombreEquipo);
    }

    /**
     * Método para obtener los equipos asociados a una competición.
     *
     * @param com La competición.
     * @return La lista de equipos asociados.
     */

    public ArrayList<Equipo> getEquiposPorCompeticion(Competicion com) {
        return cbd.getEquiposPorCompeticion(com);
    }

    /**
     * Método para cerrar la inscripción de una competición.
     *
     * @param nombreCompeticion El nombre de la competición.
     */

    public void cerrarIncripcionCompeticion(String nombreCompeticion) {
        cbd.cerrarIncripcionCompeticion(nombreCompeticion);
    }

    /**
     * Método para obtener el código de una competición por su nombre.
     *
     * @param nombre El nombre de la competición.
     * @return El código de la competición.
     */

    public int getCodigoCompeticionPorNombre(String nombre) {
        return cbd.getCodigoCompeticionPorNombre(nombre);
    }

    /**
     * Método para generar el calendario de una competición.
     *
     * @param codCompeticion El código de la competición.
     */

    public void generarCalendario(int codCompeticion) {
        cbd.generarCalendario(codCompeticion);
    }

    /**
     * Método para obtener los enfrentamientos por competición y jornada.
     *
     * @param com        La competición.
     * @param numJornada El número de la jornada.
     * @return La lista de enfrentamientos.
     */

    public ArrayList<Enfrentamiento> obtenerEnfrentamientosPorCompeticionYJornada(Competicion com, int numJornada) {
        return cbd.obtenerEnfrentamientosPorCompeticionYJornada(com, numJornada);
    }

    /**
     * Método para insertar el resultado de un enfrentamiento.
     *
     * @param codEnfrentamiento El código del enfrentamiento.
     * @param equipoGanador     El equipo ganador.
     */

    public void insertarResultadoEnfrentamiento(String codEnfrentamiento, String equipoGanador, String nombreCompe) {
        cbd.insertarResultadoEnfrentamiento(codEnfrentamiento, equipoGanador,nombreCompe);
    }

    public String generarXMLClasificacion() {
        return cbd.generarXMLClasificacion();
    }

    public String generarXMLJornada() {
        return cbd.generarXMLJornada();
    }

    public String generarXMLTodasJornadas() {
        return cbd.generarXMLTodasJornadas();
    }
}
