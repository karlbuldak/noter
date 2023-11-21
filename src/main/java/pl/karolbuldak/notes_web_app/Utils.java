package pl.karolbuldak.notes_web_app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String generateRandomSlug(int length){
        String randomString = "";
        while (true) {
            if (randomString.length() >= length)
                return randomString.substring(0, length - 1);
            else
                randomString += java.util.UUID.randomUUID().toString().replaceAll("-", "");
        }
    }
    public static String returnCurrentLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
