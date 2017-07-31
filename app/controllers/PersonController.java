package controllers;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import daos.PersonaDao;
import models.PersonModel;
import play.mvc.*;
import views.html.person.perconCreate;

import java.util.ArrayList;

public class PersonController extends Controller {

    public Result index(int id, String name) {
        return ok(perconCreate.render("shuza id: " + id + "\t name: " + name));
    }

    public Result createPerson() {
        JsonNode obj = request().body().asJson();
        PersonModel model = new PersonModel();
        model.setName(obj.get("name").asText("no-name"));
        model.setAge(obj.get("age").asInt(-1));
        model.setAddress(obj.get("address").asText("no-address"));

        String message = "person create fail";
        if (PersonaDao.getInstance().createPerson(model)) {
            message = "person create successfully";
        }

        return ok(message);
    }

    public Result getPersonList() {
        ArrayList<PersonModel> persons = new ArrayList<>(PersonaDao.getInstance().getPersons());
        JsonArray results = new JsonArray();
        for (int i = 0; i < persons.size(); i++) {
            results.add(persons.get(i).toJson());
        }
        return ok(results.toString());
    }

    public Result updatePerson() {
        JsonNode obj = request().body().asJson();
        PersonModel model = new PersonModel();
        model.setName(obj.get("name").asText("no"));
        model.setAge(obj.get("age").asInt(0));
        model.setAddress(obj.get("address").asText("no-add"));
        String message = "update failed";
        if (PersonaDao.getInstance().updatePreson(model)) {
            message = "update success";
        }

        return ok(message);
    }

}
