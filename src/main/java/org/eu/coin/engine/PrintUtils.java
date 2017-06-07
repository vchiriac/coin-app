package org.eu.coin.engine;

import java.util.List;
import java.util.Set;

public final class PrintUtils {
    public static void print(Set<List<Integer>> solutionSet) {
        if (!solutionSet.isEmpty()) {
            System.out.println("Possible solutions: " + solutionSet.size());
            int counter = 1;

            for (List<Integer> list : solutionSet) {
                System.out.println(counter + ". " + list.toString());
                counter++;
            }
        }
    }
}
