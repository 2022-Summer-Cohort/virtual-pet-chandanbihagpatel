package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void introduction() {
        System.out.println("ʕ•ᴥ•ʔ" + "  ᕙ(`▿´)ᕗ" + "  ʕ•ᴥ•ʔ");
        System.out.println("Welcome to Virtual Pet!");
        System.out.println("Create a pet.");
    }

    public static String[] CreatePet() {
        String[] petInfo = new String[5];
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        String petName = input.nextLine();
        System.out.println("Fur color: ");
        String petColor = input.nextLine();
        System.out.println("Age: ");
        int petAge = input.nextInt();
        String age = Integer.toString(petAge);
        input.nextLine();
        int petHealth = 0;
        if (petAge > 10) {
            petHealth = 3;
        } else if (petAge > 5) {
            petHealth = 4;
        } else {
            petHealth = 5;
        }

        int petNumRep = 0;
        System.out.println("Is " + petName + " a good or bad pet?");
        String petGoodOrBad = input.nextLine();
        if (petGoodOrBad.equals("good")) {
            petNumRep = 1;
        } else {
            petNumRep = -1;
        }
        String petRep = Integer.toString(petNumRep);
        String petHp = Integer.toString(petHealth);
        petInfo[0] = petName;
        petInfo[1] = petColor;
        petInfo[2] = age;
        petInfo[3] = petRep;
        petInfo[4] = petHp;
        return petInfo;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        introduction();
        int loop = 0;
        VirtualPet myPet = null;
        String[] finalPetInfo = new String[5];
        int petAge = 0;
        int petNumRep = 0;
        int petHealth = 0;
        while (loop == 0) {
            String[] petInfo = CreatePet();
            petAge = Integer.parseInt(petInfo[2]);
            petNumRep = Integer.parseInt(petInfo[3]);
            petHealth = Integer.parseInt(petInfo[4]);

            myPet = new VirtualPet(petInfo[0], petInfo[1], petAge, petNumRep, petHealth);
            VirtualPet mittens = new VirtualPet("Mittens", "Brown", 12, 0, 50000);
            myPet.introMessage();
            String isCorrect = input.nextLine();
            if (isCorrect.equals("yes")) {
                loop++;
                finalPetInfo = petInfo;
            }
        }
        GameLoop(finalPetInfo, petAge, petNumRep, petHealth);
    }
    public static void GameLoop(String[] petInfo, int petAge, int petNumRep, int petHealth){
       VirtualPet myPet = new VirtualPet(petInfo[0], petInfo[1], petAge, petNumRep, petHealth);
       Scanner input = new Scanner(System.in);
        int x = 0;
        int day = 1;
        while(x < 1) {
            System.out.println("");
            System.out.println("Day " + day + ".");
            myPet.healthInfo();
            myPet.repInfo();
            System.out.println("What would you like your pet to do. (walk, eat, sleep, bite)");
            String petAction = input.nextLine();
            if(petAction.equals("sleep")){
                day++;
            }
            if(petAction.equals("stop")){
                break;
            }
            int newEnergy = myPet.actionHealth(petAction);
            int newNumRep = myPet.actionRep(petAction);
            if(newEnergy<0){
                System.out.println(myPet.getName()+" doesn't have enough energy to " + petAction + ".");
            }
            else {
                myPet.actionStatement(petAction);
                myPet = new VirtualPet(myPet.getName(), myPet.getFurColor(), myPet.getAge(), newNumRep, newEnergy);
            }

            if (myPet.getNumHealth() <= 0) {
                System.out.println("Your pet doesn't have enough energy to do anything else today.");
                newEnergy = myPet.actionHealth("sleep");
                myPet.actionStatement("sleep");
                myPet = new VirtualPet(myPet.getName(), myPet.getFurColor(), myPet.getAge(), newNumRep, newEnergy);
                day++;
            }
            if (newNumRep < -5) {
                System.out.println("OH NO. You're pet has been sent to the pound!");
                x++;
            }
        }
    }

}
