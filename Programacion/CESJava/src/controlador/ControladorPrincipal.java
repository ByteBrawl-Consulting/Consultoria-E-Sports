package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import controlador.competiciones.ControladorCompeticion;
import modelo.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;


    public ControladorPrincipal() {
        cv = new ControladorVista(this);
        cbd = new ControladorBaseDeDatos(this);

    }

    public String login(Usuario usu) throws SQLException {
        return cbd.login(usu);
    }

    public void altaEquipo(Equipo eq) {
        cbd.altaEquipo(eq);
    }

    public void bajaEquipo(Equipo eq) {
        cbd.bajaEquipo(eq);
    }

    public void modiEquipo(Equipo eq, String fecha) {
        cbd.modiEquipo(eq, fecha);
    }

    public String consultaEquipo(String nombreEq) {
        return cbd.consultaEquipo(nombreEq).toString();
    }

    public ArrayList ultimaJornada(Competicion com) {
        return cbd.ultimaJornada(com);
    }

    public ArrayList todasJornadas(Competicion com) {
        return cbd.todasJornadas(com);
    }

    public Equipo buscarEquipo(String nombreEq) {
        return cbd.buscarEquipo(nombreEq);
    }

    public void altaStaff(Staff staff) {
        cbd.altaStaff(staff);
    }

    public void bajaStaff(Staff staff) {
        cbd.bajaStaff(staff);
    }

    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        cbd.modiStaff(staff, cargo, sueldo, cod_equipo);
    }

    public String consultaStaff(String nombreSt) {
        return cbd.consultaStaff(nombreSt).toString();
    }

    public void altaJugador(Jugador ju) {
        cbd.altaJugador(ju);
    }

    public void bajaJugador(Jugador ju) {
        cbd.bajaJugador(ju);
    }

    public void modiJugador(Jugador ju, String fecha) {
        cbd.modiJugador(ju, fecha);
    }

    public String consultaJugador(String nombre) {
        return cbd.consultaJugador(nombre).toString();
    }

    public void altaJuego(Juego juego) {
        cbd.altaJuego(juego);
    }

    public void bajaJuego(Juego juego) {
        cbd.bajaJuego(juego);
    }

    public void modiJuego(Juego juego) {
        cbd.modiJuego(juego);
    }

    public Object consultaJuego(String nombreJu) {
        return cbd.consultaJuego(nombreJu).toString();
    }

    public Juego buscarJuego(String nombreJu) {
        return cbd.buscarJuego(nombreJu);
    }

    public void altaPatrocinador(Patrocinador patr) {
        cbd.altaPatrocinador(patr);
    }

    public void bajaPatrocinador(Patrocinador patr) {
        cbd.bajaPatrocinador(patr);
    }

    public void altaCompeticion(Competicion compe) {
        cbd.altaCompeticion(compe);
    }

    public void bajaCompeticion(Competicion compe) {
        cbd.bajaCompeticion(compe);
    }

    public void modiCompeticion(Competicion compe) {
        cbd.modiCompeticion(compe);
    }

    public String consultaCompeticion(String nombreCo) {
        return cbd.consultaCompeticion(nombreCo).toString();
    }

    public ArrayList clasificacion(Competicion com) {
        return cbd.calsificacion(com);
    }

    public void asociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cbd.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    public void desasociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cbd.desasociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    public void altaUsu(Usuario usu) throws Exception {
        cbd.altaUsu(usu);
    }

    public Usuario comprobarUsu(Usuario usu) throws Exception {
        return cbd.comprobarUsu(usu);
    }

    public Juego getNombreJuegoPorCodigo(int cod) {
        return cbd.getNombreJuegoPorCodigo(cod);
    }

    public Equipo getNombreEquipoPorCodigo(int codEquipo) {
        return cbd.getNombreEquipoPorCodigo(codEquipo);
    }

    public ArrayList clasiEquipos() throws Exception {
        return cbd.clasiEquipo();
    }

    public ArrayList clasificacionAdmin(Competicion com) {
        return cbd.calsificacionAdmin(com);
    }

    public void asociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cbd.asociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    public void desasociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cbd.desasociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    public List<String> getEquiposPorPatrocinador(String nombrePatrocinador) {
        return cbd.getEquiposPorPatrocinador(nombrePatrocinador);
    }

    public List<String> getPatrocinadoresPorEquipo(String nombreEquipo) {
        return cbd.getPatrocinadoresPorEquipo(nombreEquipo);
    }

    public ArrayList<Equipo> getEquiposPorCompeticion(Competicion com) {
        return cbd.getEquiposPorCompeticion(com);
    }

    public void cerrarIncripcionCompeticion(String nombreCompeticion) {
        cbd.cerrarIncripcionCompeticion(nombreCompeticion);
    }

    public int getCodigoCompeticionPorNombre(String nombre) {
        return cbd.getCodigoCompeticionPorNombre(nombre);
    }

    public void generarCalendario(int codCompeticion) {
        cbd.generarCalendario(codCompeticion);
    }
}
