package Helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    public static boolean validateUserName(String InputName) {
        //Validates username of the waiter
        //Username must contain only letters and numbers min 2 max 30
        final String regex = "^[a-zA-Z-0-9]{2,30}$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(InputName);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean validateFullName(String InputName) {
        //Validates the full name of the user
        //Name must contain only letters min 2 max 25
        //Names must start with Capital letter and each new name must start with capital letter and may contain capital letter
        //Example Ivan, Ivan Ivanov Ivanov , Ivan Ivanov Ivanov Invaov , IvAn IvaNOV , IVAN IVANOV
        final String regex = "^([A-Z][a-zA-Z]{1,25}\\s{0,25})+([A-Z][a-zA-Z]{1,25}\\s{0,25})?+([A-Z][a-zA-Z]{1,25})?$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(InputName);
        if (matcher.find()) {
            return true;
        }
        return false;
    }


    public static boolean validatePassword(String InputPassword) {
        //Validate password of the waiter
        //Valid password is any 4 digit combination
        //Example : 1234 , 2345 , 5896 , 5555 , 8754 , 9658 ...
        final String regex = "^\\d{4}$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(InputPassword);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

}
