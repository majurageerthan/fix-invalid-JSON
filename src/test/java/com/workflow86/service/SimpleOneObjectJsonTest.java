package com.workflow86.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.workflow86.service.mock.InvalidMockJson.*;
import static com.workflow86.service.mock.InvalidMockJson.INVALID_COMPLEX_GIVEN;
import static com.workflow86.service.mock.ValidMockJson.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleOneObjectJsonTest {

    @Nested
    class ValidJsonTests {
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
    }

    @Nested
    class InvalidJsonTests {
        @Test
        void testInvalidJsonGivenComplex() {
            JsonService js = new JsonService(VALID_COMPLEX_GIVEN);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testInvalidJson1() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_1);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInvalidJson2() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_2);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInvalidJsonGiven() {
            JsonService js = new JsonService(SINGLE_INVALID_OBJ_GIVEN);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInvalidComplexJsonGiven() {
            JsonService js = new JsonService(INVALID_COMPLEX_GIVEN);
            assertFalse(js.isValidJSON());
        }
    }

}
