package ru.safarov.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.io.File;
import java.io.IOException;

public class CsvUserSerializer implements UserSerializer{


    public void serializer(UserCollections userCollections, String filename) {

           CsvSchema schema = CsvSchema.builder()
                .addColumn("id", CsvSchema.ColumnType.NUMBER)
                .addColumn("name")
                .addColumn("email")
                .build();
           ObjectMapper objectMapper = new CsvMapper();
            File out = new File(filename);
        try {
            objectMapper.writer(schema).writeValue(out, userCollections.getUsers());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
