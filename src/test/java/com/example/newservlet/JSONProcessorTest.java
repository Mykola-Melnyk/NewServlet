package com.example.newservlet;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JSONProcessorTest {

    @Test
    public void testSimpleJson() throws IOException {
        HashMap<String, String> object = JSONProcessor.parseJSON("""
                {
                    "foo": "bar",
                    "key": "value"
                }
                """);
        assertFalse(object.isEmpty());
        assertEquals("bar", object.get("foo"));
    }

    @Test
    public void testCompoundJson() throws IOException {
        HashMap<String, String> object = JSONProcessor.parseJSON("""
                {
                    "foo": "bar",
                    "key": "value",
                    "code": [1, 2, 3]
                }
                """);
        assertFalse(object.isEmpty());
        assertEquals("bar", object.get("foo"));
    }

//    @Test
//    public void testSimpleJson2() throws IOException {
//        HashMap<String, String> object = JSONProcessor.parseJSON("""
//                {
//                    "foo": "bar"
//                }
//                """);
//        assertEquals(2, object.size());
//    }
}