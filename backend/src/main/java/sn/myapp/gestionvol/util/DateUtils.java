package sn.myapp.gestionvol.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {
        // Do nothing
    }

    public static Calendar getCalendar(Date dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        return calendar;
    }

    private static void resetStartOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static Date startOfDay(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        Calendar calendar = getCalendar(dateTime);
        resetStartOfDay(calendar);
        return calendar.getTime();
    }

    public static Date endOfDay(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        Calendar calendar = getCalendar(dateTime);
        resetStartOfDay(calendar);
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    public static String timeWithoutDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            return sdf.format(date);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dayWithoutTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return sdf.format(date);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
