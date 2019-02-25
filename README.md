# Exercice - Project of an exercice using Spring boot 
[![Build Status](https://travis-ci.com/tiagofvalerio/spotify-exercice.svg?branch=master)](https://travis-ci.com/tiagofvalerio/spotify-exercice) [![Coverage Status](https://coveralls.io/repos/github/tiagofvalerio/spotify-exercice/badge.svg?branch=master)](https://coveralls.io/github/tiagofvalerio/spotify-exercice?branch=master)

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
The documentation
