package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.MyCollection;


import java.io.*;
import java.text.SimpleDateFormat;


public class Converter {
    private static final ObjectMapper mapper = new ObjectMapper();


    public static void toJson(MyCollection myCollection, String fileName) throws FileNotFoundException {
        setDateFormat();
        OutputStreamWriter writer;
        writer = new OutputStreamWriter(new FileOutputStream(fileName));
        try {
            writer.write(mapper.writeValueAsString(myCollection));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static MyCollection fromJson(String fileName) {
        setDateFormat();
        try {
            return mapper.readValue(new File(fileName), MyCollection.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void setDateFormat() {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm a z"));
        mapper.registerModule(new JavaTimeModule());
    }


}
