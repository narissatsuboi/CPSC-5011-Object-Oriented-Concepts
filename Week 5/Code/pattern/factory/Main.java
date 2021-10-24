package pattern.factory;

public class Main {
    private Main() {}
    public static void main(String[] args) {
        Person p = PersonFactory.newPerson("Bob Jones","123456789");
        System.out.println(p);
    }
}
