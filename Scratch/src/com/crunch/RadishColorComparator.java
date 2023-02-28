package com.crunch;

import java.util.Comparator;

//THIRD PARTY COMPARATOR(NOT A RADISH)
class RadishColorComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish r1, Radish r2) {
        return r1.getColor().compareTo(r2.getColor());
    }
}