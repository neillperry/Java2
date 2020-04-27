package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television> {
    // INSTANCE VARIABLES
    private String brand;
    private int volume;
    private Tuner tuner =  new Tuner();

    // CONSTRUCTORS
    public Television(){};

    public Television(String brand){
        setBrand(brand);
    }

    public Television(int volume){
        setVolume(volume);
    }

    public Television(String brand, int volume){
        setBrand(brand);
        setVolume(volume);
    }


    // BUSINESS METHODS
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }


    // ACCESSSOR METHODS
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

    //TO STRING METHOD
    public String toString() {
        return getClass().getSimpleName() +
                " [brand=" + getBrand() +
                ", volume= " + getVolume() +
                ", currentChannel=" + getCurrentChannel()
                + "]";}



    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    Objects.equals(this.getVolume(), other.getVolume());
        }

        return result;
        /*
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return volume == that.volume &&
                Objects.equals(brand, that.brand);

         */
    }

    @Override
    public int hashCode() {
        //return Objects.hash(brand, volume);
        return Objects.hash(getBrand(), getVolume());
    }


    public int compareTo(Television other){
        return this.getBrand().compareTo(other.getBrand());
    }
}
