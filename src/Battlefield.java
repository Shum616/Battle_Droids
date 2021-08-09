public class Battlefield {
    protected String nameBattle;
    protected int critBattle;
    protected int energyBattle;
    protected int accuracyBattle;

    protected Battlefield() {
    }

    public String getNameBattle() { return nameBattle; }
    public int getCritBattle() { return critBattle; }
    public int getEnergyBattle() { return energyBattle; }
    public int getAccuracyBattle() { return accuracyBattle; }

    public void display() {
        System.out.printf("\tBattlefield`s name: %s" +
                        "\n\tBattlefield`s critical chance: %d" +
                        "\n\tBattlefield`s energy: %d" +
                        "\n\tBattlefield`s accuracy: %d\n",
                this.nameBattle, this.critBattle, this.energyBattle, this.accuracyBattle);
    }
}
    class City extends Battlefield {
        public City(){
            super.nameBattle = "City";
            super.critBattle= 0;
            super.energyBattle = 10;
            super.accuracyBattle= 0;
        }
    }
    class Arena extends Battlefield {
        public Arena() {
            super.nameBattle = "Arena";
            super.critBattle= 0;
            super.energyBattle = 0;
            super.accuracyBattle= 0;
        }
    }
class Desert extends Battlefield {
    public Desert() {
        super.nameBattle = "Desert";
        super.critBattle= 180;
        super.energyBattle = 0;
        super.accuracyBattle= 0;
    }
}
class Forest extends Battlefield {
    public Forest() {
        super.nameBattle = "Forest";
        super.critBattle= 0;
        super.energyBattle = 0;
        super.accuracyBattle= -15;
    }
}


