package darcoratorExample;

public class ChildDecorator implements Human{

    protected Human baby;

    public ChildDecorator(Human baby) {
        this.baby = baby;
    }

    @Override
    public String say() {
       return baby.say();
    }
}
