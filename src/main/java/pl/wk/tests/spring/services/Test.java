package pl.wk.tests.spring.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fumik on 5/29/2017.
 */
public class Test {



    public static void main(String[] args) {

        ObjectMapper om = new ObjectMapper();
        String json = "[" +
                "{\"field1\":\"value11\", \"field2\":\"value21\"}," +
                "{\"field1\":\"value12\", \"field2\":\"value22\"}" +
                "]";
        System.out.println("Hello world");

        try {
            List<Pojo> pojos = Arrays.asList(om.readValue(json, Pojo[].class));
            int x = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Pojo {
        String field1;
        String field2;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}
