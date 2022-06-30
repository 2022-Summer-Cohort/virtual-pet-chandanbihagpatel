public class OrganicDog extends OrganicPet implements WalkInterface{
    private int petLoyalty;

    public OrganicDog(String name, int energy, int petHealth, int hungerLevel, int thirstLevel, int petHappiness, int petLoyalty) {
        super(name, energy, petHealth, hungerLevel, thirstLevel, petHappiness);
        this.petLoyalty = petLoyalty;
    }

    public int getPetLoyalty() {
        return petLoyalty;
    }

    public void walk() {
        if(energy>3){
            energy = energy  - 3;
            hungerLevel = hungerLevel + 3;
            thirstLevel = thirstLevel + 6;
            petHappiness = petHappiness + (energy*2);
            System.out.println("You took " + getName() + " for a walk.");
            System.out.println("Walking");
            System.out.println("...");
        }
        else{
            petHappiness = petHappiness - (hungerLevel + thirstLevel);
            hungerLevel = hungerLevel + 6;
            thirstLevel = thirstLevel + 9;
            energy = energy  - 1;
            System.out.println(getName() + " doesn't have enough energy to walk.");
            System.out.println(getName() + " is upset at you for being forceful.");
        }

    }

    @Override
    public void play(){
        if(energy<2){
            petLoyalty = petLoyalty-1;
            hungerLevel = hungerLevel +1;
            thirstLevel = thirstLevel +1;
            System.out.println(getName() + " doesn't have enough energy to play!");
            System.out.println(getName() + " lost some loyalty.");
            sleep();
        }
        else {
            hungerLevel = hungerLevel + 2;
            energy = energy - 2;
            thirstLevel = thirstLevel + 10;
            petLoyalty = petLoyalty + 10;
            System.out.print(getName() + " is playing");
        }

    }
    @Override
    public void eval() {
        System.out.println("...");
        if(hungerLevel>13){
            petLoyalty = petLoyalty - (hungerLevel/2);
            System.out.println(getName() + " is in dire need for food!");
        }
        else if(hungerLevel>10){
            System.out.println(getName() + " is very hungry!");
        }
        else if(hungerLevel>6){
            System.out.println(getName() + " is hungry.");
        }
        else{
            petLoyalty = petLoyalty + 1;
            System.out.println(getName() + " is well fed.");
        }
        if(thirstLevel>20){
            petLoyalty = petLoyalty - (thirstLevel/2);
            System.out.println(getName() + " is dehydrated!");
        }
        else if(thirstLevel>15){
            System.out.println(getName() + " is very thirsty.");
        }
        else if(thirstLevel>11){
            System.out.println(getName() + " is thirsty.");
        }
        else{
            petLoyalty = petLoyalty + 1;
            System.out.println(getName() + " is hydrated!");
        }
        if(petLoyalty>40){
            petLoyalty = petLoyalty +1;
        }
        else{
            petLoyalty = petLoyalty - 1;
        }
    }
    @Override
    void info() {
        System.out.println("Energy: " + getEnergy());
        System.out.println("Hunger: " + getHungerLevel());
        System.out.println("Thirst" + getThirstLevel());
        System.out.println("Loyalty" + getPetLoyalty());
        System.out.println("Happiness: " + getPetHappiness());
        System.out.println("Health: " + getPetHealth());


    }
    @Override
    public void healthCalc(){
        int x  = (petLoyalty * petHappiness)/2;
        double y = Math.pow(x, 0.5);
        petHealth = (int) Math.round(y);
    }
    @Override
    public void death(){
        if(petHealth<1) {
            System.out.println("Pet died");
            System.exit(0);
        }

    }
}
