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
        assertEquals("Saeed A", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("saeed-ar", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-06", t.getName());
    }





    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Rachit G"),"Team should contain Rachit G");
        assertTrue(t.getMembers().contains("Riya G"),"Team should contain Riya G");
        assertTrue(t.getMembers().contains("Sanjana J"),"Team should contain Sanjana J");
        assertTrue(t.getMembers().contains("Yarwin L"),"Team should contain Yarwin L");
        assertTrue(t.getMembers().contains("Aryan C"),"Team should contain Aryan C");
        assertTrue(t.getMembers().contains("Saeed A"),"Team should contain Saeed A");
        // ... etc
    }



    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)




}
