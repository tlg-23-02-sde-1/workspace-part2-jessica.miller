package com.entertainment;

import java.util.Comparator;

//Needed for a TreeSet implementation. Obligated to break the tie...
public class TelevisionBrandChannelComparator implements Comparator<Television> {
    @Override
    public int compare(Television t1, Television t2) {
        int result = t1.getBrand().compareTo(t2.getBrand());

        if (result == 0) {
            result = Integer.compare(t1.getCurrentChannel(),
                    t2.getCurrentChannel());
        }
        return result;
    }
}