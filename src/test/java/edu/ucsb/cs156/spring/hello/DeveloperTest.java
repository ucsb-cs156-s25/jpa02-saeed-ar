package edu.ucsb.cs156.spring.hello; //this will help organize the tests

import static org.junit.jupiter.api.Assertions.assertEquals; //checks if two values are equal
import static org.junit.jupiter.api.Assertions.assertTrue; // checks if something is true

import java.lang.reflect.Constructor; //this is part of Java Reflection API, used to access and test the private constuctor.
import java.lang.reflect.Modifier; //I am assuming moifier helps enforce some design patterns for the tests to run

import org.junit.jupiter.api.Test; //marks method as unit test 

public class DeveloperTest { //defines a public alss in a JUnit test class for developer.java

    @Test //this means run this as a unit test
    public void testPrivateConstructor() throws Exception { //throws excpetion allows reflection-related exceptions to bubble up if something goes wrong
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor(); //intailzies a no-arg constuctor aka our default constructor of the developer class regardless if it is private or not
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private"); //here it is checking if constuctor is not private or not

        constructor.setAccessible(true); //checking if it is private
        constructor.newInstance(); //bypasses access control to instantie the class, this ensures all lines get executed 
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Saeed A", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
