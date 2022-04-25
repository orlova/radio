package ru.netology.radio;

public class Radio {

    //Для номера станции:
    private int currentStation;

    public int getCurrentStation() {
        return currentStation;
    }
    public void setCurrentStation(int currentStation) {
        if (currentStation < 0) {
            return;
        }
        if (currentStation > 9) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void next() {
        if (currentStation == 9) {
            this.currentStation = 0; return;
        }
        setCurrentStation(currentStation + 1);
    }

    public void prev() {
        if (currentStation == 0) {
            this.currentStation = 9; return;
        }
        setCurrentStation(currentStation - 1);
    }

    //Для громкости:
    private int currentVolume;

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 10) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 10) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }

}
