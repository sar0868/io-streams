package ru.safarov.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.safarov.model.UserCollections;
import java.io.File;
import java.io.IOException;

public class XmlUserSerializer implements UserSerializer{

    public void serializer(UserCollections userCollections, String filename) {

        ObjectMapper objectMapper = new XmlMapper();
        File out = new File(filename);
        try {
            objectMapper.writerFor(UserCollections.class).writeValue(out, userCollections);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
