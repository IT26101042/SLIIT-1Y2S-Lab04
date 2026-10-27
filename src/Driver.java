// Q03

// (a
public class Driver {
    private String driverID;
    private String driverName;
    private double baseSalary;
    private int performanceScore;

    // b) I)
    public Driver(String driverID, String driverName) {
        this(driverID, driverName, 0.0, 1);
    }

    // b) II)
    public Driver(String driverID, String driverName, double baseSalary) {
        this(driverID, driverName, baseSalary, 1);
    }

    // b) III)
    public Driver(String driverID, String driverName,
                  double baseSalary, int performanceScore) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.baseSalary = baseSalary;
        setPerformanceScore(performanceScore);
    }

    // c)
    public String getDriverID() {
        return driverID;
    }


    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }


    public int getPerformanceScore() {
        return performanceScore;
    }


    public void setPerformanceScore(int performanceScore) {
        if (performanceScore >= 1 && performanceScore <= 5) {
            this.performanceScore = performanceScore;
        } else {
            this.performanceScore = 1;
        }
    }

    // d) I)
    public double calculateBonus() {
        return calculateBonus(performanceScore);
    }

    // d) II)
    public double calculateBonus(int customScore) {
        double bonusRate;

        switch (customScore) {
            case 5:
                bonusRate = 0.25;
                break;
            case 4:
                bonusRate = 0.20;
                break;
            case 3:
                bonusRate = 0.15;
                break;
            case 2:
                bonusRate = 0.10;
                break;
            default:

                bonusRate = 0.0;
        }

        return baseSalary * bonusRate;
    }

    // e)
    public double calculateTotalSalary() {
        return baseSalary + calculateBonus();
    }

    // f)
    public void displayDriverDetails() {
        System.out.println("Driver ID: " + driverID);
        System.out.println("Name: " + driverName);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Performance Score: " + performanceScore);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total Salary: " + calculateTotalSalary());
        System.out.println();
    }


    public static void main(String[] args) {

        Driver driver1 = new Driver(
                "D1001", "John Smith", 4000.0, 5
        );


        Driver driver2 = new Driver(
                "D1002", "Emily Davis", 3500.0
        );
        driver2.setPerformanceScore(3);

        Driver driver3 = new Driver(
                "D1003", "Michael Johnson", 5000.0
        );


        Driver driver4 = new Driver("D1004", "David Silva");

        driver1.displayDriverDetails();
        driver2.displayDriverDetails();
        driver3.displayDriverDetails();

        System.out.println(
                "Bonus for driver3 with custom rating 4: "
                        + driver3.calculateBonus(4)
        );

        System.out.println(
                "Stored score of driver3: "
                        + driver3.getPerformanceScore()
        );

        System.out.println("\n=== Two-argument constructor ===");
        driver4.displayDriverDetails();


        driver4.setDriverID("D1005");
        driver4.setPerformanceScore(8);

        System.out.println("Updated ID: " + driver4.getDriverID());
        System.out.println(
                "Score after invalid input: "
                        + driver4.getPerformanceScore()
        );
    }
}