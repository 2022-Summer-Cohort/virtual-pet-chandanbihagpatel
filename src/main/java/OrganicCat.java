public class OrganicCat extends OrganicPet implements ClimbInterface{
    private int numLives;
    private int independence;

    public OrganicCat(String name, int energy, int petHealth, int hungerLevel, int thirstLevel, int petHappiness, int numLives, int independence) {
        super(name, energy, petHealth, hungerLevel, thirstLevel, petHappiness);
        this.numLives = numLives;
        this.independence = independence;
    }

    public int getNumLives() {
        return numLives;
    }

    public int getIndependence() {
        return independence;
    }
    public void climb(){
        if(energy>5){
            energy = energy -5;
            independence = independence + 5;
            hungerLevel = hungerLevel -1;
            System.out.println(getName() + " climbs up a tree.");
        }
        else{
            independence = independence - 1;
            System.out.println(getName() + " doesn't have enough energy to climb!");
            System.out.println(getName()+ " lost some independence.");
        }
    }

    @Override
    public void play(){
        if(energy<2){
            independence = independence-2;
            hungerLevel = hungerLevel +1;
            thirstLevel = thirstLevel +1;
            System.out.println(getName() + " doesn't have enough energy to play!");
            System.out.println(getName() + " lost some independence.");
            sleep();
        }
        else {
            hungerLevel = hungerLevel + 4;
            energy = energy - 2;
            thirstLevel = thirstLevel + 10;
            independence = independence + 10;
            System.out.print(getName() + " is playing");
        }

    }
    @Override
    public void eval() {
        System.out.println("...");
        if(hungerLevel>13){
            independence = independence - (hungerLevel);
            System.out.println(getName() + " is very hungry!");
            System.out.println("You should feed your pet!");
        }
        else if(hungerLevel>8){
            System.out.println(getName() + " is hungry.");
        }
        else{
            independence = independence + 1;
        }
        if(thirstLevel>20){
            independence = independence - (thirstLevel);
            System.out.println(getName() + " is very thirsty!");
            System.out.println("Your pet needs to drink!");
        }
        else if(thirstLevel>15){
            System.out.println(getName() + " is thirsty.");
        }
        else{
            independence = independence + 1;
        }
        if(independence>40 && hungerLevel>1 && thirstLevel>1){
            hungerLevel = hungerLevel -1;
            thirstLevel = thirstLevel -1;
            System.out.println(getName() + " is independent.");
        }
        else{
            independence = independence - 1;
            System.out.println(getName() + " is dependent on you.");
        }
    }
    @Override
    void info() {
        System.out.println("Energy: " + getEnergy());
        System.out.println("Hunger: " + getHungerLevel());
        System.out.println("Thirst" + getThirstLevel());
        System.out.println("independence" + getIndependence());
        System.out.println("Happiness: " + getPetHappiness());
        System.out.println("Health: " + getPetHealth());
        System.out.println("Lives: " + getNumLives());


    }
    @Override
    public void healthCalc(){
        int x = (independence * petHappiness)/2;
        double y = Math.pow(x, 0.5);
        petHealth = (int) Math.round(y);
        if(petHealth<1){
            numLives = numLives - 1;
            petHealth = 100;
            petHappiness = 400;
            independence = 50;
        }
    }
    @Override
    public void death(){
        if(numLives<1){
            System.out.println("Pet died");
            System.exit(0);
        }
    }
}

