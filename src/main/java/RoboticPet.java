public abstract class RoboticPet extends VirtualPet{
    protected int rustLevel;
    protected int batterHealth;
    protected int artificialIntellect;
    public RoboticPet(String name, int energy, int rustLevel, int batterHealth, int artificialIntellect) {
        super(name, energy);
        this.rustLevel = rustLevel;
        this.batterHealth = batterHealth;
        this.artificialIntellect = artificialIntellect;
    }

    public int getArtificialIntellect() {
        return artificialIntellect;
    }
    public int getRustLevel() {
        return rustLevel;
    }
    public int getBatterHealth() {
        return batterHealth;
    }
    

    @Override
    public void play(){
        if(energy>3){
            energy = energy - 3;
            artificialIntellect = artificialIntellect + 1;
            rustLevel = rustLevel + 1;
            System.out.print(getName() + " is playing");
        }
        else{
            batterHealth = batterHealth - 1;
            System.out.println(getName()+ " doesn't have enough energy to play!");
            System.out.println(getName()+" lost some battery health.");
            System.out.println("try recharging "+ getName());
        }
    }
    @Override
    public void eval(){
        System.out.println("...");
        if(rustLevel>4){
            batterHealth = batterHealth - 1;
            System.out.println(getName() + " has accumulated some rust.");
            System.out.println("You should clean your pet.");
        }
        else if(rustLevel>6){
            batterHealth = batterHealth - 5;
            System.out.println(getName() + " is very rusty.");
            System.out.println("It is important that you clean your pet!");
        }
        else if(rustLevel>8){
            batterHealth = batterHealth - 10;
            System.out.println(getName() + " is extremely rusty.");
            System.out.println("It is important that you clean your pet immediately!");
        }
        else if(rustLevel>10){
            batterHealth = batterHealth - 20;
            System.out.println(getName() + " can barely move because of how rusty it is.");
            System.out.println(getName() + " will break if you don't clean it soon.");
        }
    }
    @Override
    public void info(){
        System.out.println("Rust: " + getRustLevel());
        System.out.println("AI: " + getArtificialIntellect());
        System.out.println("Energy: "+getEnergy());
        System.out.println("Battery Health: "+getBatterHealth());
    }

    public void clean(){
        rustLevel = 0;
        System.out.println("Scrub Scrub Scrub");
        System.out.println("Good as new!");
    }
    public void recharge(){
        energy = 10 + artificialIntellect;
        System.out.println("Charging...");
        System.out.println(getName() + " is fully charged!");
    }
    public void working(){
        if(batterHealth<1){
            System.out.println("Pet broke");
            System.exit(0);
        }
    }
}
