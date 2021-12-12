package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationCount = 10;
    final int volumeLimit = 100;

    public Radio() {}

    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        }
    }

    public Radio(int stationCount, int currentVolume) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        }
        if (0 <= currentVolume && currentVolume <= volumeLimit) {
            this.currentVolume = currentVolume;
        }
    }

    public int getStationCount () {
        return this.stationCount;
    }

    public int getCurrentStation () {
        return this.currentStation;
    }

    public void setCurrentStation (int station) {
        if (station < 0) {
            return;
        }
        if (station >= this.stationCount) {
            return;
        }
        this.currentStation = station;
    }

    public void nextStation() {
        if (this.currentStation == this.stationCount - 1) {
            this.currentStation = 0;
        }
        else {
            this.currentStation++;
        }
    }

    public void prevStation() {
        if (this.currentStation == 0) {
            this.currentStation = this.stationCount - 1;
        }
        else {
            this.currentStation--;
        }
    }

    public int getCurrentVolume () {
        return this.currentVolume;
    }

    public void increaseVolume() {
        if (this.currentVolume < this.volumeLimit) {
            currentVolume++;
        }
    }

    public void reduceVolume() {
        if (this.currentVolume > 0) {
            this.currentVolume--;
        }
    }

}