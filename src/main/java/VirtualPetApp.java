import java.util.Locale;
import java.util.Scanner;
import java.awt.*;

public class VirtualPetApp {
    public static void main(String[] args) {
        VirtualPetShelter myShelter = new VirtualPetShelter();
        Scanner input = new Scanner(System.in);
        introduction();
        String wantNewPet = input.nextLine();
        wantNewPet = wantNewPet.toUpperCase();
        if(wantNewPet.equals("YES")){
            VirtualPet myPet = CreatePet();
            myShelter.addPet(myPet);
            System.out.println("You have successfully added " + myPet.getName() + " to the shelter!" + "\u2661");
        }
        else{
            System.out.println("Okay. Not a problem. There are already a few pets in the shelter for you to play with.");
        }
        VirtualPet orgDog = new OrganicDog("Woof", 10, 100, 0, 0, 400, 50);
        VirtualPet orgCat = new OrganicCat("meow", 10, 100, 0, 0, 400, 9, 50);
        VirtualPet robCat = new RoboticCat("Wiskers", 10, 0, 100, 0);
        VirtualPet robDog = new RoboticDog("Goofy", 10, 0, 100, 0);
        myShelter.addPet(orgDog);
        myShelter.addPet(orgCat);
        myShelter.addPet(robCat);
        myShelter.addPet(robDog);
        GameLoopAll(myShelter);
    }
    public static void introduction(){
        System.out.println("Welcome to the Virtual Pet Shelter!");
        System.out.println("");
        System.out.println("There are 4 pets in the shelter. Would you like to add another?");
        System.out.println("Type: yes or no.");

    }
    public static void OrganicDogGameLoop(VirtualPet myPet, VirtualPetShelter myShelter){
        Scanner input = new Scanner(System.in);
        int x = 0;
        while(x == 0){
            System.out.println("What do you want to do with " + myPet.getName() + "?");
            String command = input.nextLine();
            if(command.equals("play")){
                myPet.play();
                myPet.eval();
                ((OrganicDog)myPet).healthCalc();
                myPet.info();
                ((OrganicPet)myPet).death();

            }
            else if(command.equals("sleep")){
                    ((OrganicDog)myPet).sleep();
                    myPet.eval();
                    ((OrganicDog)myPet).healthCalc();
                    myPet.info();
                    ((OrganicDog)myPet).death();
            }
            else if(command.equals("feed")){
                    ((OrganicDog) myPet).feed();
                    myPet.eval();
                    ((OrganicDog) myPet).healthCalc();
                    myPet.info();
                    ((OrganicDog) myPet).death();
            }
            else if(command.equals("drink")){
                    ((OrganicDog) myPet).drink();
                    myPet.eval();
                    ((OrganicDog) myPet).healthCalc();
                    myPet.info();
                    ((OrganicDog) myPet).death();
            }
            else if(command.equals("walk")){
                    ((OrganicDog) myPet).walk();
                    myPet.eval();
                    ((OrganicDog) myPet).healthCalc();
                    myPet.info();
                    ((OrganicDog) myPet).death();
            }
            else if(command.equals("info")){
                myPet.info();
            }
            else if(command.equals("add")){
                myShelter.addPet(myPet);
                GameLoopAll(myShelter);
            }
            else if(command.equals("help")){
                GlodInfo();
            }
            else{
                System.out.println("Command not found.");
                System.out.println("Try help.");
            }
        }
    }
    public static void OrganicCatGameLoop(VirtualPet myPet, VirtualPetShelter myShelter){
        Scanner input = new Scanner(System.in);
        int x = 0;
        while(x == 0){
            System.out.println("What do you want to do with " + myPet.getName() + "?");
            String command = input.nextLine();
            if(command.equals("play")){
                myPet.play();
                myPet.eval();
                ((OrganicCat)myPet).healthCalc();
                myPet.info();
                ((OrganicCat)myPet).death();

            }
            else if(command.equals("sleep")){
                ((OrganicCat)myPet).sleep();
                myPet.eval();
                ((OrganicCat)myPet).healthCalc();
                myPet.info();
                ((OrganicCat)myPet).death();
            }
            else if(command.equals("feed")){
                ((OrganicCat) myPet).feed();
                myPet.eval();
                ((OrganicCat) myPet).healthCalc();
                myPet.info();
                ((OrganicCat) myPet).death();
            }
            else if(command.equals("drink")){
                ((OrganicCat) myPet).drink();
                myPet.eval();
                ((OrganicCat) myPet).healthCalc();
                myPet.info();
                ((OrganicCat) myPet).death();
            }
            else if(command.equals("info")){
                myPet.info();
            }
            else if(command.equals("add")){
                myShelter.addPet(myPet);
                GameLoopAll(myShelter);
            }
            else if(command.equals("climb")){
                ((OrganicCat) myPet).climb();
                myPet.eval();
                ((OrganicCat) myPet).healthCalc();
                myPet.info();
                ((OrganicCat) myPet).death();
            }
            else if(command.equals("help")){
                GlocInfo();
            }
            else{
                System.out.println("Command not found.");
                System.out.println("Try help.");
            }
        }
    }
    public static void RoboticDogGameLoop(VirtualPet myPet, VirtualPetShelter myShelter){
        Scanner input = new Scanner(System.in);
        int x = 0;
        while(x == 0){
            System.out.println("What do you want to do with " + myPet.getName() + "?");
            String command = input.nextLine();
            if(command.equals("play")){
                myPet.play();
                myPet.eval();
                myPet.info();
                ((RoboticDog)myPet).working();

            }
            else if(command.equals("recharge")){
                ((RoboticDog)myPet).recharge();
                myPet.eval();
                myPet.info();
                ((RoboticDog)myPet).working();
            }
            else if(command.equals("clean")){
                ((RoboticDog) myPet).clean();
                myPet.eval();
                myPet.info();
                ((RoboticDog)myPet).working();
            }
            else if(command.equals("walk")){
                ((RoboticDog) myPet).walk();
                myPet.eval();
                myPet.info();
                ((RoboticDog)myPet).working();
            }
            else if(command.equals("backflip")){
                ((RoboticDog) myPet).BackFlip();
                myPet.eval();
                myPet.info();
                ((RoboticDog)myPet).working();
            }

            else if(command.equals("info")){
                myPet.info();
            }
            else if(command.equals("add")){
                myShelter.addPet(myPet);
                GameLoopAll(myShelter);
            }
            else if(command.equals("help")){
                GlrdInfo();
            }
            else{
                System.out.println("Command not found.");
            }
        }
    }
    public static void RoboticCatGameLoop(VirtualPet myPet, VirtualPetShelter myShelter){
        Scanner input = new Scanner(System.in);
        int x = 0;
        while(x == 0){
            System.out.println("What do you want to do with " + myPet.getName() + "?");
            String command = input.nextLine();
            if(command.equals("play")){
                myPet.play();
                myPet.eval();
                myPet.info();
                ((RoboticCat)myPet).working();

            }
            else if(command.equals("recharge")){
                ((RoboticCat)myPet).recharge();
                myPet.eval();
                myPet.info();
                ((RoboticCat)myPet).working();
            }
            else if(command.equals("clean")){
                ((RoboticCat) myPet).clean();
                myPet.eval();
                myPet.info();
                ((RoboticCat)myPet).working();
            }
            else if(command.equals("climb")){
                ((RoboticCat) myPet).climb();
                myPet.eval();
                myPet.info();
                ((RoboticCat)myPet).working();
            }

            else if(command.equals("info")){
                myPet.info();
            }
            else if(command.equals("add")){
                myShelter.addPet(myPet);
                GameLoopAll(myShelter);
            }
            else if(command.equals("help")){
                GlrcInfo();
            }
            else{
                System.out.println("Command not found.");
            }
        }
    }
    public static void GameLoopAll(VirtualPetShelter myShelter) {
        Scanner input = new Scanner(System.in);
        int loop = 0;
        while (loop == 0) {
            System.out.println("What would you like to do at the shelter?");
            String command = input.nextLine();
            command = command.toUpperCase();
            if (command.equals("PLAY")) {
                myShelter.playAll();
            } else if (command.equals("ADOPT")) {
                System.out.println("Which pet do you want to adopt?");
                String adoptPets = input.nextLine();
                VirtualPet adoptedPet = myShelter.adoptPet(adoptPets);
                if (adoptedPet.getName().equals("Null")) {
                    System.out.println("Pet not found.");
                    System.out.println("Try again.");
                } else {
                    myShelter.removePet(adoptPets);
                    directToGameLoop(adoptedPet, myShelter);
                }
            } else if (command.equals("LIST")) {
                myShelter.listAll();
            }
            else if(command.equals("HELP")){
                GlaInfo();
            }
            else{
                System.out.println("Command not found!");
                System.out.println("Try help.");
            }
        }
    }


    public static VirtualPet CreatePet() {
        int loop = 0;
        while (loop == 0) {
            String name = "";
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to create an organic or robotic pet?");
            String typeOfPet = input.nextLine();
            typeOfPet = typeOfPet.toUpperCase();
            if (typeOfPet.equals("ORGANIC")) {
                System.out.println("Would you like to create a dog or cat?");
                String organicType = input.nextLine();
                organicType = organicType.toUpperCase();
                if (organicType.equals("DOG")) {
                    System.out.println("Name: ");
                    name = input.nextLine();
                    VirtualPet myPet = new OrganicDog(name, 10, 100, 0, 0, 400, 50);
                    return myPet;
                } else if (organicType.equals("CAT")) {
                    System.out.println("Name: ");
                    name = input.nextLine();
                    VirtualPet myPet = new OrganicCat("meow", 10, 100, 0, 0, 400, 9, 50);
                    return myPet;
                } else {
                    System.out.println("Command not found.");
                }
            } else if (typeOfPet.equals("ROBOTIC")) {
                System.out.println("Would you like to create a dog or cat?");
                String roboticType = input.nextLine();
                roboticType = roboticType.toUpperCase();
                if (roboticType.equals("DOG")) {
                    System.out.println("Name: ");
                    name = input.nextLine();
                    VirtualPet myPet = new RoboticDog(name, 10, 0, 100, 0);
                    return myPet;
                } else if (roboticType.equals("CAT")) {
                    System.out.println("Name: ");
                    name = input.nextLine();
                    VirtualPet myPet = new RoboticCat(name, 10, 0, 100, 0);
                    return myPet;
                } else {
                    System.out.println("Command not found.");
                }
            } else {
                System.out.println("Command not found.");
            }
        }
        return null;
    }
    public static void GlaInfo(){
        System.out.println("adopt:  adopt a pet to take home and play with exclusively");
        System.out.println("Play:   play with all of the pets in the shelter.");
        System.out.println("list:   lists out all of the names of pets in the shelter.");
    }
    public static void GlodInfo(){
        System.out.println("Play:   play with your pet.");
        System.out.println("Sleep:  Resets energy.");
        System.out.println("Feed:   Feed your pet.");
        System.out.println("drink:  make your pet drink water.");
        System.out.println("Walk:   take your pet on a walk.");
        System.out.println("add:    add your pet to the pet shelter.");
        System.out.println("Info:   Provides the current stats of your pet.");
    }
    public static void GlocInfo(){
        System.out.println("Play:   play with your pet.");
        System.out.println("Sleep:  Resets energy.");
        System.out.println("Feed:   Feed your pet.");
        System.out.println("drink:  make your pet drink water.");
        System.out.println("climb:  your pet climbs up a tree.");
        System.out.println("add:    add your pet to the pet shelter.");
        System.out.println("Info:   Provides the current stats of your pet.");
    }
    public static void GlrdInfo(){
        System.out.println("Play:     Play with your pet.");
        System.out.println("Clean:    clean the rust off of your pet.");
        System.out.println("recharge: resets energy.");
        System.out.println("backflip: your pet performs a backflip.");
        System.out.println("walk:     take your pet on a walk.");
        System.out.println("Add:      add pet to the pet shelter.");
        System.out.println("Info:     lists the current stats of your pet.");
    }
    public static void GlrcInfo(){
        System.out.println("Play:     Play with your pet.");
        System.out.println("Clean:    clean the rust off of your pet.");
        System.out.println("recharge: resets energy.");
        System.out.println("climb:    your pet climbs up a tree.");
        System.out.println("Add:      add pet to the pet shelter.");
        System.out.println("Info:     lists the current stats of your pet.");
    }
    public static void directToGameLoop(VirtualPet myPet, VirtualPetShelter myShelter){
        if(myPet instanceof OrganicCat){
            OrganicCatGameLoop(myPet, myShelter);
        }
        else if(myPet instanceof OrganicDog){
            OrganicDogGameLoop(myPet, myShelter);
        }
        else if(myPet instanceof RoboticDog){
            RoboticDogGameLoop(myPet, myShelter);
        }
        else if(myPet instanceof RoboticCat){
            RoboticCatGameLoop(myPet, myShelter);
        }
    }
}
