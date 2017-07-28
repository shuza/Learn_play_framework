package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.PersonModel;
import play.mvc.*;
import scala.util.parsing.json.JSONObject;
import views.html.home.welcome;

/**
 * b
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("hello play this is to test");
    }

    public Result welcome(String name, int age) {
        return ok(welcome.render(name, age));
    }

    public Result testJsonPost() {
        JsonNode obj = request().body().asJson();
        PersonModel model = new PersonModel();
        model.setName(obj.get("name").asText("no-name"));
        model.setAge(obj.get("age").asInt(-1));
        model.setAddress(obj.get("address").asText("no-address"));
        DBController.getInstance().getDatastore().save(model);
        return ok(obj.toString());
    }

}
