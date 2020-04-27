package com.entertainment;

public class Television {
    // instance fields
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

    public Television(int volume, String brand){
        setBrand(brand);
        setVolume(volume);
    }

    //TO STRING METHOD
    public String toString() {
        return getClass().getSimpleName() + " [brand="
+ getBrand() + ", volume= " + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";}


    // BUSINESS METHODS
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }


    // GETTORS and SETTORS
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
}
