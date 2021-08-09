import java.util.*;
public class Droid implements Comparable{
    protected String name;
    protected int heath;
    protected int MaxHeath;
    protected int maxAttack;
    protected int minAttack;
    protected int crit;
    protected int energy;
    protected int currentEnergy;
    protected int energyPerAttack;
    protected int energyPerAbility;
    protected int accuracy;
    protected int skipTheTurn;
    protected int skipTheEnergy;
    protected int deadOrNot;

    protected Droid() {
    }

    public String getName() { return name; }
    public int getHeath() { return heath; }
    public int getMaxAttack() { return maxAttack; }
    public int getMinAttack() { return minAttack; }
    public int getCrit() { return crit; }
    public int getEnergy() { return energy; }
    public int getCurrentEnergy() { return currentEnergy; }
    public int getEnergyPerAttack() { return energyPerAttack; }
    public int getEnergyPerAbility() { return energyPerAbility; }
    public int getAccuracy() { return accuracy; }
    public int getSkipTheTurn() { return skipTheTurn; }
    public int getMaxHeath() { return MaxHeath; }
    public int getSkipTheEnergy() { return skipTheEnergy; }
    public int getDeadOrNot() { return deadOrNot; }

    public void setHealth(int a){ this.heath = a; }
    public void setCurrentEnergy(int a){ this.currentEnergy = a; }
    public void setSkipTheTurn(int a){ this.skipTheTurn = a; }
    public void setSkipTheEnergy(int a){ this.skipTheEnergy = a; }
    public void setDeadOrNot(int a){ this.deadOrNot = a; }
    public void setMaxAttack(int a){ this.maxAttack = a; }
    public void setMinAttack(int a){ this.minAttack = a; }
    public void setEnergyPerAttack(int a){ this.energyPerAttack = a; }
    public void setAccuracy(int a){ this.accuracy = a; }

    public void display(){
        System.out.printf("\n\tDroid`s name: %s" +
                        "\n\tDroid`s heath: %.2d" +
                        "\n\tDroid`s attack: %.2d - %.2d" +
                        "\n\tDroid`s critical chance: %.2f" +
                        "\n\tDroid`s energy: %.2f" +
                        "\n\tDroid`s accuracy: %.2f\n",
                this.name, this.heath, this.minAttack, this.maxAttack, this.crit, this.energy, this.accuracy);
    }

    @Override
    public int compareTo(Object obj) {
        {
            Droid tmp = (Droid)obj;
            if(this.getDeadOrNot() < tmp.getDeadOrNot())
            {
                return 1;
            }
            else if(this.getDeadOrNot() > tmp.getDeadOrNot())
            {
                return -1;
            }
            return 0;
        }
    }
}
class Paladin extends Droid{
    public Paladin(){
        super.name = "Paladin";
        super.heath= 40000;
        super.maxAttack= 350;
        super.minAttack= 150;
        super.crit= 15;
        super.energy = 200;
        super.currentEnergy=0;
        super.energyPerAttack=15;
        super.energyPerAbility = 70;
        super.accuracy= 90;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Warrior extends Droid{
    public Warrior() {
        super.name = "Warrior";
        super.heath = 35000;
        super.maxAttack= 1400;
        super.minAttack= 180;
        super.crit = 12;
        super.energy = 250;
        super.currentEnergy=0;
        super.energyPerAttack=20;
        super.energyPerAbility = 80;
        super.accuracy = 95;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Mechanic extends Droid{
    public Mechanic(){
        super.name = "Mechanic";
        super.heath= 30000;
        super.maxAttack= 100;
        super.minAttack= 50;
        super.crit= 5;
        super.energy = 200;
        super.currentEnergy=0;
        super.energyPerAttack=20;
        super.energyPerAbility = 50;
        super.accuracy= 70;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Shooter extends Droid{
    public Shooter(){
        super.name = "Shooter";
        super.heath= 30000;
        super.maxAttack= 500;
        super.minAttack= 200;
        super.crit= 25;
        super.energy = 250;
        super.currentEnergy=0;
        super.energyPerAttack=25;
        super.energyPerAbility = 100;
        super.accuracy= 98;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Launcher extends Droid{
    public Launcher(){
        super.name = "Launcher";
        super.heath= 37000;
        super.maxAttack= 550;
        super.minAttack= 220;
        super.crit= 17;
        super.energy = 230;
        super.currentEnergy=0;
        super.energyPerAttack = 25;
        super.energyPerAbility = 90;
        super.accuracy= 90;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Assassin extends Droid{
    public Assassin(){
        super.name = "Assassin";
        super.heath= 32000;
        super.maxAttack= 600;
        super.minAttack= 300;
        super.crit= 28;
        super.energy = 220;
        super.currentEnergy=0;
        super.energyPerAttack=25;
        super.energyPerAbility = 85;
        super.accuracy= 95;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
class Herald extends Droid{
    public Herald(){
        super.name = "Herald";
        super.heath= 20000;
        super.maxAttack= 160;
        super.minAttack= 70;
        super.crit= 2;
        super.energy = 300;
        super.currentEnergy=300;
        super.energyPerAttack=0;
        super.energyPerAbility = 30;
        super.accuracy= 70;
        super.MaxHeath=super.heath;
        super.deadOrNot= 1;
    }
}
