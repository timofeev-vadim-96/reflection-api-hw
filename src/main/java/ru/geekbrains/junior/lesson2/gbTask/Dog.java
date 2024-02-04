package ru.geekbrains.junior.lesson2.gbTask;

public class Dog extends Animal{
    private String breed;

    private Dog(String breed, String name, int age) {
        this.breed = breed;
        this.name = name;
        this.age = age;
    }

    private void chewingBone(){
        System.out.printf("%s is chewing on a bone\n", name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
