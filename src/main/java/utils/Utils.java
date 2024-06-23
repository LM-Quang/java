package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * provinceCodeList class description.
 *
 * @author quangle
 * @version 2024/06/20
 */
public class Utils {
    //     Key: PROVINCE_CODE,  Value: PROVINCE
    public static Map<String, String> PROVINCE_CODE_LIST = provinceCodeListInitialize();
    //     Key: GENDER_CODE,  Value: First 2 numbers of the CENTURY
    public static Map<String, String> GENDER_CODE_LIST = genderCodeListInitialize();

    public static final int PREMIUM_POINT = 10000000;
    private static Map<String, String> provinceCodeListInitialize() {
        //     Key: PROVINCE_CODE,  Value: PROVINCE
        Map<String, String> provinceCodeList = new HashMap<>();
        provinceCodeList.put("001", "Ha Noi");
        provinceCodeList.put("002", "Ha Giang");
        provinceCodeList.put("004", "Cao Bang");
        provinceCodeList.put("006", "Bac Kan");
        provinceCodeList.put("008", "Tuyen Quang");
        provinceCodeList.put("010", "Lao Cai");
        provinceCodeList.put("011", "Dien Bien");
        provinceCodeList.put("012", "Lai Chau");
        provinceCodeList.put("014", "Son La");
        provinceCodeList.put("015", "Yen Bai");
        provinceCodeList.put("017", "Hoa binh");
        provinceCodeList.put("019", "Thai Nguyen");
        provinceCodeList.put("020", "Lang Son");
        provinceCodeList.put("022", "Quang Ninh");
        provinceCodeList.put("024", "Bac Giang");
        provinceCodeList.put("025", "Phu Tho");
        provinceCodeList.put("026", "Vinh Phuc");
        provinceCodeList.put("027", "Bac Ninh");
        provinceCodeList.put("030", "Hai Duong");
        provinceCodeList.put("031", "Hai Phong");
        provinceCodeList.put("033", "Hung Yen");
        provinceCodeList.put("034", "Thai Binh");
        provinceCodeList.put("035", "Ha Nam");
        provinceCodeList.put("036", "Nam Dinh");
        provinceCodeList.put("037", "Ninh Binh");
        provinceCodeList.put("038", "Thanh Hoa");
        provinceCodeList.put("040", "Nghe An");
        provinceCodeList.put("042", "Ha Tinh");
        provinceCodeList.put("044", "Quang Binh");
        provinceCodeList.put("045", "Quang Thi");
        provinceCodeList.put("046", "Thua Thien Hue");
        provinceCodeList.put("048", "Da Nang");
        provinceCodeList.put("049", "Quang Nam");
        provinceCodeList.put("051", "Quang Ngai");
        provinceCodeList.put("052", "Binh Dinh");
        provinceCodeList.put("054", "Phu Yen");
        provinceCodeList.put("056", "Khanh Hoa");
        provinceCodeList.put("058", "Ninh Thuan");
        provinceCodeList.put("060", "Binh Thuan");
        provinceCodeList.put("062", "Kon Tum");
        provinceCodeList.put("064", "Gia Lai");
        provinceCodeList.put("066", "Dak Lak");
        provinceCodeList.put("067", "Dak Nong");
        provinceCodeList.put("068", "Lam Dong");
        provinceCodeList.put("070", "Binh Phuoc");
        provinceCodeList.put("072", "Tay Ninh");
        provinceCodeList.put("074", "Binh Duong");
        provinceCodeList.put("075", "Dong Nai");
        provinceCodeList.put("077", "Ba Ria - Vung Tau");
        provinceCodeList.put("079", "Ho Chi Minh");
        provinceCodeList.put("080", "Long An");
        provinceCodeList.put("082", "Tien Giang");
        provinceCodeList.put("083", "Ben Tre");
        provinceCodeList.put("084", "Tra Vinh");
        provinceCodeList.put("086", "Vinh Long");
        provinceCodeList.put("087", "Dong Thap");
        provinceCodeList.put("089", "An Giang");
        provinceCodeList.put("091", "Kien Giang");
        provinceCodeList.put("092", "Can Tho");
        provinceCodeList.put("093", "Hau Giang");
        provinceCodeList.put("094", "Soc Trang");
        provinceCodeList.put("095", "Bac Lieu");
        provinceCodeList.put("096", "Ca Mau");
        return provinceCodeList;
    }

    /*
    * CENTURY = 20 => 0 = MALE, 1 = FEMALE
    * CENTURY = 21 => 2 = MALE, 3 = FEMALE
    * CENTURY = 22 => 4 = MALE, 5 = FEMALE
    * CENTURY = 23 => 6 = MALE, 7 = FEMALE
    * CENTURY = 24 => 8 = MALE, 9 = FEMALE
    * */

    /*
    * CENTURY 20 => 1900 to 1999
    * CENTURY 21 => 2000 to 2099
    * CENTURY 22 => 2100 to 2199
    * CENTURY 23 => 2200 to 2299
    * CENTURY 24 => 2300 to 2399
    * */
    private static Map<String, String> genderCodeListInitialize() {
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

    public static boolean isCitizenshipIDValid(String id) {
        /*
         * Kiểm tra số CCCD
         * 1. Độ dài đúng bằng 12 kí tự
         * 2. Tất cả các ký tự phải là số từ [0-9]
         * 3. Kiểm tra mã tỉnh: tách 3 kí tự đầu của CCCD sau đó so với mảng mã tĩnh
         * */

        /*
         * Check Citizen Identification Number
         * 1. Has to be a 12-character length
         * 2. Each character has to be a number from 0 to 9
         * 3. Check Province Code: Compare the first 3 characters with Province Code
         * */
        if (id.length() != 12) {
            return false;
        }

        if (!isNumber(id)) {
            return false;
        }

        String provinceCode = id.substring(0, 3);
        return PROVINCE_CODE_LIST.containsKey(provinceCode);
    }

    private static boolean isNumber(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}