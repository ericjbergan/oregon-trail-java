package ericb.oregontrail;

import java.io.PrintStream;

public class GameInputOutput {
    private final PrintStream out;

    public GameInputOutput(PrintStream out) {
        this.out = out;
    }

    public void printInstructions() {
        out.println("""
                This program simulates a trip over the Oregon Trail from Independence, Missouri to Oregon\s
                City, Oregon in 1847. Your family of five will cover the 2040 mile Oregon Trail in 5-6 months ---\s
                if you make it alive.""");
        Game.pressEnterToContinue();
        out.println("""
                \nYou had saved $900 to spend for the trip, and you've just paid $200 for a wagon. You will
                need to spend the rest of your money on the following items:""");
        out.println("""
                \nOxen - You can spend $200-$300 on your team. the more you spend, the faster you'll go because you
                have better animals""");
        out.println("""
                \nFood - The more you have, the less chance there is of getting sick""");
        out.println("""
                \nAmmunition - $1 buys a belt of 50 bullets. You will need bullets for attacks by animals and
                bandits, and for hunting food""");
        out.println("""
                \nClothing - This is especially important for the cold weather you will encounter when crossing
                the mountains""");
        out.println("""
                \nMiscellaneous supplies - This includes medicine and other things you will need for sickness
                and emergency repairs""");

        Game.pressEnterToContinue();

        out.println("""
                You can spend all your money before you start your trip - or you can save some of your\s
                cash to spend at forts along the way when you run low. However, items cost more at the forts. You \s
                can also go hunting along the way to get more food.""");
        out.println("""
                \nWhenever you have to use your trusty rifle along the way, you will be told to type in \s
                a word (one that sounds like a gun shot). The faster you type in that word and hit the 'enter' \s
                key, the better luck you'll have with your gun.""");
        out.println("""
                \nAt each turn, all items are shown in dollar amounts except bullets. When asked to enter\s
                money amounts, don't use a '$'""");

        Game.pressEnterToContinue();
    }
}
