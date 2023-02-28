package com.entertainment;

import javax.xml.namespace.QName;
import java.util.Objects;

public class Television {
    private String brand;
    private int volume;

    private Tuner tuner = new Tuner();

    //constructor
    public Television(){

    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    public Television(String brand, int volume, Tuner tuner) {
        this(brand, volume);
        this.tuner = tuner;
    }


    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        //This is a poorly written hash function because it results in hash collisions.
        // A hash collision is when different objects (equals()) have the same hash code.
        return Objects.hash(getBrand(), getVolume()); //MINIMIZE HASH COLLISIONS
        /*WE CAN USE java.util.Objects*/
    }


    @Override // overriding equals method
    public boolean equals(Object obj) {
        boolean result = false;

        //proceed only if obj is a reference to Television object
        if (obj instanceof Television) {
            Television other = (Television) obj; // downcast to more specific type to call Television methods
            //Do the checks
            result = Objects.equals(this.getBrand(), other.getBrand()) && //null safe objects
                     this.getVolume() == other.getVolume();                // int can't be null
        }
        return result;
    }

    @Override //toString
    public String toString(){
        return getClass().getSimpleName() + " Brand= " + getBrand() +
                ", volume= " + getVolume() +
                ", current channel= " + getCurrentChannel();
    }

    //javabeans properties: brand(rw), volume(rw);
}