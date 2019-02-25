# Exercice - Project of an exercice using Spring boot 
[![Build Status](https://travis-ci.com/tiagofvalerio/spotify-exercice.svg?branch=master)](https://travis-ci.com/tiagofvalerio/spotify-exercice) [![Coverage Status](https://coveralls.io/repos/github/tiagofvalerio/spotify-exercice/badge.svg?branch=master)](https://coveralls.io/github/tiagofvalerio/spotify-exercice?branch=master)

**Installing**
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
If there's docker installed:

```
$ docker build -t exercice .
$ docker run --name exercice -d exercice
```
