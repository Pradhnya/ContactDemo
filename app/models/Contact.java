package models;
import play.db.ebean.Model;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Contact extends Model{

    public String name;
    public String email;
    public Long number;
    public String message;
    public String sex;
    public Integer salary;
    public Integer age;

    public static Model.Finder<Long, Contact> find =
            new Model.Finder<Long, Contact>(Long.class, Contact.class);


    private static List<Contact> contacts;

    public Contact() {
        // Left empty
        this.name = "Pradhnya";
        this.email = "pradhnya@gmail.com";
        this.number = 8983504207L;
        this.message = "Message";
        this.sex = "Female";
        this.salary = 10000;
        this.age = 22;
    }

    public Contact(String name, String email,Long number, String message, String sex, Integer salary, Integer age) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.message = message;
        this.sex = sex;
        this.salary = salary;
        this.age = age;
    }
}
