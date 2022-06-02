import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) {
        VirtualPetShelter myShelter = new VirtualPetShelter();
        Scanner input = new Scanner(System.in);
        introduction();
        String wantNewPet = input.nextLine();
        wantNewPet = wantNewPet.toUpperCase();
        if(wantNewPet.equals("YES")){
            VirtualPet newPet = createPets();
            myShelter.addPet(newPet);
            System.out.println("You have successfully added " + newPet.getPetName() + " to the shelter!" );
        }
        else{
            System.out.println("Okay. Not a problem. There are already 2 pets in the shelter for you to play with.");
        }
        VirtualPet dog = new VirtualPet("Chan", 2, 0, 4);
        VirtualPet cat = new VirtualPet("Wiskers", 2, 0,4);
        myShelter.addPet(dog);
        myShelter.addPet(cat);
        int loop = 0;
        while(loop == 0) {
            System.out.println("...");
            System.out.println("What would you like to do?");
            System.out.println("Type " + '\u201C' + "help" + '\u201D' + " for a list of commands.");
            String command = input.nextLine();
            if (command.equals("help")) {
                System.out.println("...");
                helpInfo();
            }
            else if(command.equals("visit")){
                gameLoopAll(myShelter);
                loop++;
            }
            else if(command.equals("adopt")){
                System.out.println("Which pet do you want to adopt?");
                String adoptPets = input.nextLine();
                VirtualPet adoptedPet = myShelter.adoptPet(adoptPets);
                if(adoptedPet.getPetName().equals("null")){
                    System.out.println("Pet not found.");
                    System.out.println("Try again.");
                }
                else {
                    myShelter.removePet(adoptPets);
                    gameLoopExclusive(adoptedPet);
                    loop++;
                }
            }
            else if(command.equals("stop")){
                loop++;
            }
            else{
                System.out.println("Command not found.");
            }
        }

    }
    public static void introduction(){
        System.out.println("Welcome to the Virtual Pet Shelter!");
        System.out.println("");
        System.out.println("There are 2 pets in the shelter. Would you like to add another?");
        System.out.println("Type: yes or no.");

    }
    public static VirtualPet createPets(){
        Scanner input = new Scanner(System.in);
        String[] myArr = new String[2];
        System.out.println("Name:");
        String petName = input.nextLine();
        System.out.println("age:");
        int petAge = input.nextInt();
        input.nextLine();
        System.out.println("...");
        VirtualPet newPet = new VirtualPet(petName, petAge, 0, 4);
        return newPet;
    }
    public static void helpInfo(){
        System.out.println("visit:  Visit the shelter and play with all of the pets.");
        System.out.println("adopt:  adopt a pet to take home and play with exclusively");
        System.out.println("stop:   ends the program.");
    }
    public static void gameLoopExclusive(VirtualPet myPet){
        Scanner input = new Scanner(System.in);
        int loop = 0;
        System.out.println("Congrats on your new pet!");
        while(loop == 0) {
            System.out.println("...");
            System.out.println("What would you like to do with your pet?");
            System.out.println("Type " + '\u201C' + "help" + '\u201D' + " for a list of commands.");
            String command = input.nextLine();
            if (command.equals("help")) {
                System.out.println("...");
                loopInfo();
            } else if (command.equals("play")) {
                myPet.playPet();
                System.out.println("");
                myPet.info();
                System.out.println("...");
            } else if (command.equals("feed")) {
                myPet.feedPet();
                myPet.info();
                System.out.println("...");
            } else if (command.equals("sleep")) {
                myPet.sleep();
                myPet.info();
                System.out.println("...");
            }
            else if(command.equals("stop")){
                loop++;
                System.out.println("...");
            }
            else{
                System.out.println("Command not found.");
                System.out.println("...");
            }


        }



    }
    public static void loopInfo(){
        System.out.println("play:   play with the pet.");
        System.out.println("feed:   feed the pet.");
        System.out.println("sleep:  puts the pet to sleep.");
        System.out.println("Stop:   ends the program.");
        System.out.println("Adopt:   adopt a pet if you haven't already.");
    }
    public static void gameLoopAll(VirtualPetShelter myShelter){
        Scanner input = new Scanner(System.in);
        int loop = 0;
        while(loop == 0) {
            System.out.println("...");
            System.out.println("What would you like to do at the shelter?");
            System.out.println("Type " + '\u201C' + "help" + '\u201D' + " for a list of commands.");
            String command = input.nextLine();
            if (command.equals("help")) {
                System.out.println("...");
                loopInfo();
            }
            else if(command.equals("adopt")){
                System.out.println("Which pet do you want to adopt?");
                String adoptPets = input.nextLine();
                VirtualPet adoptedPet = myShelter.adoptPet(adoptPets);
                if(adoptedPet.getPetName().equals("null")){
                    System.out.println("Pet not found.");
                    System.out.println("Try again.");
                }
                else {
                    myShelter.removePet(adoptPets);
                    gameLoopExclusive(adoptedPet);
                    loop++;
                }
            }
            else if (command.equals("play")) {
                myShelter.playAll();
                myShelter.infoAll();
            } else if (command.equals("feed")) {
                myShelter.feedAll();
                myShelter.infoAll();
            } else if (command.equals("sleep")) {
                myShelter.sleepAll();
                myShelter.infoAll();
            }
            else if(command.equals("stop")){
                loop++;
            }
            else{
                System.out.println("Command not found.");
            }


        }



    }

}

