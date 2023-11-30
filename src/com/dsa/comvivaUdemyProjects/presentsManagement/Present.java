package com.dsa.comvivaUdemyProjects.presentsManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class Present {
    ArrayList<Sweet> presents;
//src/com/itbulls/learnit/javacore/oop/exam/templates/onlineshop
    Present() {
        presents = new ArrayList<>();
    }

    public void addSweet(Sweet sweet) {
        if (sweet!= null)
            presents.add(sweet);
    }

    public double calculateTotalWeight() {
        double total = 0.0;
        for (Sweet sw : presents) {
            total += sw.weight;
        }
        return total;
    }

    public Sweet[] filterSweetsBySugarRange(double minSugarWeight,
                                            double maxSugarWeight) {
        ArrayList<Sweet> filter = new ArrayList<>();

        for (Sweet swt : presents) {
            if (swt.sugarWeight >= minSugarWeight && swt.sugarWeight <= maxSugarWeight) {
                filter.add(swt);
            }
        }

        return filter.toArray(Sweet[]::new);
    }

    public Sweet[] getSweets() {
        return presents.toArray(Sweet[]::new);
    }

}
