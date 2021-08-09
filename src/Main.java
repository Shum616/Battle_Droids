import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Start();
    }
    //створення необхідного поля боя
    public static void Start() {
        Scanner in = new Scanner(System.in);
        Battlefield[] newOne = new Battlefield[4];
        newOne[0] = new City();
        newOne[1] = new Arena();
        newOne[2] = new Desert();
        newOne[3] = new Forest();
        System.out.printf("Avliable battlefields and their characteristics:\n");
        for (int i = 0; i < 4; i++) {
            System.out.printf("\n\t%d)", i + 1);
            newOne[i].display();
        }
        System.out.printf("\nWhich one would you prefer?\n");
        int num = in.nextInt();
        if (num == 1) {
            Battlefield currentOne = new City();
            ChooseTypeOfTheBattle(currentOne);
        }
        if (num == 2) {
            Battlefield currentOne = new Arena();
            ChooseTypeOfTheBattle(currentOne);
        }
        if (num == 3) {
            Battlefield currentOne = new Desert();
            ChooseTypeOfTheBattle(currentOne);
        }
        if (num == 4) {
            Battlefield currentOne = new Forest();
            ChooseTypeOfTheBattle(currentOne);
        }
    }
    //фіксація бафів від поля боя для дроїдів
    public static void BattlefieldBuff(Droid newOne, Battlefield anotherOne) {
        newOne.setMaxAttack(newOne.getMaxAttack()+ anotherOne.getCritBattle());
        newOne.setMinAttack(newOne.getMinAttack()+ anotherOne.getCritBattle());
        newOne.setEnergyPerAttack(newOne.getEnergyPerAttack()+ anotherOne.getEnergyBattle());
        newOne.setAccuracy(newOne.getAccuracy()+ anotherOne.getAccuracyBattle());
    }
    //вибір типу бою та створення відповідних команд
    public static void ChooseTypeOfTheBattle(Battlefield newOne) {
        Scanner in = new Scanner(System.in);
        System.out.printf("\n\tChoose the type of the battle (1 - оne to one, 2- team to team):\n");
        int battletype = in.nextInt();
        if (battletype == 1) {
            Droid[] fighters = new Droid[2];
            printAllDroids();
            CreateTheTeam(fighters, 2);
            BattlefieldBuff(fighters[0], newOne);
            BattlefieldBuff(fighters[1], newOne);
            int check = FigthMannGegenMann(fighters[0], fighters[1]);
            if (check == 1) {
                System.out.printf("\n\tThe first fighter won:\n");
            }else{
                System.out.printf("\n\tThe second fighter won:\n");
            }
        } if (battletype == 2) {
            System.out.printf("\n\tEnter the number of droids in teams:\n");
            int number = in.nextInt();
            while (number < 0 ) {
                System.out.printf("\n\tThe number cant be negative\n");
                System.out.printf("\n\tEnter the number of droids again\n");
                number = in.nextInt();
            }
            Droid[] crew1 = new Droid[number];
            Droid[] crew2  = new Droid[number];
            CreateTheTeams(crew1,crew2, number);
            for (int i = 0; i < number; i++) {
                BattlefieldBuff(crew1[i], newOne);
                BattlefieldBuff(crew2[i], newOne);
            }
            TeamToTeam(crew1, crew2, number);
        }
    }
    // methods for creating the teams
    //вивід доступних дроїдів
    public static void printAllDroids() {
        System.out.printf("\n\tAvailable droids:\n");
        Droid view[] = new Droid[7];
        view[0]= new Paladin();
        view[1]= new Warrior();
        view[2]= new Mechanic();
        view[3]= new Shooter();
        view[4]= new Launcher();
        view[5]= new Assassin();
        view[6]= new Herald();
        for(int i =0; i <7; i++){
            System.out.printf("\n%d) - %s" +
                            "\n\tHealth - %d" +
                            "\n\tAttack - %d-%d" +
                            "\n\tCrit - %d" +
                            "\n\tEnergy - %d" +
                            "\n\tAccurancy - %d\n",
                    i+1,  view[i].getName(), view[i].getHeath(),  view[i].getMinAttack(),  view[i].getMaxAttack(),
                    view[i].getCrit(),  view[i].getEnergy(),  view[i].getAccuracy());
        }
    }
    //створення команд
    public static void CreateTheTeams(Droid team1[], Droid team2[], int number) {
        printAllDroids();
        System.out.printf("\n\n\tCreate the thirst team:");
        CreateTheTeam(team1, number);
        System.out.printf("\n\n\tCreate the second team:");
        CreateTheTeam(team2, number);
    }
    //заповнення масиву дроїдами однієї команди
    public static void CreateTheTeam(Droid team[], int numberOfDroids){
        Scanner in = new Scanner(System.in);
        int number = 0;
        for (int i = 0; i < numberOfDroids; i++) {
            System.out.printf("\n\tEnter the type-number of %d droid:", i+1);
            number = in.nextInt();
            if (number == 1) {
                team[i] = new Paladin();
            }if (number == 2) {
                team[i] = new Warrior();
            }if (number == 3) {
                team[i] = new Mechanic();
            }if (number == 4) {
                team[i] = new Shooter();
            }if (number == 5) {
                team[i] = new Launcher();
            }if (number == 6) {
                team[i] = new Assassin();
            }if (number == 7) {
                team[i] = new Herald();
            }
        }
    }
    //цикл бою для команди, що включває в себе функцію бою один на один
    public static void TeamToTeam(Droid team1[], Droid team2[], int numberOfDroids){
        int checking=0;
        while(CheckDeadsInTeam(team1,numberOfDroids) == 1 && CheckDeadsInTeam(team2,numberOfDroids) == 1){
            for (int i = 0; i < numberOfDroids && (team2[i].getDeadOrNot() == 1 && team1[i].getDeadOrNot() == 1); i++) {
                checking = FigthMannGegenMann(team1[i], team2[i]);
                if (checking == 1) {
                    team2[i].setDeadOrNot(0);
                    team1[i].setHealth(team1[i].getMaxHeath());
                }else{
                    team1[i].setDeadOrNot(0);
                    team2[i].setHealth(team2[i].getMaxHeath());
                }
            }
            ///перерозподіл массиву
            Arrays.sort(team1);
            Arrays.sort(team2);
        }
        if ( CheckDeadsInTeam(team1,numberOfDroids) == 0) {
            System.out.printf("\n\t2-nd team won:");
        }
        if ( CheckDeadsInTeam(team2,numberOfDroids) == 0) {
            System.out.printf("\n\t1-st team won:");
        }
    }
    //цикл бою один на один поки один з дрохдів не загине
    public static int FigthMannGegenMann(Droid one, Droid two) {
        System.out.println("--------------------------------------------");
        System.out.printf("\n\tRound!:\n");
        int a = 1;
        int b = 2;
        int random_number1 = a + (int) (Math.random() * b);
        int control = 0;
        if (random_number1 == 1) {
            while (control == 0) {
                control= roundForAbilities(one, two);
                if (control == 1 || control == 2 ) {
                    break;
                }
                control = oneRound(one, two);
            }
            if (control == 1) {
                System.out.printf("\n\t%s Won!!:\n",one.getName());
                return 1;
            } else {
                System.out.printf("\n\t%s Won!!:\n",two.getName());
                return 2;
            }
        } else {
            while (control == 0) {
                control= roundForAbilities(two, one);
                if (control == 1) {
                    control = 2;
                    break;
                }
                if (control == 2) {
                    control = 1;
                    break;
                }
                control = oneRound(two, one);
            }
            if (control == 1) {
                System.out.printf("\n\t%s Won!!:\n",two.getName());
                return 2;
            } else {
                System.out.printf("\n\t%s Won!!:\n",one.getName());
                return 1;
            }
        }
    }
    // функція одного раунду: кожен дроїд робить одну атаку і по можливості використовує суператаки
    public static int oneRound(Droid one, Droid two) {
        System.out.printf("\n\t%s: health - %d\t%s: health - %d",
                one.getName(), one.getHeath(), two.getName(), two.getHeath());
        int attack1 = countTheAttack(one);
        int attack2 = countTheAttack(two);
        System.out.printf("\n\tAttack!\n\t%s: attack - %d\t%s: attack - %d",
                one.getName(), attack1, two.getName(), attack2);
        two.setHealth(two.getHeath() - attack1);
        if (two.getHeath() < 0) {
            two.setHealth(0);
            return 1;
        } else {
            if((two instanceof Herald)== true){
                ;
            } else{

                if(two.getSkipTheEnergy() > 0){
                    ;
                }
                else{
                    two.setCurrentEnergy(two.getCurrentEnergy()+two.getEnergyPerAttack());
                    if (two.getCurrentEnergy() > two.getEnergy()) {
                        two.setCurrentEnergy(two.getEnergy());
                    }
                }
            }
        }
        one.setHealth(one.getHeath() - attack2);
        if (one.getHeath() < 0) {
            one.setHealth(0);
            return 2;
        } else {
            if((one instanceof Herald)== true){
                ;
            } else{

                if(one.getSkipTheEnergy() > 0){
                    ;
                }
                else{
                    one.setCurrentEnergy(one.getCurrentEnergy()+one.getEnergyPerAttack());
                    if (one.getCurrentEnergy() > one.getEnergy()) {
                        one.setCurrentEnergy(one.getEnergy());
                    }
                }
            }
        }
        return 0;
    }
    //цикл вирахування атаки зі всіма характеристиками дроїда
    public static int countTheAttack(Droid one) {
        int min = one.getMinAttack();
        int max = one.getMaxAttack();
        int attack = min + (int) (Math.random() * max);
        int criticalChance = 1 + (int) (Math.random() * 100);
        if (criticalChance <= one.getCrit()) {
            attack *= 2;
        }
        int accurancy = 1 + (int) (Math.random() * 100);
        if (accurancy >= one.getAccuracy()) {
            attack *= 0;
        }
        if (one.getSkipTheTurn() > 0) {
            attack *= 0;
            one.setSkipTheTurn(one.getSkipTheTurn() - 1);
        }
        return attack;
    }
    //функція розподілу суперможливостей в залежності від класу дроїда
    public static int chooseTheAbilityForType(Droid one, Droid two) {
        if((one instanceof Paladin) == true){
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Punch Line is used!:\n");
            System.out.println("--------------------------------------------");
            PunchLine1(one, two);
        }
        if (one instanceof Warrior) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\t Ability Berserkir is used!:\n");
            System.out.println("--------------------------------------------");
            Berserkir2(one, two);
        }
        if (one instanceof Mechanic) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Fix`em`all is used!:\n");
            System.out.println("--------------------------------------------");
            Fix_em_all3(one, two);
        }
        if (one instanceof Shooter) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Concentration is used!:\n");
            System.out.println("--------------------------------------------");
            Concentration4(one, two);
        }
        if (one instanceof Launcher) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Ka-Boom is used!:\n");
            System.out.println("--------------------------------------------");
            KaBoom5(one, two);
        }
        if (one instanceof Assassin) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Sucker Punch is used!:\n");
            System.out.println("--------------------------------------------");
            SuckerPunch6(one, two);
        }
        if (one instanceof Herald) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("\n\t Ability Rise and Shine is used!:\n");
            System.out.println("--------------------------------------------");
            Rise_and_Shine7(one, two);
        }
        if (one.getHeath() == 0) {
            return 1;
        } if (two.getHeath() == 0){
            return 2;
        }
        return 0;
    }
    //перевірка чи живий ще хоч один дроїд в команді
    public static int CheckDeadsInTeam(Droid team[], int numberOfDroids){
        for (int i = 0; i < numberOfDroids; i++) {
            if (team[i].getDeadOrNot() == 1) {
                return 1;//smb alive
            }
        }
        return 0;//all are dead
    }
//abilities for different droids
//суперможливості для всіх класів дроїдів
    /////////////////////////////////////////////////////////////////////////////////////////////
    public static void PunchLine1(Droid one, Droid two) {
        int attack = one.getMaxAttack()*2;
        countHealthOfAttackedDroid(two, attack);
        two.setSkipTheTurn(2);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void Berserkir2(Droid one, Droid two) {
        int attack = one.getMaxAttack()*3;
        countHealthOfAttackedDroid(two, attack);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void Fix_em_all3(Droid one, Droid two) {
        int newHealth = two.getMaxHeath()/8;
        countHealthOfAttackedDroid(two, newHealth);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void Concentration4(Droid one,  Droid two) {
        int attack =  countTheAttack(one);
        int criticalChance = 1 + (int) (Math.random() * 100);
        if (criticalChance <= 50) {
            attack *= 2;
        }
        criticalChance = 1 + (int) (Math.random() * 100);
        if (criticalChance <= 50) {
            attack *= 2;
        }
        countHealthOfAttackedDroid(two, attack);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void KaBoom5(Droid one, Droid two) {
        int attack =  countTheAttack(one);
        attack *= 5;
        countHealthOfAttackedDroid(two, attack);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void SuckerPunch6(Droid one, Droid two) {
        int attack = one.getMaxAttack()*2;
        countHealthOfAttackedDroid(two, attack);
        two.setSkipTheEnergy(2);
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void Rise_and_Shine7(Droid one, Droid two) {
        int newEnergy = two.getEnergy()/2;
        two.setCurrentEnergy(two.getCurrentEnergy() - newEnergy);
        if(two.getCurrentEnergy() < 0){
            two.setCurrentEnergy(0);
        }
        one.setCurrentEnergy(one.getCurrentEnergy() - one.getEnergyPerAbility());
    }
    public static void countHealthOfAttackedDroid(Droid one, int attack) {
        one.setHealth(one.getHeath()-attack);
        if (one.getHeath() < 0){
            one.setHealth(0);
        }
    }
    ///special methods for superabilities
    //превірка чи достатньо енергіїї для суперможливостей
    public static int checkTheEnergyForAbility(Droid one) {
        if (one.getCurrentEnergy() >= one.getEnergyPerAbility()) {
            return 1;
        }
        return 0;
    }
    // окремий цикл для використання суперможливостей в одному раунді
    public static int roundForAbilities(Droid one, Droid two) {
        int controlForDeads=0;
        if (checkTheEnergyForAbility(one) == 1) {
            controlForDeads = chooseTheAbilityForType(one,two);
            if (controlForDeads == 1) {
                return 1;
            }
        }
        if (checkTheEnergyForAbility(two) == 1) {
            controlForDeads = chooseTheAbilityForType(two,one);
            if (controlForDeads == 1) {
                return 2;
            }
        }
        return 0;
    }
}