package ru.safarov.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.io.*;
import java.util.ArrayList;

public class CsvUserDeserializer implements UserDeserializer {

    public UserCollections deserialize(String filename){

//        CsvSchema schema = CsvSchema.builder()
//                .addColumn("id", CsvSchema.ColumnType.NUMBER)
//                .addColumn("name")
//                .addColumn("email")
//                .build();
//        ObjectMapper objectMapper = new CsvMapper();
//        ObjectMapper enable = objectMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
//        File in = new File(filename);



        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        File csvFile = new File(filename);
        UserCollections userCollection = new UserCollections();
        userCollection.setUsers(new ArrayList<User>());
        MappingIterator<String[]> it = null;
        try {
            it = mapper.readerFor(String[].class).readValues(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (it.hasNext()) {
            String[] row = it.next();
            User user = new User();
            user.setId(Long.valueOf(row[0]));
            user.setName(row[1]);
            user.setEmail(row[2]);
            userCollection.getUsers().add(user);
        }

        return userCollection;
    }
}
