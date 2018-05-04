package game.main.black_jack;

/**
 * Created by guoyifeng on 5/4/18.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * test dfs used in deck calculating all possibilities with
 * all Aces
 */
@SuppressWarnings("Duplicates")
public class TestDFS {
    public static void main(String[] args) {
        Card a1 = new Card(Suit.CLUB, CardValue.ACE);
        Card a2 = new Card(Suit.SPADE, CardValue.ACE);
        List<Card> aces = new ArrayList<>();
        aces.add(a1);
        aces.add(a2);

        List<Integer> allPossibleValues = new ArrayList<>();
        dfs(allPossibleValues, aces, 5, 0, 0);
        for (Integer i : allPossibleValues) {
            System.out.print(i + " ");
        }
        List<Integer> dedup = new ArrayList<>();
        System.out.println();
        for (Integer i : allPossibleValues) { // de-duplicate
            if (!dedup.contains(i)) {
                dedup.add(i);
            }
        }
        int max = Integer.MIN_VALUE;
//        for (Integer i : dedup) {
//            System.out.print(i + " ");
//        }
        for (Integer i : dedup) {
            if (i > max && i <= 21) {
                max = i;
            }
        }
        System.out.print(max);
    }

    private static void dfs(List<Integer> allPossibleValues, List<Card> aces, int res, int level, int lastLevelAddition) {
        // base case
        if (level == aces.size()) {
            allPossibleValues.add(res);
            // res -= lastLevelAddition;
            return;
        }

        // add 1
        int one = aces.get(level).getCardValue().getValue1();
        res += one;
        dfs(allPossibleValues, aces, res, level + 1, one);

        res -= one;
        // add 11
        int eleven = aces.get(level).getCardValue().getValue2();
        res += eleven;
        dfs(allPossibleValues, aces, res, level + 1, eleven);
        res -= eleven;
    }
}
