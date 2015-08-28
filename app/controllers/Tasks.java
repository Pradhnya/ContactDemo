package controllers;

import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Tasks extends Controller{

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result tasks() {
        return ok(
                views.html.contacts.task.render(Task.all(), taskForm)
        );
    }

    public static Result createTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.contacts.task.render(Task.all(), filledForm)
            );
        } else {
            Task.create(filledForm.get());
            return redirect(routes.Tasks.tasks());
        }
    }

    public static Result deleteTask(Long id) {
        Task.delete(id);
        return redirect(routes.Tasks.tasks());
    }

}
