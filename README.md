# Cucumber-JVM Dependency Injection with Spring

## UPDATE:

The way this repo used to demonstrate how to set up dependency injection for cucumber
using spring [has been deprecated](https://github.com/cucumber/cucumber-jvm/pull/1940).
You can still find the old approach demonstrated in this repo's `cucumber_xml` branch;
I've updated `master` to reflect the new way of doing it.

---

This repo accompanies [this](https://natritmeyer.com/howto/cucumber-jvm-dependency-injection-with-spring/) blog post and is an example maven project demonstrating how to use Spring's dependency
injection with Cucumber-JVM in a test automation framework.

## Intro

The purpose of this repo is to demonstrate how a cucumber scenario can be written in such a way as to be implementation
agnostic, achieving this using dependency injection. Depending on one system property the tests will either run the
mobile implementation of the application under test, or the desktop implementation.

## The Scenario

It's pretty simple: webdriver loads [Bing](https://www.bing.com), searches for "cucumber", and verifies that the
first hit in the search results contains the word "Cucumber".

## The dependency injection bit

The project is set up such that Page Objects are implementation specific, i.e. there's a `MobileBingHomePage` and a
`DesktopBingHomePage`, but both implement a single `BingHomePage` interface. The decision between which implementation
is used is determined at runtime through the use of spring [Profiles](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-definition-profiles-java).
If the `-Dspring.profiles.active` command line argument is set to `desktop` then the step definition class will be injected
with `DesktopBingHomePage`, or, if it's set to `mobile` then `MobileBingHomePage` will be injected.

The same happens with the Page Objects themselves. They all need a WebDriver instance so one is injected in. Depending,
again, on which spring profile is set, the Page Object will be injected with a WebDriver instance that is either set up
with "desktop" dimensions, or with "mobile" dimensions and appropriate user-agent.

That's about the sum of it.

Note, this is just one way to arrange things. This repo is to demonstrate how all the pieces work together, not their
optimal arrangement - that'll be determined by your own unique requirements.

## Usage

To run the feature with a "desktop browser":

```sh
mvn clean verify -Dspring.profiles.active=desktop
```

To run the feature with a "mobile browser":

```sh
mvn clean verify -Dspring.profiles.active=mobile
```

## Tested with...

On 14th Jan 2019, with the following setup, It Worked On My Machine:

* Macbook Pro 13" 2018
* macOS 10.14.2 (18C54)
* Maven 3.6.0
* Java openjdk 11.0.1 2018-10-16
* Chrome for Mac 71.0.3578.98 (Official Build) (64-bit)
* ChromeDriver 2.45.615355

Assumes:

* No proxy required
* No corporate SSL MiTM in place
* Microsoft haven't tinkered with [bing.com](https://www.bing.com)
