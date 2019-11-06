import com.sbt.javashool.rnd.Person;

public class main {
    public static void main(String[] args) {

        Person person1 = new Person(Person.GenderState.MAN, "Ivan");
        Person person2 = new Person(Person.GenderState.WOMAN, "Masha");
        Person person3 = new Person(Person.GenderState.MAN, "Vova");
        Person person4 = new Person(Person.GenderState.WOMAN, "Rita");
        Person person5 = new Person(Person.GenderState.WOMAN, "Dasha");

        person1.marry(person2);

        person3.marry(person4);

    }
}
