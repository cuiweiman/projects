package utils;

import constants.CardConstants;
import entity.Cards;

import java.util.Arrays;

/**
 * @description: 牌面 大小比较
 * @author: wei·man cui
 * @date: 2020/10/30 10:40
 */
public class JudgeResult {

    public static String compare(Cards p1, Cards p2) {
        if (p1.getTypeIndex() < p2.getTypeIndex()) {
            return resultFormat(p1);
        } else if (p1.getTypeIndex() > p2.getTypeIndex()) {
            return resultFormat(p2);
        } else {
            if (Arrays.equals(p1.getPoints(), p2.getPoints())) {
                return "tie";
            } else {
                for (int i = 0; i < CardConstants.CARD_NUMBER; i++) {
                    int a = p1.getPoints()[i];
                    int b = p2.getPoints()[i];
                    if (a > b) {
                        p1.setHighCard(CardConstants.VALUE.get(p1.getPoints()[i]));
                        return resultFormat(p1);
                    } else if (a < b) {
                        p2.setHighCard(CardConstants.VALUE.get(p2.getPoints()[i]));
                        return resultFormat(p2);
                    }
                }
            }
        }
        return "tie";
    }

    private static String resultFormat(Cards cards) {
        if (CardConstants.DEFAULT_HIGH_CARD.equals(cards.getHighCard())) {
            return cards.getPlayer() + " wins - " + cards.getType();
        }
        return cards.getPlayer() + " wins - " + "high card:" + cards.getHighCard();
    }

}
