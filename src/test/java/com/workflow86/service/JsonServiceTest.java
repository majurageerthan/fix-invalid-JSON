package com.workflow86.service;

import org.json.JSONException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.workflow86.service.mock.CorrectedValidMockJson.*;
import static com.workflow86.service.mock.InValidMockJson.*;
import static com.workflow86.service.mock.ValidMockJson.*;
import static org.junit.jupiter.api.Assertions.*;


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
        void testFixDoubleQuoteAndComma() {
            String incompleteJSON = """
                    {
                    "className":"year 1",
                    "description":"class for year 1",
                    "numberOfStudents":5,
                    "group""";
            String expectedJson = """
                    {
                    "className":"year 1",
                    "description":"class for year 1",
                    "numberOfStudents":5,
                    """;
            JsonService js = new JsonService(incompleteJSON);
            String actual = js.fixDoubleQuoteAndComma(incompleteJSON);
            assertEquals(expectedJson.replaceAll("\\s", ""), actual.replaceAll("\\s", ""));
        }

        @Test
        void testFixInCompleteJson1() throws JSONException {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_1);
            String actual = js.fixInCompleteJSON();
            JSONAssert.assertEquals(FIX_SINGLE_IN_VALID_OBJ_1, actual, true);
        }

        @Test
        void testFixInCompleteJson2() throws JSONException {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_2);
            String actual = js.fixInCompleteJSON();
            JSONAssert.assertEquals(FIX_SINGLE_IN_VALID_OBJ_2, actual, true);
        }

        @Test
        void testFixInCompleteJson3() throws JSONException {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_GIVEN);
            String actual = js.fixInCompleteJSON();
            JSONAssert.assertEquals(FIX_SINGLE_IN_VALID_OBJ_GIVEN, actual, true);
        }

        @Test
        void testFixInCompleteArrayJson() throws JSONException {
            JsonService js = new JsonService(ARRAY_INVALID);
            String actual = js.fixInCompleteJSON();
            JSONAssert.assertEquals(FIX_ARRAY_IN_VALID, actual, true);
        }

        @Test
        void testFixInCompleteArrayGivenJson() throws JSONException {
            JsonService js = new JsonService(ARRAY_INVALID_GIVEN);
            String actual = js.fixInCompleteJSON();
            System.out.println("-----------------------");
            System.out.println(actual);
            JSONAssert.assertEquals(FIX_ARRAY_IN_VALID_GIVEN, actual, true);
        }
    }

}