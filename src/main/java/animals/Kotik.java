package main.java.animals;

import java.util.Arrays;

public class Kotik {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name имеет пустое значение");
        }
        this.name = name;
    }

    private String voice;
    public String getVoice() {
        return voice;
    }
    public void setVoice(String voice) {
        if (voice == null || voice.isEmpty()) {
            throw new IllegalArgumentException("Voice имеет пустое значение");
        }
        this.voice = voice;
    }

    private int satiety;
    public int getSatiety() {
        return satiety;
    }
    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    private int weight;
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight <=0 ) {
            throw new IllegalArgumentException("Значение Weight должно быть > 0");
        }
        this.weight = weight;
    }

    private static int count = 0;
    public static int getCount() {
        return count;
    }

    private static final int METHODS = 5;

    private boolean IsSatiety()
    {
        return satiety > 0;
    }
    public  Kotik()
    {
        this("JoeDou","Meow",1,1);
    }
    public  Kotik(String name, String voice, int satiety, int weight)
    {
        setName(name);
        setVoice(voice);
        setSatiety(satiety);
        setWeight(weight);
        count++;
    }

    public boolean play()
    {
        if (IsSatiety()) {
            System.out.printf("Котик %s играет\n", name);
            satiety--;
            return true;
        }
        else {
            System.out.printf("Котик %s ГОЛОДНЫЙ!!!\n", name);
            return false;
        }
    }

    public boolean sleep()
    {
        if (IsSatiety()) {
            System.out.printf("Котик %s спит\n", name);
            satiety--;
            return true;
        }
        else {
            System.out.printf("Котик %s ГОЛОДНЫЙ!!!\n", name);
            return false;
        }
    }

    public boolean wash()
    {
        if (IsSatiety()) {
            System.out.printf("Котик %s умывается\n", name);
            satiety--;
            return true;
        }
        else {
            System.out.printf("Котик %s ГОЛОДНЫЙ!!!\n", name);
            return false;
        }
    }

    public boolean walk()
    {
        if (IsSatiety()) {
            System.out.printf("Котик %s гуляет\n", name);
            satiety--;
            return true;
        }
        else {
            System.out.printf("Котик %s ГОЛОДНЫЙ!!!\n", name);
            return false;
        }
    }

    public boolean hunt()
    {
        if (IsSatiety()) {
            System.out.printf("Котик %s охотится\n", name);
            satiety--;
            return true;
        }
        else {
            System.out.printf("Котик %s ГОЛОДНЫЙ!!!\n", name);
            return false;
        }
    }

    public void eat()
    {
        this.eat(3);
    }

    public void eat(int n)
    {
        this.eat(n, "Загадка");
    }

    public void eat(int n, String dish)
    {
        satiety+=n;
        System.out.printf("Котик сьел %d вкусняшек \"%s\" ГОЛОДНЫЙ!!!\n", n, name);
    }

    public String[] liveAnotherDay()
    {
        int choose = 0;
        String[] arr = new String[24];
        for (int i = 0; i < arr.length; i++) {
            choose = (int) (Math.random() * METHODS) + 1;
            System.out.printf("%d - ", i);
            switch (choose) {
                case 1 -> {
                    if (play()) {
                        arr[i] = String.format(i + " - играл");
                    } else {
                        eat();
                        arr[i] = String.format(i + " - ел");
                    }
                }
                case 2 -> {
                    if (sleep()) {
                        arr[i] = String.format(i + " - спал");
                    } else {
                        eat();
                        arr[i] = String.format(i + " - ел");
                    }
                }
                case 3 -> {
                    if (wash()) {
                        arr[i] = String.format(i + " - умывался");
                    } else {
                        eat();
                        arr[i] = String.format(i + " - ел");
                    }
                }
                case 4 -> {
                    if (walk()) {
                        arr[i] = String.format(i + " - гулял");
                    } else {
                        eat();
                        arr[i] = String.format(i + " - ел");
                    }
                }
                case 5 -> {
                    if (hunt()) {
                        arr[i] = String.format(i + " - охотился");
                    } else {
                        eat();
                        arr[i] = String.format(i + " - ел");
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + choose);
            }
        }
        return arr;
    }
}
