package pageobjects;

public class PaymentDetailsPage {
    public String txtCardType() {
        return System.getProperty("PaymentDetailsPage.CardType.TextBox");
    }

    public String txtCardNumber() {
        return System.getProperty("PaymentDetailsPage.CardNumber.TextBox");
    }

    public String txtExpiryDate() {
        return System.getProperty("PaymentDetailsPage.ExpiryDate.TextBox");
    }

    public String txtFirstName() {
        return System.getProperty("PaymentDetailsPage.FirstName.TextBox");
    }

    public String txtLastName() {
        return System.getProperty("PaymentDetailsPage.LastName.TextBox");
    }

    public String txtAddress1() {
        return System.getProperty("PaymentDetailsPage.Address1.TextBox");
    }

    public String txtAddress2() {
        return System.getProperty("PaymentDetailsPage.Address2.TextBox");
    }

    public String txtCity() {
        return System.getProperty("PaymentDetailsPage.City.TextBox");
    }

    public String txtState() {
        return System.getProperty("PaymentDetailsPage.State.TextBox");
    }

    public String txtZip() {
        return System.getProperty("PaymentDetailsPage.Zip.TextBox");
    }

    public String txtCountry() {
        return System.getProperty("PaymentDetailsPage.Country.TextBox");
    }

    public String btnContinue() {
        return System.getProperty("PaymentDetailsPage.Continue.TextBox");
    }
}
