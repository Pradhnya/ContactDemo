package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result newContact()
    {
        return ok(views.html.contacts.form.render(form(Contacts.class)));
    }

}
