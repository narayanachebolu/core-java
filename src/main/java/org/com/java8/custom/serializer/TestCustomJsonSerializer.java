package org.com.java8.custom.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;

public class TestCustomJsonSerializer {
    public static void main(String[] args) throws IOException {
        System.out.println("-- Java object to JSON --");
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setPair("USD/JPY");
        currencyRate.setRate(109.15);
        currencyRate.setLastUpdated(LocalDateTime.now());
        System.out.println("Java object: " + currencyRate);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(currencyRate);
        System.out.println("JSON String: " + jsonString);

        System.out.println("-- JSON to Java object --");
        CurrencyRate deserializedCurrencyRate = objectMapper.readValue(jsonString, CurrencyRate.class);
        System.out.println("Deserialized Currency Rate object: " + deserializedCurrencyRate);

    }
}
