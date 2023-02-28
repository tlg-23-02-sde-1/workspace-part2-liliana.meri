package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television>{
    //fields
    private String brand;
    private int volume;

    // Television HAS-A Tuner
    private Tuner tuner = new Tuner(); // instantiate internally

    // ctors
    public Television(){
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }


    // methods
    public int getCurrentChannel() {
     return tuner.getChannel(); // delegate to Tuner object to return channel
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel); // deledate to Tuner object to pass channel
    }


    // accessor methods
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

    /*@Override
    public boolean equals(Object obj) {
        // same physical object => return true;
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Television that = (Television) obj;
        return getVolume() == that.getVolume() &&
                Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }*/

    @Override
    public int hashCode(){
        // 'hash collision' when diff objects have same hashCode
        // this is a poorly written hash function, easily results in hash collisions
        // return getBrand().length() + getVolume();

        // we can use java.util.Objects to create a 'scientifically correct' hash function,
        // i.e., one that minimizes the probability of hash collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;

        // proceed if 'obj' is reference of Television object
        if(this.getClass() == obj.getClass()) {
            // downcast => to more specific type 'Television', for specific methods //
            Television other = (Television) obj;

            // checks => brand(String comparison), volume( == on primitive int)
            result = Objects.equals(this.getBrand(), other.getBrand()) && // null safe-check
                    this.getVolume() == other.getVolume(); // int can't be null
        }
        return result;
    }

    @Override
    public int compareTo(Television other) {
        return this.getBrand().compareTo(other.getBrand());
    }

    // to String
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": brand=" + getBrand() +
                ", volume=" + getVolume() +
                ", currentChannel=" + getCurrentChannel();
    }
}