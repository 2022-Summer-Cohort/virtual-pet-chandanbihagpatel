import java.sql.Array;
import java.util.ArrayList;

public class VirtualPetShelter {
    private ArrayList<VirtualPet> petShelter;

    public VirtualPetShelter() {
        this.petShelter = new ArrayList<>();
    }

    public ArrayList<VirtualPet> getPetShelter() {
        return petShelter;
    }
    public void addPet(VirtualPet petToAdd){
        petShelter.add(petToAdd);

    }
    public VirtualPet adoptPet(String adoptPet){
        VirtualPet petToAdopt = new VirtualPet("null",0,0,0);
        for(VirtualPet pets : petShelter){
            String name = pets.getPetName();
            if(name.equals(adoptPet)){
                System.out.println("Pet Found");
                petToAdopt = pets;
                break;
            }
        }
        return petToAdopt;
    }
    public void removePet(String adoptPet){
        for(VirtualPet pets : petShelter){
            String name = pets.getPetName();
            if(name.equals(adoptPet)){
                System.out.println("Removing pet from shelter.");
                petShelter.remove(pets);
                break;
            }
            else{
                System.out.println("That pet wasn't found.");
            }
        }
    }
    public void feedAll(){
        for(VirtualPet pets : petShelter){
            pets.feedPet();
        }

    }
    public void infoAll(){
        for(VirtualPet pets : petShelter){
            pets.info();
        }

    }
    public void playAll(){
        int i = petShelter.size()-1;
        for(VirtualPet pets : petShelter){
            VirtualPet playPartner = petShelter.get(i);
            pets.playPet();
            if(pets == playPartner){
                System.out.println(" with you  .");

            }
            else{
                System.out.println(" with " + playPartner.getPetName());
            }
            i--;
        }
    }
    public void sleepAll(){
        for(VirtualPet pets : petShelter){
            pets.sleep();
        }
    }
}
