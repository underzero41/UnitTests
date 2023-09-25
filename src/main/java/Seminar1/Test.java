package Seminar1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
//        assertConditionA();
//        assertConditionB();
//        sum(52321321,533323232);
//        happyNY();
    }

    private static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());

        assert currentDateTime.equals("01/01/2023 00:00:00"): "Still 2023";
        System.out.println("Happy NY");

    }

    private static void assertConditionB() {
        int x = -1;
        assert x < 0;
    }

    private static void assertConditionA() {
        String[] weekends = {"Saturday", "Sunday"};
        assert weekends.length == 2;
        System.out.println("In the weekend " + weekends.length + " days off");
    }

    public static int sum(int a, int b){
        assert (Integer.MAX_VALUE - a > b): "Very big number";
        return a+b;
    }
}