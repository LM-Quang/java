package validation;

import utils.ProvinceCodeList;

import java.util.Map;

/**
 * IdValidation class description.
 *
 * @author quangle
 * @version 2024/06/30
 */
public class IdValidation {
    private static final int ID_LENGTH = 12;

    //     Key: PROVINCE_CODE,  Value: PROVINCE
    private static final Map<String, String> PROVINCE_CODE_LIST = ProvinceCodeList.provinceCodeListInitialize();

    public static boolean isIdValid(String id) {
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
        if (id.length() != ID_LENGTH) {
            return false;
        }

        if (!NumberValidation.isNumber(id)) {
            return false;
        }

        String provinceCode = id.substring(0, 3);
        return PROVINCE_CODE_LIST.containsKey(provinceCode);
    }
}