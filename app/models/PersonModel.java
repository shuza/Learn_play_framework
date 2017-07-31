package models;

import com.avaje.ebean.Model;
import com.eclipsesource.json.JsonObject;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonModel extends Model {

    @Id
    public String name;
    public int age;
    public String address;

    public PersonModel() {
        name = "no-name";
        age = -1;
        address = "no-address";
    }

    public PersonModel(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.add("name", name);
        obj.add("age", age);
        obj.add("address", address);
        return obj;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}
