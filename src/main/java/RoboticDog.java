public class RoboticDog extends RoboticPet implements WalkInterface{

    public RoboticDog(String name, int energy, int rustLevel, int batterHealth, int artificialIntellect) {
        super(name, energy, rustLevel, batterHealth, artificialIntellect);
    }

    public void BackFlip(){
        if(energy>10){
            energy = energy - 10;
            rustLevel = 0;
            batterHealth = 100;
            artificialIntellect = artificialIntellect + 1;
            System.out.println("WOW");
            System.out.println(getName() + " just did a backflip!!!!!");
            System.out.println("in doing so " + getName() + " shook off the rust, got more intelligent, and repaired any damages to its battery health!");
        }
        else{
            System.out.println(getName() + " doesn't have enough energy for that!");
            System.out.println(getName() + " lost some battery health!");
            batterHealth = batterHealth - 10;
        }
    }
    public void walk(){
        if(energy>2){
            energy = energy -2;
            artificialIntellect = artificialIntellect + 1;
            rustLevel = rustLevel + 1;
            System.out.println("You took " + getName() + " on a walk.");
        }
        else{
            batterHealth = batterHealth - 1;
            System.out.println(getName() + " doesn't have enough energy for that!");
        }
    }
}
