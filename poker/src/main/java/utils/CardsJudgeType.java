package utils;

import constants.CardConstants;

import java.util.*;

import static utils.CardsUtil.judgeFlush;
import static utils.CardsUtil.judgeStraight;

/**
 * @description: 判断牌面
 * @author: wei·man cui
 * @date: 2020/10/30 9:49
 */
public class CardsJudgeType {

    public static String judgeType(String[] color, Integer[] number) {
        boolean type1 = judgeFlush(color);
        boolean typ2 = judgeStraight(number);
        if (type1 && typ2) {
            return "StraightFlush";
        } else if (type1) {
            // 同花
            return "Flush";
        } else if (typ2) {
            // 顺子
            return "Straight";
        } else {
            return judgeType(number);
        }
    }

    /**
     * 散排 或 一对
     */
    private static String judgeType(Integer[] number) {
        Set<Integer> set = new HashSet<>(Arrays.asList(number));
        if (set.size() == CardConstants.HIGH_CARD_SET_SIZE) {
            // 散牌
            return "HighCard";
        } else if (set.size() == CardConstants.ONE_PAIR_SET_SIZE) {
            return "OnePair";
        } else {
            return judgeType(number, set);
        }
    }

    /**
     * 四条、葫芦、三条、两对
     */
    private static String judgeType(Integer[] number, Set<Integer> set) {
        Map<Integer, Long> map = CardsUtil.judgeKind(number);
        List<Integer> list = new ArrayList<>(set);
        Long a = map.get(list.get(0));
        Long b = map.get(list.get(1));
        if (set.size() == CardConstants.FOUR_OR_FULL_SET_SIZE) {
            if (CardConstants.FOUR_OF_KIND.contains(a)) {
                // 四条
                return "FourOfAKind";
            } else {
                // 葫芦
                return "FullHouse";
            }
        } else {
            // size只能是 3
            Long c = map.get(list.get(2));
            if (CardConstants.TWO_PAIR.equals(a) || CardConstants.TWO_PAIR.equals(b) || CardConstants.TWO_PAIR.equals(c)) {
                return "TwoPair";
            } else {
                return "ThreeOfAKind";
            }
        }
    }


}
