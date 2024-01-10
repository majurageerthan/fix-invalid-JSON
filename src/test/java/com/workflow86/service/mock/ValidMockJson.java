package com.workflow86.service.mock;

public class ValidMockJson {

    public static final String SINGLE_VALID_OBJ_1 = """
            {
                "_id": "659cab791d626cf7b64292b1",
                "index": 0
            }""";
    public static final String SINGLE_VALID_OBJ_2 = """
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
                "longitude": -93.438746
            }""";

    public static final String VALID_COMPLEX_GIVEN = """
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
                           "name":"student B",
                           "needSupport":true
                        },
                        {
                           "name":"student C",
                           "needSupport":false
                        }
                     ]
                  },
                  {
                     "group":2,
                     "students":[
                        {
                           "name":"student D",
                           "needSupport":false
                        },
                        {
                           "name":"student E",
                           "needSupport":true
                        }
                     ]
                  }
               ],
               "naughtyList":[
                  {
                     "name":"student E",
                     "needSupport":true
                  }
               ]
            }""";
    public static final String ARRAY_OBJ = """
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
                  },
                  {
                    "id": 1,
                    "name": "Carr Finley"
                  },
                  {
                    "id": 2,
                    "name": "Dianna Chan"
                  }
                ],
                "greeting": "Hello, Lara Sharp! You have 4 unread messages.",
                "favoriteFruit": "banana"
              },
              {
                "_id": "659cab79746917d6e9b27a45",
                "index": 1,
                "guid": "5f9a28f9-7e6c-4fdb-a878-0d65a0fe9632",
                "isActive": true,
                "balance": "$3,874.48",
                "picture": "http://placehold.it/32x32",
                "age": 28,
                "eyeColor": "green",
                "name": "Darcy Sherman",
                "gender": "female",
                "company": "EGYPTO",
                "email": "darcysherman@egypto.com",
                "phone": "+1 (920) 596-3182",
                "address": "597 Pierrepont Street, Edenburg, Texas, 7508",
                "about": "Anim occaecat nulla nisi do. Esse elit ea nulla eiusmod velit enim dolore fugiat qui reprehenderit non. Do Lorem ex ex enim dolor ea incididunt.\\r\\n",
                "registered": "2022-04-21T07:16:33 -10:00",
                "latitude": 74.22176,
                "longitude": 134.297986,
                "tags": [
                  "consequat",
                  "incididunt",
                  "aute",
                  "proident",
                  "ut",
                  "commodo",
                  "duis"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "Hull Puckett"
                  },
                  {
                    "id": 1,
                    "name": "Beach Gamble"
                  },
                  {
                    "id": 2,
                    "name": "Cross Alexander"
                  }
                ],
                "greeting": "Hello, Darcy Sherman! You have 3 unread messages.",
                "favoriteFruit": "apple"
              },
              {
                "_id": "659cab79376fa5ec1fce419b",
                "index": 2,
                "guid": "0245200a-d75a-4f13-97db-9eb1d9c04c85",
                "isActive": true,
                "balance": "$3,690.47",
                "picture": "http://placehold.it/32x32",
                "age": 26,
                "eyeColor": "green",
                "name": "Hodge Gallagher",
                "gender": "male",
                "company": "DELPHIDE",
                "email": "hodgegallagher@delphide.com",
                "phone": "+1 (888) 415-3059",
                "address": "338 Nassau Street, Wikieup, Oklahoma, 9227",
                "about": "Est do fugiat esse duis duis. Ea commodo consequat id irure consequat. Proident minim est irure magna voluptate consequat amet minim tempor do in. Aute id amet dolore id adipisicing excepteur duis est exercitation minim commodo magna. Fugiat veniam adipisicing occaecat labore sunt esse tempor. Minim dolor eiusmod qui sint nulla sit magna nostrud magna labore consequat velit mollit aliquip. Officia cupidatat proident sunt cupidatat adipisicing consectetur eiusmod deserunt amet ullamco incididunt mollit.\\r\\n",
                "registered": "2023-11-28T03:17:45 -11:00",
                "latitude": 15.272171,
                "longitude": 49.212861,
                "tags": [
                  "ipsum",
                  "esse",
                  "pariatur",
                  "duis",
                  "do",
                  "officia",
                  "nostrud"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "Mckenzie Clements"
                  },
                  {
                    "id": 1,
                    "name": "Sharp Cohen"
                  },
                  {
                    "id": 2,
                    "name": "Josefina Lott"
                  }
                ],
                "greeting": "Hello, Hodge Gallagher! You have 8 unread messages.",
                "favoriteFruit": "apple"
              },
              {
                "_id": "659cab794fefcca1baa4b860",
                "index": 3,
                "guid": "b1a22fc8-15ea-4a09-987a-322621baa3ff",
                "isActive": true,
                "balance": "$3,247.60",
                "picture": "http://placehold.it/32x32",
                "age": 23,
                "eyeColor": "green",
                "name": "Conway Terrell",
                "gender": "male",
                "company": "DADABASE",
                "email": "conwayterrell@dadabase.com",
                "phone": "+1 (832) 566-2433",
                "address": "720 Evans Street, Ivanhoe, New Jersey, 2226",
                "about": "Fugiat consectetur dolor in Lorem laborum qui anim nostrud nisi. Quis magna elit exercitation sit duis duis sint enim. Ad veniam nostrud mollit commodo exercitation dolor eiusmod magna nostrud aliquip qui dolor incididunt. Et excepteur nisi pariatur laboris ut deserunt ea fugiat ad sit. Nulla elit consequat quis laborum incididunt non voluptate. Ut nulla officia culpa incididunt exercitation reprehenderit sint incididunt fugiat sint aute dolore esse irure. In aliqua non consectetur duis voluptate exercitation nulla.\\r\\n",
                "registered": "2021-02-15T03:26:25 -11:00",
                "latitude": -74.183721,
                "longitude": 164.859567,
                "tags": [
                  "excepteur",
                  "nostrud",
                  "commodo",
                  "nulla",
                  "tempor",
                  "ullamco",
                  "laboris"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "Noemi Gardner"
                  },
                  {
                    "id": 1,
                    "name": "Ericka Giles"
                  },
                  {
                    "id": 2,
                    "name": "Jodi Love"
                  }
                ],
                "greeting": "Hello, Conway Terrell! You have 1 unread messages.",
                "favoriteFruit": "strawberry"
              },
              {
                "_id": "659cab7910550190745cdf36",
                "index": 4,
                "guid": "799b34a6-d195-46b2-a4db-aab4c947ab09",
                "isActive": true,
                "balance": "$1,977.05",
                "picture": "http://placehold.it/32x32",
                "age": 36,
                "eyeColor": "brown",
                "name": "Terrell Kline",
                "gender": "male",
                "company": "GEEKUS",
                "email": "terrellkline@geekus.com",
                "phone": "+1 (981) 513-2558",
                "address": "793 Furman Avenue, Stouchsburg, Idaho, 951",
                "about": "Sunt occaecat magna ex quis labore id irure Lorem reprehenderit id non fugiat. Proident dolore consectetur reprehenderit mollit Lorem fugiat occaecat commodo velit eiusmod reprehenderit. Commodo do ad sunt culpa qui esse nisi. Ex excepteur veniam adipisicing amet ad ullamco ullamco sit veniam excepteur. Lorem pariatur ullamco duis ut sint ea pariatur irure.\\r\\n",
                "registered": "2017-05-21T07:29:29 -10:00",
                "latitude": -71.41998,
                "longitude": 5.779442,
                "tags": [
                  "occaecat",
                  "irure",
                  "exercitation",
                  "esse",
                  "id",
                  "id",
                  "cupidatat"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "White Buckner"
                  },
                  {
                    "id": 1,
                    "name": "Kate Powell"
                  },
                  {
                    "id": 2,
                    "name": "Horne Cole"
                  }
                ],
                "greeting": "Hello, Terrell Kline! You have 2 unread messages.",
                "favoriteFruit": "banana"
              },
              {
                "_id": "659cab7974bd6ea7f8622162",
                "index": 5,
                "guid": "225ea482-cd8e-4a0c-ae67-b0ee96630c0d",
                "isActive": true,
                "balance": "$3,550.95",
                "picture": "http://placehold.it/32x32",
                "age": 25,
                "eyeColor": "blue",
                "name": "Kristin Stewart",
                "gender": "female",
                "company": "PARLEYNET",
                "email": "kristinstewart@parleynet.com",
                "phone": "+1 (924) 485-2158",
                "address": "404 Flatbush Avenue, Goldfield, Arizona, 1850",
                "about": "Amet elit pariatur quis proident irure deserunt magna magna est. Dolor proident ex aliqua cillum et id dolore sint elit fugiat minim. Sunt amet eiusmod exercitation consectetur exercitation commodo exercitation do et qui ex veniam elit. Magna quis adipisicing commodo ad ut est nulla.\\r\\n",
                "registered": "2021-04-17T08:38:47 -10:00",
                "latitude": 37.855833,
                "longitude": -124.166488,
                "tags": [
                  "officia",
                  "id",
                  "ea",
                  "quis",
                  "pariatur",
                  "labore",
                  "veniam"
                ],
                "friends": [
                  {
                    "id": 0,
                    "name": "Arline Walton"
                  },
                  {
                    "id": 1,
                    "name": "Alisa Tanner"
                  },
                  {
                    "id": 2,
                    "name": "Bette Rojas"
                  }
                ],
                "greeting": "Hello, Kristin Stewart! You have 4 unread messages.",
                "favoriteFruit": "banana"
              }
            ]""";
}
