package ericb.oregontrail;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        Game game = new Game();

        game.playGame();
    }

}