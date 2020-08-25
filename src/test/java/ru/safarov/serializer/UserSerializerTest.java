package ru.safarov.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserSerializerTest {

    @Test
    void JsonSerializerTest() {
        UserCollections userCollections = prepareTestData();
        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        jsonUserSerializer.serializer(userCollections,"data.json");
        Assertions.assertTrue(new File("data.json").exists());
    }

    @Test
    void XmlSerializerTest() {
        UserCollections userCollections = prepareTestData();
        XmlUserSerializer xmlUserSerializer = new XmlUserSerializer();
        xmlUserSerializer.serializer(userCollections,"data.xml");
        Assertions.assertTrue(new File("data.xml").exists());
    }

    @Test
    void ScvSerializerTest() {
        UserCollections userCollections = prepareTestData();
        CsvUserSerializer csvUserSerializer = new CsvUserSerializer();
        csvUserSerializer.serializer(userCollections,"data.csv");
        Assertions.assertTrue(new File("data.csv").exists());
    }

    private UserCollections prepareTestData() {
        UserCollections userCollection = new UserCollections();
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Ivan");
        user1.setEmail("ivan@mail.ru");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("Irina");
        user2.setEmail("irina@mail.ru");
        userCollection.setUsers(new ArrayList<User>());
        userCollection.getUsers().add(user1);
        userCollection.getUsers().add(user2);
        return userCollection;
    }
}