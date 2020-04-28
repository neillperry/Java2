package com.entertainment;

import java.sql.SQLOutput;
import java.util.Objects;

public class Television implements Comparable<Television> {
    // STATIC VARIABLES
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_UNSAFE_CHANNEL = 500;
    public static final int MAX_UNSAFE_CHANNEL = 599;

    // INSTANCE VARIABLES
    private String brand;
    private int volume;
    private Tuner tuner =  new Tuner();
    private DisplayType display;
    private boolean parentalControl = false;

    // CONSTRUCTORS
    public Television(){};

    public Television(String brand){
        setBrand(brand);
    }

    public Television(int volume) throws IllegalArgumentException {
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

    public void changeChannel(int channel) throws InvalidChannelException,ChannelDisallowedException {
        if (!(isChannelSafe(channel)) && isParentalControlOn()) {
            throw new ChannelDisallowedException("Channels blocked by parental control");
        } else if (channel < 0) {
            throw new InvalidChannelException("Invalid channel " + channel);
        } else {
            tuner.setChannel(channel);
        }
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

    public void setVolume(int volume) throws IllegalArgumentException {
        if (MIN_VOLUME <= volume && volume <= MAX_VOLUME) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Invalid volume " + volume);
        }
    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    public boolean isParentalControlOn() {
        return parentalControl;
    }

    public void setParentalControl() throws InvalidChannelException,ChannelDisallowedException {
        // check to see if Parental Control is enabled
        if (isParentalControlOn()) {
            // if so, disable it
            disableParentalControl();
        // otherwise, enable it
        } else {
            // first, check to see if current channel is blocked
            if (!isChannelSafe(getCurrentChannel())) {
                // if current channel is blocked, tune the TV to a safe channel
                this.changeChannel(1);
            }
            // after ensuring current channel is safe, enable Parental control
            enableParentalControl();
        }
    }

    private void enableParentalControl() {
        this.parentalControl = true;
    }

    private void disableParentalControl() {
        this.parentalControl = false;
    }


    private boolean isChannelSafe(int channel) {
        if (MIN_UNSAFE_CHANNEL <= channel && channel <= MAX_UNSAFE_CHANNEL) {
            return false;
        } else {
            return true;
        }
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
