package com.example.LibraryRestAPI;

import com.example.LibraryRestAPI.Domains.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JacksonTest {
    @Test
    public void testThatTurnsJsonIntoJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Book book = Book.builder()
                .isbn("978")
                .title("The Boy WHo Lived")
                .author("JK")
                .yearPublished("2000")
                .build();

        String result = objectMapper.writeValueAsString(book);
        assertThat(result).isEqualTo("{\"isbn\":\"978\",\"title\":\"The Boy WHo Lived\",\"author\":\"JK\",\"year\":\"2000\"}");
    }

    @Test
    public void testThatTurnsJavaIntoJsonObject() throws JsonProcessingException {
        String json = "{\"Foo\":\"bar\",\"isbn\":\"978\",\"title\":\"The Boy WHo Lived\",\"author\":\"JK\",\"year\":\"2000\"}";
        Book book = Book.builder()
                .isbn("978")
                .title("The Boy WHo Lived")
                .author("JK")
                .yearPublished("2000")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        Book result = objectMapper.readValue(json, Book.class);
        assertThat(result).isEqualTo(book);
    }
}





