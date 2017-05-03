package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Gennady on 05/04/17.
 */
public class Utils {

    //TODO: fix the method to make it actualy work
    public static boolean checkWebElementText(List<WebElement> countries, String country) {
        boolean result = true;
        for (WebElement element : countries) {
            String hotCountryDestination = element.getText().replace(" ", "");
            boolean contains = hotCountryDestination.contains(country);
            System.out.println("Destination: " + hotCountryDestination);
            System.out.println("Destination correct: " + contains);
            System.out.println();
            result &= contains;
        }
        return result;
    }

    public static boolean checkPartialValuePresent(List<String> options, String value) {
        boolean result = true;
        for (String option: options) {
            boolean contains = option.contains(value);
            result &= contains;
        }
        return result;
    }
}
