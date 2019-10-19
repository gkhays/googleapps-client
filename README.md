# Google Admin SDK Client

Demonstrates using Google OAuth to access a Google Suites directory then list the users using the Google Admin SDK.

## Getting Started

You must first have a Google account and then register the Admin SDK API in a new project using the Google Developers Console; see https://code.google.com/apis/console. Once you have created a new project you will have to set up a redirect URI in the OAuth credentials tab. In our case the redirect URI is:

```
http://localhost:8080/google-client/api/oauth2/authorize
```

![OAuth Credentials](doc/images/clientid4webapp.png)

## Prerequisites

This project requires Java and Maven. Use at least version 1.8 of the Java JDK. Try out [AdoptOpenJDK](https://adoptopenjdk.net/) or [Zulu Community OpenJDK](https://www.azul.com/downloads/zulu-community/).

## Installing

Clone this repository.

```
git clone https://github.com/gkhays/googleapps-client.git
```

Have the OAuth client and secret from the Getting Started section, above, ready to go.

Then execute:

```
mvn clean package jetty:run
```

## Built With

Eclipse IDE for Enterprise Java Developers.

```
Version: 2018-12 (4.10.0)
Build id: 20181214-0600
```

## References

1. [OAuth 2.0 Playground](https://developers.google.com/oauthplayground)
1. [Google Developers Console: APIs & Services](https://console.developers.google.com/apis/credentials/)
1. [OAuth 2 client Google sample in WebApp deployment](https://github.com/jersey/jersey/tree/master/examples/oauth2-client-google-webapp)
1. [Eclipse Jersey Project](https://github.com/eclipse-ee4j/jersey)
1. [Eclipse Jersey Project Wiki](https://github.com/eclipse-ee4j/jersey/wiki)
