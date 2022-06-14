import java.awt.*;

public abstract class OrganicPet extends VirtualPet{
    protected int petHealth;
    protected int hungerLevel;
    protected int thirstLevel;
    protected int petHappiness;

    public OrganicPet(String name, int energy, int petHealth, int hungerLevel, int thirstLevel, int petHappiness) {
        super(name, energy);
        this.petHealth = petHealth;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.petHappiness = petHappiness;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }
    public int getPetHappiness() {
        return petHappiness;
    }
    public int getPetHealth() {
        return petHealth;
    }
    public int getHungerLevel() {
        return hungerLevel;
    }


    public void feed(){
        if(hungerLevel>5 && energy>0){
            energy = energy - 1;
            hungerLevel = hungerLevel - 5;
            thirstLevel = thirstLevel + 1;
            System.out.println("Eating");
            System.out.println("...");
        }
        else{
            System.out.println("Not hungry");
            System.out.println("Your pet is upset that you forced food on it.");
            petHappiness = petHappiness - (hungerLevel * 2);
            thirstLevel = thirstLevel + 1;
        }
    }
    abstract void death();
    public void sleep() {
        if(energy<5) {
            hungerLevel = hungerLevel + 5;
            thirstLevel = thirstLevel + 5;
            energy = 10;
            System.out.println(getName() + " fell asleep.");
            System.out.println("ZZZ");
            System.out.println(getName()+ " had its energy reset.");
        }
        else{
            petHappiness = petHappiness - energy;
            hungerLevel = hungerLevel + 10;
            thirstLevel = thirstLevel + 10;
            energy = 10;
            System.out.println(getName() + " isn't tired but you forced it to sleep.");
            System.out.println(getName() + " got angry");
        }
    }
    public void drink(){
        if(thirstLevel<5){
            petHappiness = petHappiness - hungerLevel;
            energy = energy - 1;
            hungerLevel = hungerLevel + 1;
            thirstLevel = thirstLevel + 1;
            System.out.println(getName() + " isn't thirsty!");
            System.out.println(getName() + " is upset that you forced water on it.");
        }
        else{
            thirstLevel = thirstLevel/2;
            hungerLevel = hungerLevel + 1;
            energy = energy - 1;
            System.out.println(getName() + " is drinking.");
            System.out.println("...");
        }
    }
    abstract void healthCalc();
    public void healthDisplay(){

    }
}
