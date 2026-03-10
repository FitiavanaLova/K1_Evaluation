public class PourcentageReparation {
    private double ranger;
    private double everest;
    private double yukon;
    private double ram;

    public PourcentageReparation(double ranger, double everest, double yukon, double ram) {
        this.ranger = ranger;
        this.everest = everest;
        this.yukon = yukon;
        this.ram = ram;
    }


    public double getRanger() { return ranger; }
    public double getEverest() { return everest; }
    public double getYukon() { return yukon; }
    public double getRam() { return ram; }

    @Override
    public String toString() {
        return ranger + " | " + everest + " | " + yukon + " | " + ram;
    }
}