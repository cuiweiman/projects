package game;

import entity.Cards;
import utils.JudgeResult;

// Please don't modify the class name.
public class Poker {

    // Please don't modify the signature of this method.
    // Please keep the result output format.
    public String compairResult(String player1, String player2) {
        Cards p1 = new Cards("player1", player1);
        Cards p2 = new Cards("player2", player2);
        return JudgeResult.compare(p1, p2);
    }
/*

    public static void main(String[] args) {
        String player1 = "TC 4C 5D AC TH";
        String player2 = "5S 8S 8C 9H 5H";
        Poker poker = new Poker();
        String string = poker.compairResult(player1, player2);
        System.out.println(string);
    }
*/

   /* public static void main(String[] args) {
        test(100);
    }*/
/*

    public static void test(int times) {
        Random random = new Random();

        List<String> defaultPoints = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
        List<String> defaultType = Arrays.asList("H", "D", "S", "C");

        for (int k = 0; k < times; k++) {
            List<String> cardsPool = defaultPoints.stream().flatMap(item -> defaultType.stream().map(item2 -> item + item2)).collect(Collectors.toList());
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            while (list1.size() < 5) {
                String item = cardsPool.remove(random.nextInt(cardsPool.size()));
                list1.add(item);
            }
            while (list2.size() < 5) {
                String item = cardsPool.remove(random.nextInt(cardsPool.size()));
                list2.add(item);
            }
            System.out.println("=============   第" + k + "测试结果   =============");
            String player1 = list1.toString().replace("[", "").replaceAll("]", "").replace(",", "");
            String player2 = list2.toString().replace("[", "").replaceAll("]", "").replace(",", "");
            System.out.println("【牌面】" + player1);
            System.out.println("【牌面】" + player2);
            Poker poker = new Poker();
            String result = poker.compairResult(player1, player2);
            System.out.println(result);
            System.out.println();
        }
    }
*/

}
