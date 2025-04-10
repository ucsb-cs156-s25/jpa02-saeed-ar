package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    //@Test
    //public void toString_returns_correct_string() {
    // assertEquals("Team(name=test-team, members=[])", team.toString());
   // }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same() {
    assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_dne_team() {
    assertEquals(false, team.equals("not a team"));
    }


    @Test
    public void case_one_equality(){ //case 1 TT
        Team t1;
        t1 = new Team("test-team");
        t1.addMember("Saeed A");

        team.addMember("Saeed A");
        
        assertEquals(true, team.equals(t1));
    }


    @Test //case 2 TF
    public void second_case(){
        Team t1 = new Team("test-team");

        t1.addMember("Saeed A");

        team.addMember("Not Saeed A");

        assertEquals(false, team.equals(t1));

    }

    @Test // case 3 FT
    public void case_three() {
        Team t1 = new Team("different-name");
        t1.addMember("same member");
        team.addMember("same member");
        assertEquals(false, team.equals(t1));
    }

    @Test //case 4 FF
    public void case_four(){
        Team t1 = new Team("not a team");

        t1.addMember("Saeed A");

        team.addMember("Not Saeed A");

        assertEquals(false, team.equals(t1));

    }

    @Test
    public void hashcode_equality(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void hashCode_debug() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }







   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
