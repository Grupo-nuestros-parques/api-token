package com.nuestrosparques.token.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Fechas {

  /**
   * Metodo que modificar la Hora , minuto ,segundo milesegundo a 0 a  Fecha con Formato Date (TRUNC)
   * @param fecha
   * @return
   */
  public static Date modificaHoraAFechaDate(Date fecha) {
    Calendar c = Calendar.getInstance();
    try {
      c.setTime(fecha);
      c.set(Calendar.HOUR_OF_DAY, 0);
      c.set(Calendar.MINUTE, 0);
      c.set(Calendar.SECOND, 0);
      c.set(Calendar.MILLISECOND, 0);
      return c.getTime();
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * *
   * Devuelve la fecha actual (SYSDATE)
   *
   * @return
   */
  public static Date fechaActual() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
    return calendar.getTime();
  }

  /**
   * Retorna sysdate con hora 23:59:59 Uso en (BETWEEN)
   *
   * @return Date
   */
  public static Date fechaFinDia() {
    Date fechaFin = null;
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(modificaHoraAFechaDate(fechaActual()));
      calendar.add(Calendar.HOUR, 23);
      calendar.add(Calendar.MINUTE, 59);
      calendar.add(Calendar.SECOND, 59);
      fechaFin = calendar.getTime();
    } catch (Exception e) {
    }
    return fechaFin;
  }

  /**
   *
   * Retorna sysdate con hora 23:59:59 Uso en (BETWEEN)
   *
   * @return Date
   */
  public static Date fechaFinDiaByDate(Date fecha) {
    Date fechaFin = null;
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(modificaHoraAFechaDate(fecha));
      calendar.add(Calendar.HOUR, 23);
      calendar.add(Calendar.MINUTE, 59);
      calendar.add(Calendar.SECOND, 59);
      fechaFin = calendar.getTime();
    } catch (Exception e) {
    }
    return fechaFin;
  }

  public static Date inicioDiaPorFecha(Date date) {
    Date fechaFin = null;
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(modificaHoraAFechaDate(date));
      calendar.add(Calendar.HOUR, 00);
      calendar.add(Calendar.MINUTE, 00);
      calendar.add(Calendar.SECOND, 00);
      fechaFin = calendar.getTime();
    } catch (Exception e) {
    }
    return fechaFin;
  }

  /**
   *
   * Retorna fecha dd/mm/yy
   *
   * @return Date
   */
  public static String formatDate(Date fecha) {
    String fechaFormatted = null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      fechaFormatted = formatter.format(fecha);
    } catch (Exception e) {
    }
    return fechaFormatted;
  }

  /**
   *
   * Retorna hour HH:mm
   *
   * @return Date
   */
  public static String formatHour(Date fecha) {
    String fechaFormatted = null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
      fechaFormatted = formatter.format(fecha);
    } catch (Exception e) {
    }
    return fechaFormatted;
  }

  /**
   *
   * Retorna fecha dd-mm-yyyy
   *
   * @return Date
   */
  public static String formatDateVersion2(Date fecha) {
    String fechaFormatted = null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      fechaFormatted = formatter.format(fecha);
    } catch (Exception e) {
    }
    return fechaFormatted;
  }

  /**
   *
   * Retorna fecha del día anterior dd-mm-yyyy
   *
   * @return Date
   */
  public static Date getYesterday() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
  }

  /* Transform date String to Date  (TO_DATE)
     * @param dateInString
     * @param formato
     * @return
         */
  public static Date transformStringDateToDate(String dateInString, String formato) {
    SimpleDateFormat formatter = new SimpleDateFormat(formato);
    try {
      if(dateInString!=null){
        Date date = formatter.parse(dateInString);
        return date;
      }
      return null;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Add days to date (BETWEEN)
   *
   * @return Date
   */
  public static Date addDaysToDate(Date date, Integer days){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.DATE, days);
    return c.getTime();
  }

  /**
   * Add hours to date (BETWEEN)
   *
   * @return Date
   */
  public static Date addHoursToDate(Date date, Integer hour){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.HOUR_OF_DAY, hour);
    return c.getTime();
  }

  /**
   * Add minutes to date (BETWEEN)
   *
   * @return Date
   */
  public static Date addMinutesToDate(Date date, Integer minutes){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.MINUTE, minutes);
    return c.getTime();
  }

  /**
   * Add years to date (BETWEEN)
   *
   * @return Date
   */
  public static Date addYearsToDate(Date date, Integer years){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.YEAR, years);
    return c.getTime();
  }

  /**
   * Subtract days to date (BETWEEN)
   *
   * @return Date
   */
  public static Date subtractDaysToDate(Date date, Integer days){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.DATE, -days);
    return c.getTime();
  }
}
