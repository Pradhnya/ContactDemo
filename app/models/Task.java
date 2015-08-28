package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Task extends Model{

    private static List<Task> tasks;

    @Id
    public Long id;
    @Constraints.Required
    public String name;

    public static Finder<Long,Task> find = new Finder(
            Long.class, Task.class
    );

    public Task()
    {}

    public Task(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public static List<Task> all() {
        return find.all();
    }

    public static void create(Task task) {
        task.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();

    }



}
