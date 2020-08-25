package ru.safarov.deserializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

class UserDeserializerTest {

    @Test
    void JsonDeserializeTest() {
        UserCollections users = new UserCollections();
        JsonUserDeserializer jsonUserDeserializer = new JsonUserDeserializer();
        users = jsonUserDeserializer.deserialize("data.json");
        Assertions.assertEquals(2, users.getUsers().size());
        for (User user: users.getUsers()) {
            if(user.getId() == 2){
                Assertions.assertEquals("Irina", user.getName());
            }
        }
    }

    @Test
    void XmlDeserializeTest() {
        UserCollections users = new UserCollections();
        XmlUserDeserializer xmlUserDeserializer = new XmlUserDeserializer();
        users = xmlUserDeserializer.deserialize("data.xml");
        Assertions.assertEquals(2, users.getUsers().size());
        for (User user: users.getUsers()) {
            if(user.getId() == 2){
                Assertions.assertEquals("Irina", user.getName());
            }
        }
    }
}