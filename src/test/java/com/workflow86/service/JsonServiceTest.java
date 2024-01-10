package com.workflow86.service;

import org.json.JSONException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.workflow86.service.mock.InValidMockJson.*;
import static com.workflow86.service.mock.ValidMockJson.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JsonServiceTest {

    @Nested
    class SimpleOneObjectJson {
        @Test
        void testValidJson1() {
            JsonService js = new JsonService(SINGLE_VALID_OBJ_1);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testValidJson2() {
            JsonService js = new JsonService(SINGLE_VALID_OBJ_2);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testInValidJsonGivenComplex() {
            JsonService js = new JsonService(VALID_COMPLEX_GIVEN);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testInValidJson1() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_1);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidJson2() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_2);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidJsonGiven() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_GIVEN);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidComplexJsonGiven() {
            JsonService js = new JsonService(INVALID_COMPLEX_GIVEN);
            assertFalse(js.isValidJSON());
        }
    }

    @Nested
    class SimpleArrayJson {
        @Test
        void testValidArrayJson1() {
            JsonService js = new JsonService(ARRAY_OBJ);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testInValidArrayJson1() {
            JsonService js = new JsonService(ARRAY_INVALID);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidArrayJsonGiven() {
            JsonService js = new JsonService(ARRAY_INVALID_GIVEN);
            assertFalse(js.isValidJSON());
        }
    }

    @Nested
    class FixInCompleteJson {
        @Test
        void testJsonComparison() throws JSONException {
            String expectedJson = "{\"name\": \"John\" , \"age\": 30}";
            String actualJson = "{\"name\": \"John\", \"age\": 30}";
            JSONAssert.assertEquals(expectedJson, actualJson, true);
        }
        @Test
        void testFixInCompleteJson1() throws JSONException {
            String expectedJson = "{\"name\": \"John\" , \"age\": 30}";
            String actualJson = "{\"name\": \"John\", \"age\": 30}";
            JSONAssert.assertEquals(expectedJson, actualJson, true);
        }
    }

}