package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public interface Numerical {
    int getDigit(int index) throws IndexOutOfBoundsException;
    int getLength();
}