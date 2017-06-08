package org.eu.coin;

import org.eu.coin.engine.CoinEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinEngineTest {

    private CoinEngine coinEngine;

    @Before
    public void setUp() throws Exception {
        coinEngine = new CoinEngine();
    }

    @Test
    public void tescCalculateCombinations() throws Exception {
        Integer[] coins = new Integer[]{1, 1, 1, 1, 2, 3};
        int targetAmount = 4;
        Set<List<Integer>> solutionSet = coinEngine.calculate(coins, targetAmount);
        Assert.assertNotNull(solutionSet);
        Assert.assertEquals(3,solutionSet.size());
    }

}
