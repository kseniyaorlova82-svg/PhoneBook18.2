package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    //before -login
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("kristitomash@gmail.com")
                .setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gmail.com")
                .setAddress("TelAviv")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByName("Oliver"));

    }

    @AfterMethod
    public void postConditions(){
        app.getContact().removeContact();

    }

}
