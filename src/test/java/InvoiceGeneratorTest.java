import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    double[] distanceArray = {15, 20, 10};
    int[] timeArray = {10, 5, 15};
    public static final double DISTANCE = 15;
    public static final int TIME = 20;

    /**
     * Malvika: said
     * Kiran: implemented
     * Vyshnavi: helped
     */
    @Test
    public void givenDistanceAndTimeShouldReturnFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFareRegular(DISTANCE, TIME);
        Assert.assertEquals(170, fare, 0.00);
    }

    /**
     * Malvika: implemented
     * Kiran: said
     * Vyshnavi: helped
     */
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double avgFare = invoiceGenerator.calculateFareRegular(distanceArray, timeArray);
        Assert.assertEquals(160, avgFare, 0.0);
    }

    /**
     * Malvika: helped
     * Kiran: siad, implmented
     * Vyshnavi: helped
     */
    @Test
    public void givenDistanceAndTimeArraysShouldReturnDoubleArray() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double[] avgFare = invoiceGenerator.calculateFareReturnArray(distanceArray, timeArray);
        double[] expectedElements = {3,480,160};
        for (int i=0;i<distanceArray.length;i++) {
            Assert.assertEquals(expectedElements[i],avgFare[i],0.00);
        }
    }

    /**
     * Malvika: implemented
     * Kiran: helped
     * Vyshnavi: siad
     */
    @Test
    public void givenUserIDAndListOfRidesShouldReturnInvoiceRepositories() {

        double[] distanceArray1 = {15, 20, 10};
        int[] timeArray1 = {10, 5, 15};
        double[] distanceArray2 = {10, 15, 20};
        int[] timeArray2 = {10, 5, 15};
        double[] distanceArray3 = {10, 20, 15};
        int[] timeArray3 = {10, 5, 15};

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        invoiceGenerator.calculateFareReturnArray(distanceArray1, timeArray1);
        invoiceGenerator.calculateFareReturnArray(distanceArray2, timeArray2);
        invoiceGenerator.calculateFareReturnArray(distanceArray3, timeArray3);

        int userID = 1;
        double[] expected = invoiceGenerator.getRepository(userID);
        double[] expectedElements = {3,480,160};

        for (int i=0;i<distanceArray.length;i++) {
            Assert.assertEquals(expectedElements[i],expected[i],0.00);
        }
    }

    /**
     * Malvika: said
     * Kiran: helped
     * Vyshnavi: implemented
     */
    @Test
    public void givenCustomerTypeRegular_ShouldCalculateForRegular() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String customerType = "Regular";
        double fare = invoiceGenerator.calculateFareForCustomer(customerType, DISTANCE, TIME);
        Assert.assertEquals(170, fare, 0.0);
    }

    /**
     * Malvika: said
     * Kiran: helped
     * Vyshnavi: implemented
     */
    @Test
    public void givenCustomerTypePremium_ShouldCalculateForRegular() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String customerType = "Premium";
        double fare = invoiceGenerator.calculateFareForCustomer(customerType, DISTANCE, TIME);
        Assert.assertEquals(265, fare, 0.0);
    }
}
