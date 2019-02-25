# Exercice - Project of an exercice using Spring boot 
[![Build Status](https://travis-ci.com/tiagofvalerio/exercice.svg?branch=master)](https://travis-ci.com/tiagofvalerio/exercice) [![Coverage Status](https://coveralls.io/repos/github/tiagofvalerio/exercice/badge.svg)](https://coveralls.io/github/tiagofvalerio/exercice)

## Installing

<br />
To build the project running tests

```
$ ./gradlew build
```

<br />
To build the project without running tests

```
$ ./gradlew build -x test
```

<br />
If there's docker installed

```
$ docker build -t exercice .
$ docker run --name exercice -d exercice
```

<br />
To view container log

```
$ docker logs -f exercice
```

<br />
If there's no docker installed, run using gradlew in the project root folder

```
$ ./gradlew bootRun
```

<br />

## Albums Data catalog
When the application starts it automatically tries to connect to Spotify via Rest API do get the first fifty albums for each genre.


# API
The documentation of the API is generated with Swagger and can be accessed in the address below
```http://localhost:8080/swagger-ui.html```
<br />
<br />

## Exemplos
<br />

**GET** ```http://localhost:8080/albums?genre=rock&page=0&size=2```

<br />

**Response: 200 OK**

```json
{
    "content": [
        {
            "id": 155,
            "numberOfTracks": 100,
            "name": "100 Rock",
            "artistName": "Various Artists",
            "price": 57.77,
            "genre": "ROCK"
        },
        {
            "id": 167,
            "numberOfTracks": 16,
            "name": "Ao Vivo no Rock In Rio",
            "artistName": "CPM 22",
            "price": 74.99,
            "genre": "ROCK"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 2,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 25,
    "totalElements": 50,
    "last": false,
    "size": 2,
    "number": 0,
    "numberOfElements": 2,
    "first": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "empty": false
}
```

<br />

**GET** ```http://localhost:8080/albums/155```
<br />

**Response: 200 OK**

```json
{
    "id": 155,
    "numberOfTracks": 100,
    "name": "100 Rock",
    "artistName": "Various Artists",
    "price": 57.77,
    "genre": "ROCK"
}
```

<br />

**POST** ```http://localhost:8080/sale```
<br />
Passing the bellow body as Json
```json
{
    "id": "155",
    "quantity": "1"
}
```
<br />

**Response: 201 Created**

```json
{
    "id": 1,
    "createdAt": "2019-02-25T19:53:58.062",
    "album": {
        "id": 155,
        "numberOfTracks": 100,
        "name": "100 Rock",
        "artistName": "Various Artists",
        "price": 57.77,
        "genre": "ROCK"
    },
    "albumQuantity": 1,
    "saleAmount": 57.77,
    "cashBackAmount": 5.78,
    "tatalCashBackAmount": 5.78
}
```
<br />

**GET** ```http://localhost:8080/albums/155```

<br />

**Response: 200 OK**

```json
{
    "content": [
        {
            "id": 1,
            "createdAt": "2019-02-25T19:53:58.062",
            "album": {
                "id": 155,
                "numberOfTracks": 100,
                "name": "100 Rock",
                "artistName": "Various Artists",
                "price": 57.77,
                "genre": "ROCK"
            },
            "albumQuantity": 1,
            "saleAmount": 57.77,
            "cashBackAmount": 5.78,
            "tatalCashBackAmount": 5.78
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "numberOfElements": 1,
    "first": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "empty": false
}
```




