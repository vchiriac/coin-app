package org.eu.coin;

import org.eu.coin.engine.CoinEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinEngineTest {

    private CoinEngine coinEngine;

    @Before
    public void setUp() throws Exception {
        coinEngine = new CoinEngine();
    }

    @Test
    public void testValidCurrency() throws Exception {
        Integer[] coins = new Integer[]{1, 1, 1, 1, 2, 3};
        int targetAmount = 4;
        Assert.assertNotNull(coinEngine.calculate(coins, targetAmount));
    }

}
