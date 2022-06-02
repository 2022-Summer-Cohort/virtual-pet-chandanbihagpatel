import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {

    @Test
    public void shouldAddPetToShelterAndReturnPet(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet petTest = new VirtualPet("Chan", 2, 0, 4);
        underTest.addPet(petTest);
        assertEquals(petTest,underTest.adoptPet("Chan"));
    }

    @Test
    public void shouldIncreaseEnergy(){
        VirtualPet underTest = new VirtualPet("Chan", 2, 0, 4);
        underTest.sleep();
        assertEquals(10, underTest.getEnergy());
    }

    @Test
    public void shouldIncreaseHunger(){
        VirtualPet underTest = new VirtualPet("Chan", 2, 0, 4);
        underTest.sleep();
        assertEquals(5, underTest.getPetHunger());
    }

}
