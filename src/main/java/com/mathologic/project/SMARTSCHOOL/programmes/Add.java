package com.mathologic.project.SMARTSCHOOL.programmes;

import java.util.Calendar;
import java.util.Date;

public class Add {

    public static void main(String args[]){



        String arrivalTime ="13:14:00";
        String departureTime ="25:14:00";
        new Add().timeToMin(arrivalTime,departureTime );
        new Add().findDay_Of_Week();
    }

    public void timeToMin(String arr,String dep){
        String timePart []  = arr.split(":");
        String hh = timePart[0];
        String mm = timePart[1];
        Integer totalMin = (Integer.parseInt(hh) * 60)+Integer.parseInt(mm);


    }

      public void findDay_Of_Week(){

          Calendar cal = Calendar.getInstance();
          cal.setTime(new Date());
          int DayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
          System.out.print(Days.values()[DayOfWeek-1]);

      }
    public enum Days{
        SUNDAY ,
        MONDAY ,
        TUESDAY ,
        WEDNESDAY,
        THURSDAY ,
        FRIDAY ,
        SATURDAY
    }
}
