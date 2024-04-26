package pageobjects;

public class SignInPage {
    public String btnSignIn() {
        return System.getProperty("PetStore.SignIn.Link");
    }
    public String txtUserName() {
        return System.getProperty("SignIn.UserName.TextBox");
    }
    public String txtPassword() {
        return System.getProperty("SignIn.Password.TextBox");
    }
    public String btnLogin() {
        return System.getProperty("SignIn.Login.Button");
    }


}
