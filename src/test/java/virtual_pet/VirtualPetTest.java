package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void shouldReturnNewHealthAfterSleep(){
        VirtualPet underTest = new VirtualPet("woof", "brown", 10, 1,4);
        int actual = underTest.actionHealth("sleep");
        assertEquals(7,actual);


    }

    @Test
    public void shouldReturnNewHealthAfterWalk(){
        VirtualPet underTest = new VirtualPet("woof", "brown", 10, 1,4);
        int actual = underTest.actionHealth("walk");
        assertEquals(3,actual);


    }

    @Test
    public void shouldReturnNewRepAfterSleep(){
        VirtualPet underTest = new VirtualPet("woof", "brown", 10, 1,4);
        int actual = underTest.actionRep("sleep");
        assertEquals(1,actual);


    }

    @Test
    public void shouldReturnNewRepAfterBite(){
        VirtualPet underTest = new VirtualPet("woof", "brown", 10, 1,4);
        int actual = underTest.actionRep("bite");
        assertEquals(-2,actual);


    }


}
