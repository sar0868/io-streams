package ru.safarov.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.safarov.model.UserCollections;

import java.io.File;
import java.io.IOException;

public class JsonUserSerializer implements UserSerializer{


    public void serializer(UserCollections userCollections, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        File out = new File(filename);
        try {
            objectMapper.writerFor(UserCollections.class).writeValue(out, userCollections);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
