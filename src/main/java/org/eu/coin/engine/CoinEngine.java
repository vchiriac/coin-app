package org.eu.coin.engine;

import java.util.*;


public class CoinEngine {

    private Set<List<Integer>> solutionSet = new HashSet<>();

    public Set<List<Integer>> calculate(Integer[] coins, int targetAmount) {
        List<Integer> list = new ArrayList<>(Arrays.asList(coins));
        List<Integer> subset = new ArrayList<>();

        calculate_recursive(list, targetAmount, subset);
        return solutionSet;
    }

    private void calculate_recursive(List<Integer> coinList, int givenAmount, List<Integer> coinSubset) {
        int sum = 0;

        for (int coin : coinSubset) {
            sum += coin;
        }

        if (sum == givenAmount) {
            solutionSet.add(coinSubset);
        }

        if (sum >= givenAmount) return;

        for (int i = 0; i < coinList.size(); i++) {

            List<Integer> remainingList = new ArrayList<>();

            int n = coinList.get(i);

            for (int j = i + 1; j < coinList.size(); j++) {
                remainingList.add(coinList.get(j));
            }

            List<Integer> coinSubsetRec = new ArrayList<>(coinSubset);
            coinSubsetRec.add(n);
            calculate_recursive(remainingList, givenAmount, coinSubsetRec);
        }
    }


}
