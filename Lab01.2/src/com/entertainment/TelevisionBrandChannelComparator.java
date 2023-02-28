package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        int result = tv1.getBrand().compareTo(tv2.getBrand()); // brand is already comparable

        if (result == 0) {
            //tie on brand => reassign new comparison to break tie
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}