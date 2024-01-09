package com.workflow86.service.mock;

public class InValidMockJson {

    public static final String SINGLE_IN_VALID_OBJ_1 = """
            {
                "_id": "659cab791d626cf7b64292b1",
                "index": 0
            """;
    public static final String SINGLE_IN_VALID_OBJ_2 = """
            {
                "_id": "659cab791d626cf7b64292b1",
                "index": 0,
                "guid": "472a7132-9ff8-44eb-be0b-1ff229e8c2d3",
                "isActive": true,
                "balance": "$2,513.84",
                "picture": "http://placehold.it/32x32",
                "age""";
    public static final String SINGLE_IN_VALID_OBJ_GIVEN = """
            {
            “className” : “year 1”,
            “description” : “class for year 1”,
            “numberOfStudents” : 5,
            “group""";
    public static final String ARRAY_IN_VALID= """
            [
              {
                "_id": "659cab791d626cf7b64292b1",
                "index": 0,
                "guid": "472a7132-9ff8-44eb-be0b-1ff229e8c2d3",
                "isActive": true,
                "balance": "$2,513.84",
                "picture": "http://placehold.it/32x32",
                "age": 37,
                "eyeColor": "brown",
                "name": "Lara Sharp",
                "gender": "female",
                "company": "ASSISTIX",
                "email": "larasharp@assistix.com",
                "phone": "+1 (962) 585-3203",
                "address": "729 Argyle Road, Bellamy, Florida, 4584",
                "about": "Minim deserunt sunt commodo ex minim culpa. Irure nisi mollit laboris sunt tempor sunt. Cupidatat consequat nostrud proident eu consectetur tempor commodo. Cillum id non consequat officia ad. Excepteur dolor anim sunt officia.\\r\\n",
                "registered": "2015-05-06T01:52:46 -10:00",
                "latitude": -11.892153,
                "longitude": -93.438746,
                "tags": [
                  "esse",
                  "ex",
                  "eiusmod",
                  "cupidatat",
                  "exercitation",
                  "laboris",
                  "nisi"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "Doris Bennett"
                    """;

    public static final String ARRAY_IN_VALID_GIVEN= """
            {
            “className” : “year 1”,
            “description” : “class for year 1”,
            “numberOfStudents” : 5,
            “groups” : [
            {
            “group”:1,
            “students” : [
            {
            “name” : “student A”,
            “needSupport”: false
            },
            {
            “name” : “student B”,
            “needSupport”: true
            """;
}
