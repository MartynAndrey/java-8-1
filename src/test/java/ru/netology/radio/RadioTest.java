package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetStationCountLessThanZero() {
        Radio radioman = new Radio(-3);
        int expected = 10;

        int actual = radioman.getStationCount();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetStationCountMoreThanZero() {
        Radio radioman = new Radio(15);
        int expected = 15;

        int actual = radioman.getStationCount();
        assertEquals(expected, actual);
    }

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
        Radio radioman = new Radio(15);
        int expected = 3;

        radioman.setCurrentStation(3);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationEqualToTheUpperBound() {
        Radio radioman = new Radio(15);
        int expected = 14;

        radioman.setCurrentStation(14);
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationAboveTheUpperBound() {
        Radio radioman = new Radio(5);
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
        Radio radioman = new Radio(8);
        radioman.setCurrentStation(7);
        int expected = 0;

        radioman.nextStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationInTheBounds() {
        Radio radioman = new Radio(9);
        radioman.setCurrentStation(7);
        int expected = 6;

        radioman.prevStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationBelowTheLowerBound() {
        Radio radioman = new Radio(14);
        radioman.setCurrentStation(0);
        int expected = 13;

        radioman.prevStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentVolumeBelowTheLowerBound() {
        Radio radioman = new Radio(5, -4);
        int expected = 0;

        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentVolumeAboveTheUpperBound() {
        Radio radioman = new Radio(5, 105);
        int expected = 0;

        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentVolumeInBounds() {
        Radio radioman = new Radio(5, 44);
        int expected = 44;

        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeBelowTheUpperBound() {
        Radio radioman = new Radio(5, 61);
        int expected = 64;

        radioman.increaseVolume();
        radioman.increaseVolume();
        radioman.increaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeAboveTheUpperBound() {
        Radio radioman = new Radio(5, 99);
        int expected = 100;

        radioman.increaseVolume();
        radioman.increaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReduceVolumeAboveTheLowerBound() {
        Radio radioman = new Radio(5, 42);
        int expected = 40;

        radioman.reduceVolume();
        radioman.reduceVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReduceVolumeBelowTheLowerBound() {
        Radio radioman = new Radio(-5, 1);
        int expected = 0;

        radioman.reduceVolume();
        radioman.reduceVolume();
        radioman.reduceVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }
}