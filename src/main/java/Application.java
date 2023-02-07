package main.java;
import main.java.animals.Kotik;

public class Application {
    public static void main(String[] args)
    {
        Kotik kot1 = new Kotik("Maxim", "MeowMeow", 6, 3);
        Kotik kot2 = new Kotik();
        kot2.setName("Pers");
        kot2.setVoice("Meow");
        kot2.setWeight(2);
        kot2.setSatiety(2);

        for (String i: kot1.liveAnotherDay()
             ) {
            System.out.println(i);
        }

        System.out.printf("Котик по имени \"%s\"  обладает вес = \"%d\"\n", kot2.getName(), kot2.getWeight());
        System.out.println("Котики разговаривают одинаково? " + compareVoice(new Kotik[]{kot1, kot2}));
        System.out.println("Количество котиков = " + Kotik.getCount());
        
    }
    static boolean compareVoice(Kotik[] cats)
    {
        for (int i = 0; i < cats.length - 1; i++) {
            if (cats[i].getVoice().compareTo(cats[i+1].getVoice()) != 0)
                return false;
        }
        return  true;
    }
}
