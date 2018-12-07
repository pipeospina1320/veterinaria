/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

/**
 *
 * @author felipe
 */
import entidades.AsignacionTareas;
import entidades.Personal;
import entidades.Tarea;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import veterinaria.persistencia.PersonalDAO;
import veterinaria.persistencia.TareaDAO;

public class Temporizador extends TimerTask {

//https://programandoointentandolo.com/2014/09/ejecutar-metodo-a-hora-especifica-java.html
    @Override
    public void run() {
        Calendar c = Calendar.getInstance();
        Date fechaActual = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String andQuery = "WHERE fechaAsignacion >=" + "'" + sdf.format(fechaActual) + "'";
        ArrayList<AsignacionTareas> tareas = new TareaDAO().listaTareasAsignadas(andQuery);
        if (c.get(Calendar.HOUR_OF_DAY) >= 8 && c.get(Calendar.HOUR_OF_DAY) < 18) {
            for (int i = 0; i < tareas.size(); i++) {
                // fechas
                Date fechaInicio = tareas.get(i).getFechaAsignacion();
                //String de fechas
                String strFechaActual = sdf.format(fechaActual);
                String strFechaInicio = sdf.format(fechaInicio);
                if (strFechaActual.compareTo(strFechaInicio) == 0 && tareas.get(i).getFinalizada() == 0) {
                    Personal personal = new PersonalDAO().buscar(Integer.toString(tareas.get(i).getIdPersonal()));
                    String asunto = "Tareas pendiente (" + tareas.get(i).getObjTarea().getNombre() + ")";
                    String mensaje = "La tarea tiene fecha de inicio el " + tareas.get(i).getFechaAsignacion();
                    EnviarEmail.SendMail(personal.getCorreo(), asunto, mensaje);
                }
            }
        }
        if (c.get(Calendar.HOUR_OF_DAY) >= 18 && c.get(Calendar.HOUR_OF_DAY) <= 24) {
            for (int i = 0; i < tareas.size(); i++) {
                Date fechaInicio = tareas.get(i).getFechaAsignacion();
                //String de fechas
                String strFechaActual = sdf.format(fechaActual);
                String strFechaInicio = sdf.format(fechaInicio);
                if (strFechaActual.compareTo(strFechaInicio) == 0 && tareas.get(i).getFinalizada() == 0) {
                    Personal personal = new PersonalDAO().buscar(Integer.toString(tareas.get(i).getIdPersonal()));
                    String asunto = "Tarea no realizada (" + tareas.get(i).getObjTarea().getNombre() + ")";
                    String mensaje = "La tarea no se realizo el " + tareas.get(i).getFechaAsignacion();
                    EnviarEmail.SendMail(personal.getCorreo(), asunto, mensaje);
                }
            }
        }
    }
}
