package com.workflow86.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.workflow86.service.mock.MockJson.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JsonServiceTest {

    @Nested
    class SimpleOneObjectJson {
        @Test
        void testValidJson1() {
            JsonService js = new JsonService(SINGLE_OBJ_1);
            System.out.println(SINGLE_OBJ_1);
            assertTrue(js.isValidJSON());
        }

        @Test
        void testUseCase2() {

        }

        @Test
        void testUseCase3() {

        }
    }

    @Test
    void isValidJSON() {
        JsonService js = new JsonService(ARRAY_OBJ);
        assertTrue(js.isValidJSON());
    }
}