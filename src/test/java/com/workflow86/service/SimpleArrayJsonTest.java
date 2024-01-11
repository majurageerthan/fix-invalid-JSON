package com.workflow86.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.workflow86.service.mock.InvalidMockJson.ARRAY_INVALID;
import static com.workflow86.service.mock.InvalidMockJson.ARRAY_INVALID_GIVEN;
import static com.workflow86.service.mock.ValidMockJson.ARRAY_OBJ;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleArrayJsonTest {

    @Nested
    class ValidArrayJsonTests {
        @Test
        void testValidArrayJson1() {
            JsonService js = new JsonService(ARRAY_OBJ);
            assertTrue(js.isValidJSON());
        }
    }

    @Nested
    class InvalidArrayJsonTests {
        @Test
        void testInvalidArrayJson1() {
            JsonService js = new JsonService(ARRAY_INVALID);
            assertFalse(js.isValidJSON());
        }

        @Test
        void testInvalidArrayJsonGiven() {
            JsonService js = new JsonService(ARRAY_INVALID_GIVEN);
            assertFalse(js.isValidJSON());
        }
    }
}
