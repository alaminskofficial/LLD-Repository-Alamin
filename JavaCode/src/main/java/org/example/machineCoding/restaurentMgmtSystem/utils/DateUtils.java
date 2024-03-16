package org.example.machineCoding.restaurentMgmtSystem.utils;

import org.example.machineCoding.restaurentMgmtSystem.models.Pair;
import org.example.machineCoding.restaurentMgmtSystem.models.RevenueQueryType;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Pair<Date, Date> getStartAndEndDateByQueryType(RevenueQueryType revenueQueryType) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        int financialYearStart = year; // As financial year now starts in January

        Calendar startCal = (Calendar) cal.clone();
        Calendar endCal = (Calendar) cal.clone();

        switch (revenueQueryType) {
            case CURRENT_FY -> {
                startCal.set(financialYearStart, Calendar.JANUARY, 1);
                endCal.set(financialYearStart, Calendar.DECEMBER, 31);
            }
            case PREVIOUS_FY -> {
                startCal.set(financialYearStart - 1, Calendar.JANUARY, 1);
                endCal.set(financialYearStart - 1, Calendar.DECEMBER, 31);
            }
            case CURRENT_MONTH -> {
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
            case PREVIOUS_MONTH -> {
                startCal.add(Calendar.MONTH, -1);
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                endCal.add(Calendar.MONTH, -1);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
            default -> throw new IllegalArgumentException("Invalid RevenueQueryType");
        }

        return new Pair<>(startCal.getTime(), endCal.getTime());
    }

    public static boolean equalDates(Date date1, Date date2) {
        if(date1.getMonth() == date2.getMonth() && date1.getYear() == date2.getYear() && date1.getDate() == date2.getDate()) {
            return true;
        }
        return false;
    }

}
