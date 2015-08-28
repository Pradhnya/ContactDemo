package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;
import java.util.List;

public class Contacts extends Controller{

    private static List<Contact> contacts;


    private static final Form<Contact> contactForm = Form
            .form(Contact.class);

    public static Result save()
    {
        Form<Contact> boundForm = contactForm.bindFromRequest();
        Contact contact = boundForm.get();
        //contact.save();--OR--
        Ebean.save(contact);

        return ok(String.format("Saved Contact Details", contact));
    }

    public static Result getContact() {
        //List<Contact> c = Contact.find.all();
        //List<Contact> searchedContacts = Contact.find.where().like("sex", "%M%").findList();

        //int searchedContacts = Contact.find.findRowCount();
        //val firstContact=SQL("Select count(*) from contact");
        //return ok(Json.toJson(c.get(1).email));

        int searchedContactsMale = Contact.find.where().like("sex", "%M%").findRowCount();
        int searchedContactsFemale = Contact.find.where().like("sex", "%F%").findRowCount();

        /*Contact sexRatio = new Contact();
        return ok(Json.toJson(searchedContactsMale));*/

       /* GenderStat genderStat = new GenderStat();
        genderStat.setFemale(searchedContactsFemale);
        genderStat.setMale(searchedContactsMale);*/

        /*JSONArray list = new JSONArray();
        list.add(genderStat);*/

        ObjectNode result = Json.newObject();
        result.put("Male", searchedContactsMale);
        result.put("Female", searchedContactsFemale);
        return ok(result);
    }

    /*public static Result getSalary() {

        List<Contact> sal = Contact.find.select("salary").findList();

        //List<Contact> salNew = Contact.find.findList().listIterator().add(sal);


       *//* final List<Contact> results = new ArrayList<Contact>();
        for (Contact sal : contacts) {
            if (sal.salary.intValue()) {
                results.get(sal);
            }
        }

        return results;*//*

        return ok(Json.toJson(sal));
    }*/

    /*public static Result getAge() {

        //List<Contact> age = Contact.find.select("age").findList();

        //List<Contact> a = new ArrayList<Contact>();

        //String sql = "select age from contact";

        //ResultSet result = statement.executeQuery(sql);

        List<Integer> ag = Contact.find.where().between("age",10,25);

        //List<Contact> a = new ArrayList<Contact>();
        //a.listIterator();

        return ok(Json.toJson(a));

    }*/

    public static Result getMessage() {

        int msgDelivered = Contact.find.where().like("message","Delivered").findRowCount();
        int msgNotDelivered = Contact.find.where().like("message","Not%").findRowCount();

        ObjectNode result = Json.newObject();
        result.put("Delivered", msgDelivered);
        result.put("Not_Delivered", msgNotDelivered);
        return ok(result);
    }

}
