package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television> {
    // STATIC VARIABLES
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;

    // INSTANCE VARIABLES
    private String brand;
    private int volume;
    private Tuner tuner =  new Tuner();
    private DisplayType display;

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

    public Television(String brand, int volume, DisplayType display) {
        setBrand(brand);
        setVolume(volume);
        setDisplay(display);
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
        if (MIN_VOLUME <= this.volume && this.volume <= MAX_VOLUME) {
            this.volume = volume;
        }
    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    //TO STRING METHOD
    public String toString() {
        return getClass().getSimpleName() +
                " [brand=" + getBrand() +
                ", volume= " + getVolume() +
                ", display type=" + getDisplay() +
                ", currentChannel=" + getCurrentChannel()
                + "]";}



    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    Objects.equals(this.getVolume(), other.getVolume()) &&
                    Objects.equals(this.getBrand(), other.getBrand());
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
        return Objects.hash(getBrand(), getVolume(), getBrand());
    }


    public int compareTo(Television other){
        return this.getBrand().compareTo(other.getBrand());
    }
}
