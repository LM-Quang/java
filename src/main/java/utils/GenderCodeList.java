package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * GenderCodeList class description.
 *
 * @author quangle
 * @version 2024/07/18
 */
public class GenderCodeList {
    /*
     * CENTURY = 20 => 0 = MALE, 1 = FEMALE
     * CENTURY = 21 => 2 = MALE, 3 = FEMALE
     * CENTURY = 22 => 4 = MALE, 5 = FEMALE
     * CENTURY = 23 => 6 = MALE, 7 = FEMALE
     * CENTURY = 24 => 8 = MALE, 9 = FEMALE

     * CENTURY 20 => 1900 to 1999
     * CENTURY 21 => 2000 to 2099
     * CENTURY 22 => 2100 to 2199
     * CENTURY 23 => 2200 to 2299
     * CENTURY 24 => 2300 to 2399
     * */
    public static Map<String, String> genderCodeListInitialize() {
        //     Key: GENDER_CODE,  Value: First 2 numbers of the CENTURY
        Map<String, String> genderCodeList = new HashMap<>();
        genderCodeList.put("0", "19");
        genderCodeList.put("1", "19");
        genderCodeList.put("2", "20");
        genderCodeList.put("3", "20");
        genderCodeList.put("4", "21");
        genderCodeList.put("5", "21");
        genderCodeList.put("6", "22");
        genderCodeList.put("7", "22");
        genderCodeList.put("8", "23");
        genderCodeList.put("9", "23");
        return genderCodeList;
    }
}