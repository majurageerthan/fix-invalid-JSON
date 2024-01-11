package com.workflow86;

import com.workflow86.service.JsonService;

public class Main {

    public static void main(String[] args) {
        String invalidGivenJSONExample = """
                {
                   "className":"year 1",
                   "description":"class for year 1",
                   "numberOfStudents":5,
                   "groups":[
                      {
                         "group":1,
                         "students":[
                            {
                               "name":"student A",
                               "needSupport":false
                            },
                            {
                               "name":"student B",""";

        JsonService js = new JsonService(invalidGivenJSONExample);
        String fixedJSON = js.fixIncompleteJSON();
        System.out.println(fixedJSON);
    }
}