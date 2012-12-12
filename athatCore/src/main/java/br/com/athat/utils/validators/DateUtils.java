package br.com.athat.utils.validators;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Integer obterDiaDoMes(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		return calendar.get(Calendar.DATE);
	}

	public static Date obterDataMaisDias(Date data, Integer dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + dias);
		return calendar.getTime();
	}

	public static Date obterDataMenosDias(Date data, Integer dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - dias);
		return calendar.getTime();
	}
	
	public static Calendar zerarHoras(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }
	
	public static Date zerarHoras(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
    }
	
	public static Date horasFinal(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 59);
		return calendar.getTime();
    }
	
	public static Calendar horasFinal(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 23);
        date.set(Calendar.MINUTE, 59);
        date.set(Calendar.SECOND, 59);
        date.set(Calendar.MILLISECOND, 59);
        return date;
    }
}
