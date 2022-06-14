import java.util.ArrayList;

public class VirtualPetShelter {
    private ArrayList<VirtualPet> petShelter;

    public VirtualPetShelter() {
        this.petShelter = new ArrayList<>();
    }

    public ArrayList<VirtualPet> getPetShelter(){
        return petShelter;
    }
    public void addPet(VirtualPet myPet){
        petShelter.add(myPet);
    }
    public VirtualPet adoptPet(String adoptPet){
        VirtualPet petToAdopt = new OrganicDog("Null", 0, 0, 0, 0, 0, 0);
        for(VirtualPet pets : petShelter){
            String name = pets.getName();
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
            String name = pets.getName();
            if(name.equals(adoptPet)){
                System.out.println("Removing pet from shelter.");
                petShelter.remove(pets);
                break;
            }
        }
    }
    public void playAll(){
        int i = petShelter.size()-1;
        for(VirtualPet pets : petShelter){
            VirtualPet playPartner = petShelter.get(i);
            pets.play();
            if(pets == playPartner){
                System.out.println(" with you  .");

            }
            else{
                System.out.println(" with " + playPartner.getName());
            }
            i--;
        }
        System.out.println("Playing with pets in the shelter will continue to lower their health. You should pick a pet to adopt.");
    }
    public void listAll(){
        for(VirtualPet pets : petShelter){
            System.out.println(pets.getName());
        }
    }


}
