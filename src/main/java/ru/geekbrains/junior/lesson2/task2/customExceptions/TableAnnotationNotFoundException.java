package ru.geekbrains.junior.lesson2.task2.customExceptions;

public class TableAnnotationNotFoundException extends Exception{
    public TableAnnotationNotFoundException() {
        super("An annotation defining the relationship of a class to a specific table was not found");
    }
}
