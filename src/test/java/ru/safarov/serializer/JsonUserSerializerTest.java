package ru.safarov.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JsonUserSerializerTest {

    @Test
    void serializer() {
        UserCollections userCollections = prepareTestData();
        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        jsonUserSerializer.serializer(userCollections,"data.json");
        Assertions.assertTrue(new File("data.json").exists());

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
        userCollection.setUsersCollection(user1);
        userCollection.setUsersCollection(user2);
        return userCollection;
    }
}