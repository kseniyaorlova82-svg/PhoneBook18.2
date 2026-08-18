package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import de.phonebook.utils.MyDataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {

    //before -login
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("kristitomash@gmail.com")
                .setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test(dataProvider = "addNewContactFromCsv", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByPhone(contact.getPhone()));

    }

    @AfterMethod
    public void postConditions() {
        app.getContact().removeContact();
    }
}

