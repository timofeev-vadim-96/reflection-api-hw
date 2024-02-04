package ru.geekbrains.junior.lesson2.gbTask;

public class Cat extends Animal{
    private String color;

    private Cat(String color, String name, int age) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    private void sharpClaws(){
        System.out.printf("%s is sharping it's claws\n", name);
    }

    private void makeSound(){
        System.out.println("Meowwww!!...");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
