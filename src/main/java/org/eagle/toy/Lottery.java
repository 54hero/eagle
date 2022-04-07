package org.eagle.toy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ljj
 */
@SuppressWarnings("all")
public class Lottery<T> {

    Logger logger = LoggerFactory.getLogger(Lottery.class);

    Random random = new Random();

    List<T> prizePool = new ArrayList<>();

    boolean addPrize(T prize) {
        return prizePool.add(prize);
    }

    T getPrize() {
        if (0 == prizePool.size()) {
            System.out.println("奖品没了，下次赶早！！！");
            logger.info("奖品没了，下次赶早！！！");
            return null;
        }

        final int index = random.nextInt(prizePool.size());
        final T t = prizePool.get(index);
        prizePool.remove(index);
        return t;
    }

    public static void main(String[] args) {
        Lottery<String> lottery = new Lottery<>();
        lottery.addPrize("手机");
        lottery.addPrize("电脑");
        lottery.addPrize("吹风机");
        lottery.addPrize("电视");

        for (int i = 0; i < 6; i++) {
            final String prize = lottery.getPrize();

            if (prize != null) {
                System.out.println("恭喜！您获得的奖品是：" + prize);
            }
        }
    }
}
