package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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
        return ok("hellow play framework");
    }

    public Result welcome(String name, int age) {
        return ok(welcome.render(name, age));
    }

    public Result testJsonPost() {
        JsonNode obj = request().body().asJson();
        return ok(obj.toString());
    }

}
