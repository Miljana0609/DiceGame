package se.jensen.miljana.dicegame;

import java.util.Random;

public class Dice {
    private static Random random = new Random();

    public int roll() {
        return random.nextInt(1, 7);
    }
}
