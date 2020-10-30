package constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 静态变量
 * @author: wei·man cui
 * @date: 2020/10/30 9:55
 */
public class CardConstants {

    private CardConstants() {
    }

    public static final Map<String, Integer> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put("StraightFlush", 1);
        MAP.put("FourOfAKind", 2);
        MAP.put("FullHouse", 3);
        MAP.put("Flush", 4);
        MAP.put("Straight", 5);
        MAP.put("ThreeOfAKind", 6);
        MAP.put("TwoPair", 7);
        MAP.put("OnePair", 8);
        MAP.put("HighCard", 9);
    }

    public static final List<String> TYPE_NEED_SORT = Arrays.asList("FourOfAKind", "FullHouse", "Flush", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard");

    public static final Integer CARD_NUMBER = 5;

    public static final String DEFAULT_HIGH_CARD = "DEFAULT";

    public static final List<String> VALUE = Arrays.asList(DEFAULT_HIGH_CARD, DEFAULT_HIGH_CARD, "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");

    public static final Integer HIGH_CARD_SET_SIZE = 5;
    public static final Integer ONE_PAIR_SET_SIZE = 4;
    public static final Integer FOUR_OR_FULL_SET_SIZE = 2;
    public static final List<Long> FOUR_OF_KIND = Arrays.asList(1L, 4L);
    public static final Long TWO_PAIR = 2L;

}
