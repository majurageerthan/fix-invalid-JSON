package com.workflow86.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        void testInValidJson1() {
            JsonService js = new JsonService(SINGLE_IN_VALID_OBJ_1);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidJson2() {
            JsonService js = new JsonService(SINGLE_IN_VALID_OBJ_2);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidJsonGiven() {
            JsonService js = new JsonService(SINGLE_IN_VALID_OBJ_GIVEN);
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
            JsonService js = new JsonService(ARRAY_IN_VALID);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInValidArrayJsonGiven() {
            JsonService js = new JsonService(ARRAY_IN_VALID_GIVEN);
            assertFalse(js.isValidJSON());
        }
    }


}