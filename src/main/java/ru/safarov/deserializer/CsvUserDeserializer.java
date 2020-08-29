package ru.safarov.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.ibm.java.diagnostics.utils.plugins.Entry;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CsvUserDeserializer implements UserDeserializer {

    public UserCollections deserialize(String filename){

        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        CsvSchema schema = mapper.schemaFor(User.class).withHeader();
        schema = schema.withColumnSeparator(';');
        File csvFile = new File(filename);
        UserCollections userCollection = new UserCollections();
        userCollection.setUsers(new ArrayList<User>());
        MappingIterator<User> it = null;
        try {
            it = mapper.readerFor(User.class).with(schema).readValues(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!it.hasNextValue()) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = null;
            try {
                user = it.nextValue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            userCollection.getUsers().add(user);
        }

        return userCollection;
    }
}
