package ru.netology.radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    ////Для номера станции
    //Граничные значения для прямого вызова через номер станции
    @ParameterizedTest
    @CsvSource(value = {"below minimum, -1, 0",
            "minimum, 0, 0",
            "above minimum, 1, 1",
            "below maximum, 8, 8",
            "maximum, 9, 9",
            "above maximum, 10, 0"})
    void shouldLimitValuesForStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);

        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }
    //Граничные значения для кнопки "вперед"
    @ParameterizedTest
    @CsvSource(value = {"minimum, 0, 1",
            "below maximum, 8, 9",
            "maximum, 9, 0"})
    void shouldLimitValuesForSwitchNextStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);

        radio.next();

        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }
    //Граничные значения для кнопки "назад"
    @ParameterizedTest
    @CsvSource(value = {"minimum, 0, 9",
            "above minimum, 1, 0",
            "maximum, 9, 8"})
    void shouldLimitValuesForSwitchPrevStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);

        radio.prev();

        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    ////Для громкости:
    //Граничные значения для прямого указания громкости
    @ParameterizedTest
    @CsvSource(value = {"below minimum, -1, 0",
            "minimum, 0, 0",
            "above minimum, 1, 1",
            "below maximum, 9, 9",
            "maximum, 10, 10",
            "above maximum, 11, 0"})
    void shouldLimitValuesForVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    //Граничные значения для кнопки "+"
    @ParameterizedTest
    @CsvSource(value = {"minimum, 0, 1",
            "below maximum, 9, 10",
            "maximum, 10, 10"})
    void shouldLimitValuesForincreaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    //Граничные значения для кнопки "-"
    @ParameterizedTest
    @CsvSource(value = {"minimum, 0, 0",
            "above minimum, 1, 0",
            "maximum, 10, 9"})
    void shouldLimitValuesForDecreaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

}