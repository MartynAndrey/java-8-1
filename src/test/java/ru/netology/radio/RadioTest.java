package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetCurrentStationBelowTheLowerBound() {
        Radio radioman = new Radio();
        int expected = 0;

        radioman.setCurrentStation(-2);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationEqualToTheLowerBound() {
        Radio radioman = new Radio();
        int expected = 0;

        radioman.setCurrentStation(0);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationInTheBounds() {
        Radio radioman = new Radio();
        int expected = 3;

        radioman.setCurrentStation(3);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationEqualToTheUpperBound() {
        Radio radioman = new Radio();
        int expected = 9;

        radioman.setCurrentStation(9);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationAboveTheUpperBound() {
        Radio radioman = new Radio();
        int expected = 0;

        radioman.setCurrentStation(11);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationInTheBounds() {
        Radio radioman = new Radio();
        radioman.setCurrentStation(3);
        int expected = 4;

        radioman.nextStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationAboveTheUpperBound() {
        Radio radioman = new Radio();
        radioman.setCurrentStation(9);
        int expected = 0;

        radioman.nextStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationInTheBounds() {
        Radio radioman = new Radio();
        radioman.setCurrentStation(7);
        int expected = 6;

        radioman.prevStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationBelowTheLowerBound() {
        Radio radioman = new Radio();
        radioman.setCurrentStation(0);
        int expected = 9;

        radioman.prevStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeBelowTheUpperBound() {
        Radio radioman = new Radio();
        int expected = 4;

        for (int i = 1; i < 5; i++) {
            radioman.increaseVolume();
        }
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeAboveTheUpperBound() {
        Radio radioman = new Radio();
        int expected = 10;

        for (int i = 1; i < 13; i++) {
            radioman.increaseVolume();
        }
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReduceVolumeAboveTheLowerBound() {
        Radio radioman = new Radio();
        for (int i = 1; i < 6; i++) {
            radioman.increaseVolume();
        }

        int expected = 1;

        for (int i = 1; i < 5; i++) {
            radioman.reduceVolume();
        }
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReduceVolumeBelowTheLowerBound() {
        Radio radioman = new Radio();
        for (int i = 1; i < 3; i++) {
            radioman.increaseVolume();
        }

        int expected = 0;

        for (int i = 1; i < 6; i++) {
            radioman.reduceVolume();
        }
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

}