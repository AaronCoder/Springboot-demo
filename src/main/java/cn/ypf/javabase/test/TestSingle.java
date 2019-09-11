package cn.ypf.javabase.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestSingle {
    public static void main(String args[]) {
        TestSingle test = new TestSingle();
        String timeJson = "20190330";
        test.StringToLocalDate(timeJson);

    }
   LocalDate StringToLocalDate(String time){
        String fullTimeString= time.substring(0,8);
        String transTimeString = fullTimeString.substring(0,4)+"-"+fullTimeString.substring(4,6)+"-"+fullTimeString.substring(6);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate localDate = LocalDate.parse(transTimeString, df);
            System.out.println(localDate);
            return localDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
