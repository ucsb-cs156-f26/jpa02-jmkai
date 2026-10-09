package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

   @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team),"Team is not equal to itself");
    }

    @Test
    public void equals_diff_class() {
        assertTrue(!team.equals(0),"Team is equal to different class");
    }

    @Test
    public void equals_same_class() {
        // identical names and members
        Team otherTeam = new Team("test-team");
        assertTrue(team.equals(otherTeam),"Team is not equal to identical object");

        // same name different members
        otherTeam.addMember("mikhail");
        assertTrue(!team.equals(otherTeam),"Team is equal to object with diff members");

        // different name same members
        team.addMember("mikhail");
        otherTeam.setName("wrong-name");
        assertTrue(!team.equals(otherTeam),"Team is equal to object with diff name");

        // different name and members
        otherTeam.addMember("golf club");
        assertTrue(!team.equals(otherTeam),"Team is equal to object with diff name and members");
    }

    @Test 
    public void hashCode_general_correctness() {
        Team t = new Team("default");
        int result = t.hashCode();
        int expectedResult = 1544803905;
        assertEquals(result, expectedResult);
    }
}
