public abstract class VirtualPet {
    protected String name;
    protected int energy;

    public VirtualPet(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    abstract void play();
    abstract void eval();
    abstract void info();
}
