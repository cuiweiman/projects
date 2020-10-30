package entity;

import constants.CardConstants;
import lombok.Data;
import utils.CardsJudgeType;
import utils.CardsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 一手牌
 * @author: wei·man cui
 * @date: 2020/10/30 9:31
 */
@Data
public class Cards {

    private String player;

    private Integer[] points;

    private String[] colors;

    private String type;

    private Integer typeIndex;

    private String highCard;

    public Cards(String player, String playerCard) {
        this.player = player;
        this.points = CardsUtil.getNumber(playerCard);
        this.colors = CardsUtil.getColor(playerCard);
        this.type = CardsJudgeType.judgeType(this.colors, this.points);
        if (CardConstants.TYPE_NEED_SORT.contains(type)) {
            doSort(this.points);
        }
        this.typeIndex = CardConstants.MAP.get(type);
        this.highCard = CardConstants.DEFAULT_HIGH_CARD;
    }

    /**
     * 四条、三张、两对、单排，按序排列
     */
    private void doSort(Integer[] arr) {
        Integer[] result = new Integer[arr.length];
        Map<Integer, Long> map = CardsUtil.judgeKind(arr);
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                result[index] = list.get(i).getKey();
                index++;
            }
        }
        this.points = result;
    }

}
