package controllers;


import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DBController {
    private static DBController dbController;
    private Datastore datastore;

    public DBController() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");

        datastore = morphia.createDatastore(new MongoClient("localhost", 27017), "my_db");
    }

    public static DBController getInstance(){
        if (dbController == null){
            dbController = new DBController();
        }
        return dbController;
    }

    public Datastore getDatastore() {
        return datastore;
    }
}
