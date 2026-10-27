// Q02

// a)
public class Product {
    private String productID;
    private String productName;
    private double basePrice;
    private String membershipType;

    // b)
    public Product() {
        this("Not assigned", "Unknown", 0.0, "Non-Member");
    }

    // b) a)
    public Product(String productID, String productName) {
        this(productID, productName, 0.0, "Non-Member");
    }

    // b) b)
    public Product(String productID, String productName, double basePrice) {
        this(productID, productName, basePrice, "Non-Member");
    }

    // b) c)
    public Product(String productID, String productName,
                   double basePrice, String membershipType) {
        this.productID = productID;
        this.productName = productName;
        setBasePrice(basePrice);
        setMembershipType(membershipType);
    }

    // c)
    public String getMembershipType() {
        return membershipType;
    }

    // c)
    public void setMembershipType(String membershipType) {
        if ("Premium".equalsIgnoreCase(membershipType)) {
            this.membershipType = "Premium";
        } else if ("Regular".equalsIgnoreCase(membershipType)) {
            this.membershipType = "Regular";
        } else {
            this.membershipType = "Non-Member";
        }
    }

    // c)
    public double getBasePrice() {
        return basePrice;
    }

    // c)
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            this.basePrice = 0.0;
        }
    }

    // d) a)
    public double calculateFinalPrice() {
        double discountRate;

        switch (membershipType) {
            case "Premium":
                discountRate = 0.20;
                break;
            case "Regular":
                discountRate = 0.10;
                break;
            default:
                discountRate = 0.0;
        }

        return basePrice - (basePrice * discountRate);
    }

    // d) b)
    // Stored attribute values are not modified
    public double calculateFinalPrice(double seasonalDiscount) {
        double validDiscount = Math.max(0.0, seasonalDiscount);
        return Math.max(0.0, calculateFinalPrice() - validDiscount);
    }

    // e)
    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Membership Type: " + membershipType);
        System.out.println(
                "Final Price (after discount): $" + calculateFinalPrice()
        );
        System.out.println();
    }

    // f)
    public static void main(String[] args) {
        Product product1 = new Product(
                "P1001", "Laptop", 1000.0, "Premium"
        );

        Product product2 = new Product(
                "P1002", "Smartphone", 600.0
        );
        product2.setMembershipType("Regular");

        Product product3 = new Product("P1003", "Headphones");
        product3.setBasePrice(200.0);

        product3.setMembershipType("Gold");

        product1.displayProductDetails();
        product2.displayProductDetails();
        product3.displayProductDetails();

        System.out.println(
                "Estimated price for Smartphone with extra $5 seasonal discount: $"
                        + product2.calculateFinalPrice(5.0)
        );


        System.out.println(
                "Stored base price: $" + product2.getBasePrice()
        );
        System.out.println(
                "Stored membership: " + product2.getMembershipType()
        );
        System.out.println(
                "Price without seasonal discount: $"
                        + product2.calculateFinalPrice()
        );
    }
}