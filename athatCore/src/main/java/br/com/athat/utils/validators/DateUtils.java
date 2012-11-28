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
	
	public static void zerarHoras(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
    }

}
