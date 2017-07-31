package daos;

import com.avaje.ebean.Finder;
import models.PersonModel;

import java.util.List;

public class PersonaDao {
    private static PersonaDao personaDao;
    private Finder<String, PersonModel> finder;

    public PersonaDao() {
        finder = new Finder<String, PersonModel>(PersonModel.class);
    }

    public static PersonaDao getInstance() {
        if (personaDao == null) {
            personaDao = new PersonaDao();
        }
        return personaDao;
    }

    public boolean createPerson(PersonModel model) {
        try {
            model.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePreson(PersonModel model) {
        try {
            model.update();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PersonModel> getPersons() {
        return finder.all();
    }
}
