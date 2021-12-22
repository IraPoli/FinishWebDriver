package darcoratorExample;

public class Adult extends ChildDecorator{
    public Adult(Human baby) {
        super(baby);
    }

    public String introduce(){
        return ". Can I help you?";
    }

    @Override
    public String say() {
        return super.say() + introduce();
    }
}
