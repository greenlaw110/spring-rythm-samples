package org.rythmengine.spring.samples.tags_transformers.transformers;

import org.rythmengine.extension.Transformer;
import org.rythmengine.spring.TransformerBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Num2RMB extends TransformerBean {

    private static String[] RMB = "零,壹,贰,叁,肆,雾,陆,柒,捌,玖".split(",");
    private static String[] unit = "角,分,圆,拾,佰,仟,万,拾,佰,仟,亿".split(",");

    public static String toRMB(double num) {
        return toRMB(String.valueOf(num));
    }

    public static String toRMB(float num) {
        return toRMB(String.valueOf(num));
    }

    public static String toRMB(int num) {
        return toRMB(String.valueOf(num));
    }

    public static String toRMB(long num) {
        return toRMB(String.valueOf(num));
    }

    @Transformer
    public static String toRMB(String num) {
        String result = "";

        String integer = divide(num, true);
        String decimal = divide(num, false);

        result += convert(integer, true);
        result += convert(decimal, false);

        result = zeroClear(result);

        return result;
    }


    private static String zeroClear(String str) {
        String[] regex = {"零分", "零角", "零拾", "零佰", "零仟"};

        String result = str;

        for (int i = 0; i < regex.length; i++) {
            result = result.replace(regex[i], "零");
        }

        result = result.replace("零零零零", "");
        result = result.replace("零零零", "零");
        result = result.replace("零零", "零");
        result = result.replace("零万", "万");
        result = result.replace("零圆", "圆");


        return result;
    }

    private static String divide(String num, boolean isIntegerPart) {
        String result = "";

        if (isIntegerPart) {
            result = num.split("\\.")[0];
            while (result.charAt(0) == '0') {
                result = result.substring(1);
            }

            return result;
        } else {
            String tmp = num.split("\\.")[1];
            result = tmp.substring(0, 2);
            return result;
        }
    }

    private static String convert(String str, boolean isIntegerPart) {
        String result = "";

        int strLength = str.length();
        if (isIntegerPart) {
            for (int i = 0; i < strLength; i++) {
                result += RMB[str.charAt(i) - 48];
                result += unit[strLength - i + 1];
            }

            return result;

        } else {
            for (int i = 0; i < strLength; i++) {
                result += RMB[str.charAt(i) - 48];
                result += unit[i];
            }

            return result;
        }

    }


    // main
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(10) + 1;

        String str = "";
        for (int i = 0; i < length; i++) {
            str += String.valueOf((int) (Math.random() * 10));
        }
        str += ".";
        for (int i = 0; i < 2; i++) {
            str += String.valueOf((int) (Math.random() * 10));
        }

        System.out.println(str);
        System.out.println(Num2RMB.toRMB(str));
    }

}