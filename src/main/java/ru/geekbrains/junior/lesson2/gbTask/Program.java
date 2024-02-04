package ru.geekbrains.junior.lesson2.gbTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Program {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<?> catClass = Cat.class;
        Constructor<?>[] catConstructors = catClass.getDeclaredConstructors();
        catConstructors[0].setAccessible(true);
        Object cat = catConstructors[0].newInstance("black", "Barsik", 3);

        Class<?> dogClass = Dog.class;
        Constructor<?>[] dogConstructors = dogClass.getDeclaredConstructors();
        dogConstructors[0].setAccessible(true);
        Object dog = dogConstructors[0].newInstance("boxer", "Muhtar", 3);

        Animal[] animals = {(Animal) cat, (Animal) dog};

        for (Animal animal: animals){
            Class<?> clazz = animal.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();

            Map<String, String> fieldsWithValues = new HashMap<>();

            for (Field field: fields){
                field.setAccessible(true);
                fieldsWithValues.put(field.getName(), field.get(animal).toString());
            }

            Field[] animalFields = Animal.class.getDeclaredFields();
            for (Field field: animalFields){
                field.setAccessible(true);
                fieldsWithValues.put(field.getName(), field.get(animal).toString());
            }

            System.out.println(
                    "INFO about " + animal +
                    "\nmethods: " + Arrays.toString(methods) +
                    ", \nconstructors: " + Arrays.toString(constructors) +
                    ", \nfields" + fieldsWithValues);

            if (animal instanceof Cat){
                Method makeSound = clazz.getDeclaredMethod("makeSound");
                makeSound.setAccessible(true);
                makeSound.invoke(animal);
            }
        }
    }
}
