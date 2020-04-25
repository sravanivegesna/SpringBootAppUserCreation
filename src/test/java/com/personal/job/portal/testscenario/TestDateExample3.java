package com.personal.job.portal.testscenario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateExample3 {

    public static void main(String[] argv) {

    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String dateInString = "2013-02-12";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
