package utils;

import java.util.Map;

/**
 * Constant class description.
 *
 * @author quangle
 * @version 2024/06/20
 */
public class Constant {
    public static final Integer ID_LENGTH = 12;
    public static final Integer STRING_TOTAL_LENGTH = 61;
    public static final Integer ACCOUNT_NUMBER_LENGTH = 6;
    public static final Integer ACCOUNT_FLOOR_LIMIT_BALANCE = 50000;
    public static final int PREMIUM_POINT = 10000000;
    public static final String STRING_FORMAT = "|%-" + STRING_TOTAL_LENGTH + "s|";
    //     Key: PROVINCE_CODE,  Value: PROVINCE
    public static final Map<String, String> PROVINCE_CODE_LIST = Initialization.provinceCodeListInitialize();
    //     Key: GENDER_CODE,  Value: First 2 numbers of the CENTURY
    public static final Map<String, String> GENDER_CODE_LIST = Initialization.genderCodeListInitialize();

    public static String LANGUAGE = "vi";
    public static String COUNTRY = "VN";
}