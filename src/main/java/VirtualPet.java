public class VirtualPet {
    private String petName;
    private int petAge;
    private int petHunger;
    private int energy;

    public VirtualPet(String petName, int petAge, int petHunger, int energy) {
        this.petName = petName;
        this.petAge = petAge;
        this.petHunger = petHunger;
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public String getPetName() {
        return petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public int getPetHunger() {
        return petHunger;
    }
    public void feedPet(){
        if(energy<1){
            System.out.println(getPetName() + " is too tired to eat right now.");
            sleep();
        }
        else if(petHunger<=0){
            System.out.println(getPetName() +" isn't hungry!");
        }
        else {
            petHunger = getPetHunger() - 5;
            energy = getEnergy() - 1;
            System.out.println("Eating...");
            System.out.println("...");
            System.out.println("...");
            System.out.println("...");
            System.out.println("done");

        }
    }
    public void playPet(){
        if(petHunger > 15){
            System.out.println(getPetName() + " is too hungry to play!");
            System.out.println(getPetName() + " started sniffing around trash from the trashcan.");
            feedPet();
        }
        else if(energy<2){
            System.out.println(getPetName() + " doesn't have enough energy to play");
            sleep();
        }
        else {
            petHunger = getPetHunger() + 5;
            energy = getEnergy() - 2;
            System.out.print(getPetName() + " is playing");
        }

    }
    public void death(){
        System.out.println(getPetName() + " has died.");
        System.exit(0);
    }
    public void sleep(){
        if(petHunger>15 && energy<1 ){
            System.out.println(getPetName() + " refuses to go to sleep on an empty stomach!");
            System.out.println(getPetName() + " doesn't have enough energy to eat");
            death();
        }
        else if(petHunger>15){
            System.out.println(getPetName() + " refuses to go to sleep on an empty stomach!");
            feedPet();
        }
        energy = getEnergy() + 6;
        petHunger = getPetHunger() + 5;
        System.out.println(getPetName() + " fell asleep.");
        System.out.println("Zzz");
        System.out.println("Zzz");
        System.out.println("Zzz");
    }
    public void info(){
        String hungerLevel = "";
        String energyLevel = "";
        if(getPetHunger()<5){
            hungerLevel = "not hungry";
        }
        else if(getPetHunger()<10){
            hungerLevel = "hungry";
        }
        else{
            hungerLevel = "starving";
        }
        if(getEnergy()<2){
            energyLevel = "tired";
        }
        else if(getEnergy()<4){
            energyLevel = "awake";
        }
        else{
            energyLevel = "Energetic";
        }
        System.out.println("...");
        System.out.println(getPetName()+" is " + hungerLevel + " and is " + energyLevel + ".");
    }
}
