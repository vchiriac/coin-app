package org.eu.coin.main;

import org.apache.commons.cli.*;
import org.eu.coin.engine.CoinEngine;
import org.eu.coin.engine.PrintUtils;


public class MainApp {
    public static void main(String[] args) {

        Options options = new Options();

        Option coinInput = new Option("c", "coins", true, "input available coins");
        coinInput.setRequired(true);
        options.addOption(coinInput);

        Option targetInput = new Option("a", "amount", true, "input target amount");
        targetInput.setRequired(true);
        options.addOption(targetInput);


        CommandLine cmd;
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("java -jar coin-app.jar", options);

            System.exit(1);
            return;
        }

        String[] inputCoins = cmd.getOptionValue("coins").split(",");
        Integer[] coins = new Integer[inputCoins.length];

        for (int i = 0; i < inputCoins.length; i++) {
            coins[i] = Integer.parseInt(inputCoins[i]);
        }

        int targetAmount = Integer.parseInt(cmd.getOptionValue("amount"));


        CoinEngine coinEngine = new CoinEngine();
        PrintUtils.print(coinEngine.calculate(coins, targetAmount));

    }

}
