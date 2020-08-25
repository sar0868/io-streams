package ru.safarov.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ru.safarov.model.UserCollections;

import java.io.*;

public class JsonUserDeserializer implements UserDeserializer {

    public UserCollections deserialize(String filename){

        ObjectMapper objectMapper = new JsonMapper();
        File in = new File(filename);
        Object obj = null;
        try {
            obj = objectMapper.readerFor(UserCollections.class).readValue(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserCollections userCollections = (UserCollections) obj;
        return userCollections;
    }
}
