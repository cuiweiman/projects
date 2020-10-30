package utils;

import constants.CardConstants;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 获取 牌花色 和 牌顺序
 * @author: wei·man cui
 * @date: 2020/10/30 9:51
 */
public class CardsUtil {

    /**
     * 判断是不是同花
     */
    public static boolean judgeFlush(String[] color) {
        Set<String> hashSetType = new HashSet<>(Arrays.asList(color));
        return hashSetType.size() == 1;
    }

    /**
     * 判断是不是顺子
     */
    public static boolean judgeStraight(Integer[] number) {
        for (int i = 0; i < number.length-1; i++) {
            if (number[i] - number[i + 1] != 1) {
                return false;
            }
        }
        return true;
    }


    /**
     * 分组计数
     */
    public static Map<Integer, Long> judgeKind(Integer[] number) {
        List<Integer> list = Arrays.asList(number);
        return list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    }

    public static String[] getColor(String string) {
        String[] color = new String[5];
        String[] strArray = string.split("");
        for (int i = 0; i < CardConstants.CARD_NUMBER; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        return color;
    }

    public static Integer[] getNumber(String string) {
        List<Integer> list = new ArrayList<>(8);
        String[] strings = string.split("");
        for (String s : strings) {
            int indexOf = CardConstants.VALUE.indexOf(s);
            if (indexOf >= 2) {
                list.add(indexOf);
            }
        }
        list.sort(Integer::compareTo);
        Collections.reverse(list);
        return list.toArray(new Integer[0]);
    }


}
