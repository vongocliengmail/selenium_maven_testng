package pageobjects;

public class HomePage {
    public String linkSignOut() {
        return System.getProperty("HomePage.SignOut.Link");
    }
    public String linkDog() {
        return System.getProperty("HomePage.Dogs.Link");
    }
}
