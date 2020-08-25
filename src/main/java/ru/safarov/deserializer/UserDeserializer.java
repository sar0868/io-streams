package ru.safarov.deserializer;

import ru.safarov.model.UserCollections;

import java.io.IOException;

public interface UserDeserializer {

    public UserCollections deserialize(String filename);


}
