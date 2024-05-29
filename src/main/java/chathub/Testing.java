package chathub;

import java.time.LocalDate;

public class Testing {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String date_String = date.toString();
        System.out.println("date = " + date_String);
    }
}
