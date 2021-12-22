package darcoratorExample;

public class Teenager extends ChildDecorator {
    public Teenager(Human baby) {
        super(baby);
    }

    public String read(){
        return ". I can read";
    }

    @Override
    public String say() {
        return super.say() + read();
    }
}
