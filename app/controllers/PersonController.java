package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.PersonModel;
import org.mongodb.morphia.query.Query;
import play.mvc.*;
import views.html.person.perconCreate;

import java.util.List;

public class PersonController extends Controller {

    public Result index() {
        return ok(perconCreate.render("shuza"));
    }

    public Result createPerson() {
        JsonNode obj = request().body().asJson();
        PersonModel model = new PersonModel();
        model.setName(obj.get("name").asText("no-name"));
        model.setAge(obj.get("age").asInt(-1));
        model.setAddress(obj.get("address").asText("no-address"));

        DBController.getInstance().getDatastore().save(model);


        return ok("person created");
    }

    public List<PersonModel> getPersonList() {
        Query<PersonModel> query = DBController.getInstance().getDatastore().createQuery(PersonModel.class);
        List<PersonModel> personModels = query.asList();
        return personModels;
    }

}
