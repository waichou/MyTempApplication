package com.aaa.test.myapplication.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/7/28 17:43
 * <p>
 * Description: 正则校验工具类
 */
@SuppressWarnings("unused")
public class RegularUtil {
    // 分割字符
    public static final String splitStrPattern = ",|，|;|；|、|\\.|。|-|_|\\(|\\)|\\[|\\]|\\{|\\}|\\\\|/| |　|\"";

    private static boolean isMatch(String regex, String original) {
        if (original == null || original.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum   = pattern.matcher(original);
        return isNum.matches();
    }

    /**
     * 是否是正整数
     */
    public static boolean isPositiveInteger(String original) {
        return isMatch("^\\+?[0-9]\\d*", original);
    }

    /**
     * 是否是负整数
     */
    public static boolean isNegativeInteger(String original) {
        return isMatch("^-[0-9]\\d*", original);
    }

    /**
     * 是否是整数
     */
    public static boolean isInteger(String original) {
        return isMatch("^[\\+-]?[0-9]\\d*", original);
    }

    /**
     * 是否是正浮点数
     */
    public static boolean isPositiveDecimal(String original) {
        return isMatch("^\\+?[0-9]\\d*\\.\\d*|0\\.\\d*[0-9]\\d*", original);
    }

    /**
     * 是否是负浮点数
     */
    public static boolean isNegativeDecimal(String original) {
        return isMatch("^-([0-9]\\d*\\.\\d*|0\\.\\d*[0-9]\\d*)", original);
    }

    /**
     * 是否是浮点数
     */
    public static boolean isFloat(String original) {
        return isMatch("^[\\+-]?([0-9]\\d*\\.\\d*|0\\.\\d*[0-9]\\d*|0?\\.0+|0)", original);
    }

    public static boolean isNumber(String original) {
        return isInteger(original) || isFloat(original);
    }

    /**
     * 判断是否纯字母组合
     */
    public static boolean isABC(String original) {
        return isMatch("^[A-Za-z]+", original);
    }

    /**
     * 判断是否符合邮箱规则
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(email).matches();
    }

    /**
     * 验证手机格式
     */
    public static boolean isPhone(String phone) {
        /*
         * 移动号段：
         *          134 135 136 137 138 139
         *          147 148 150 151 152 157 158 159
         *          178 182 183 184 187 188 198
         * 联通号段：
         *          130 131 132
         *          145 146 155 156 166
         *          175 176 185 186
         * 电信号段：
         *          133 149 153 173 177 180 181 189 199
         *
         * 虚拟运营商号段：
         *          170 171 172
         */
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        phone = phone.replaceAll("\\s*", "");
        Pattern regex   = Pattern.compile("^((1[38][0-9])|(14[5-9])|(1[5][0-35-9])|166|(17[0-35-8])|19[8-9])\\d{8}$");
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }

    /**
     * 判断字符串str是否符合正则表达式reg
     */
    public static boolean isMatcher(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(str).matches();
    }

    /**
     * 获取符合reg正则表达式的字符串在String中出现的次数
     */
    public static int countSubStrReg(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int     i = 0;
        while (m.find()) {
            String temp = m.group(0);
            i += temp.length();
        }
        return i;
    }
}
