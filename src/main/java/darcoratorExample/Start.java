package darcoratorExample;

public class Start {
    public static void main(String[] args) {
        Human Andy = new KindChild();
        Human Mike  = new Teenager(new KindChild());
        Human Lucy  = new Teenager(new EvilChild());

        Human Tom  = new Adult(new Teenager(new KindChild()));
        Human Sam  = new Adult(new KindChild());

        System.out.println(Andy.say());
        System.out.println(Mike.say());
        System.out.println(Lucy.say());

        System.out.println(Tom.say());
        System.out.println(Sam.say());


    }
}
