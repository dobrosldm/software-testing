package test;

import main.task3.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class TestTask3 {
    Whale whale;

    @Before
    public void recreate() {
        whale = new Whale(Position.NATURAL, EmotionalState.USUAL, SelfIdentity.SELF);
    }

    @Test
    public void changePosition(){
        whale.changePosition();
        assertEquals(Position.UNNATURAL, whale.getBodyPosition());
    }

    @Test
    public void changeEmotionalStateOnNatural(){
        assertTrue(whale.changeEmotionalState(EmotionalState.HAPPY));
        assertEquals(EmotionalState.HAPPY, whale.getEmotionalState());
    }

    @Test
    public void changeEmotionalStateOnUnnatural(){
        whale.changePosition();
        assertTrue(whale.changeEmotionalState(EmotionalState.CONFUSED));
        assertEquals(EmotionalState.CONFUSED, whale.getEmotionalState());
    }

    @Test
    public void tryToChangeEmotionalStateInvalid1(){
        whale.changePosition();
        assertFalse(whale.changeEmotionalState(EmotionalState.HAPPY));
    }

    @Test
    public void tryToChangeEmotionalStateInvalid2(){
        whale.changePosition();
        assertFalse(whale.changeEmotionalState(EmotionalState.USUAL));
    }

    @Test
    public void changeSelfIdentityOnNaturalPosition(){
        assertEquals("Now I for sure know who I am", whale.changeSelfIdentity(SelfIdentity.OTHER));
        assertEquals(SelfIdentity.OTHER, whale.getSelfIdentity());
        assertEquals(TimeToGetUsed.LITTLE, whale.getTimeToGetUsed());
    }

    @Test
    public void changeSelfIdentityOnUnnaturalPosition(){
        whale.changePosition();
        assertEquals("Now I for sure know who I am", whale.changeSelfIdentity(SelfIdentity.OTHER));
        assertEquals(SelfIdentity.OTHER, whale.getSelfIdentity());
        assertEquals(TimeToGetUsed.MUCH, whale.getTimeToGetUsed());
    }

    @Test
    public void changeIdentityOnSame(){
        SelfIdentity old = whale.getSelfIdentity();
        assertEquals("I already know who I am", whale.changeSelfIdentity(SelfIdentity.SELF));
        assertEquals(old, whale.getSelfIdentity());
        assertNull(whale.getTimeToGetUsed());
    }
}
