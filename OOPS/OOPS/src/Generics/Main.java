package Generics;

public class Main implements GenericInterface<Integer> {

    @Override
    public void hello(Integer type) {
        // TODO Auto-generated method stub
        System.out.println(type);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.hello(35);
    }
}
