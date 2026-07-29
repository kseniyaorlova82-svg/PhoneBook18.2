package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    //before -login
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLogiRegisterForm("kristitomash@gmail.com", "Aa12345!");
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        clickOnAddLink();
        fillAddContactForm("Oliver", "Kan", "1234567890", "kan@gmail.com", "TelAviv", "QA");
        clickOnSaveButton();
        Assert.assertTrue(verifyByName("Oliver"));

    }

    @AfterMethod
    public void postConditions(){
        removeContact();

    }

}

