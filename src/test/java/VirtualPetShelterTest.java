import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {

    @Test
    public void shouldAddPetToShelterAndReturnPet(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet petTest = new OrganicDog("Woof", 10, 100, 0, 0, 400, 50);
        underTest.addPet(petTest);
        VirtualPet newPetTest = underTest.adoptPet("Woof");
        assertEquals(petTest.getName(),newPetTest.getName());
    }

    @Test
    public void shouldIncreaseHealth(){
        VirtualPet petTest = new OrganicDog("Woof", 10, 100, 0, 0, 400, 50);
        petTest.play();
        petTest.eval();
        ((OrganicDog)petTest).healthCalc();
        assertEquals( 112 , ((OrganicDog)petTest).getPetHealth());
    }
    @Test
    public void shouldInreaseLoyality(){
        VirtualPet petTest = new OrganicDog("Woof", 10, 100, 0, 0, 400, 50);
        ((OrganicDog) petTest).walk();
        petTest.eval();
        ((OrganicDog) petTest).healthCalc();
        assertEquals(53, ((OrganicDog) petTest).getPetLoyalty() );
    }



}
