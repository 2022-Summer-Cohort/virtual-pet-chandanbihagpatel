public class RoboticCat extends RoboticPet implements ClimbInterface{

    public RoboticCat(String name, int energy, int rustLevel, int batterHealth, int artificialIntellect) {
        super(name, energy, rustLevel, batterHealth, artificialIntellect);
    }

    public void climb(){
        if(energy>10){
            energy = energy - 10;
            rustLevel = 0;
            artificialIntellect = artificialIntellect + 5;
            batterHealth = batterHealth + 1;
            System.out.println(getName() + " just climbed up a tree!");
        }
        else{
            batterHealth = batterHealth - 2;
            System.out.println(getName() + " doesn't have enough energy for that!");
            System.out.println(getName() +"'s battery was damaged.");
        }
    }
}
