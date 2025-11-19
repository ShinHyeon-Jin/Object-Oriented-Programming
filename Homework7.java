abstract class Printer {
    protected String model;
    protected int printedCount;
    protected int availableCount;

    public Printer(String model, int initialAvailableCount) {
        this.model = model;
        this.printedCount = 0;
        this.availableCount = initialAvailableCount;
    }

    public abstract boolean print();
    public String getModel() { return model; }
    public int getPrintedCount() { return printedCount; }
    public int getAvailableCount() { return availableCount; }
}

class InkjetPrinter extends Printer {
    public InkjetPrinter(String model, int initialAvailableCount) {
        super(model, initialAvailableCount);
    }

    @Override
    public boolean print() {
        if (availableCount > 0) {
            printedCount++;
            availableCount--;
            return true;
        }
        else {
            System.out.printf("%s: %d매째 인쇄 실패 - 잉크 부족.\n",
                    model, printedCount + 1);
            return false;
        }
    }
}

class LaserPrinter extends Printer {
    public LaserPrinter(String model, int initialAvailableCount) {
        super(model, initialAvailableCount);
    }

    @Override
    public boolean print() {
        if (availableCount > 0) {
            printedCount++;
            availableCount--;
            return true;
        }
        else {
            System.out.printf("%s: %d매째 인쇄 실패 - 토너 부족.\n",
                    model, printedCount + 1);
            return false;
        }
    }
}

public class Homework7 {
    public static void main(String[] args) {
        InkjetPrinter inkjet = new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser = new LaserPrinter("Canon MFC643Cdw", 1500);
        while (inkjet.print());
        while (laser.print());
    }
}