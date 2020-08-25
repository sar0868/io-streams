package ru.safarov.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.safarov.model.UserCollections;

import java.io.File;
import java.io.IOException;

public class XmlUserDeserializer implements UserDeserializer {

    public UserCollections deserialize(String filename){

        ObjectMapper objectMapper = new XmlMapper();
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
