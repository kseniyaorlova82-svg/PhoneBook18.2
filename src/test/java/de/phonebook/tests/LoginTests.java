package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginRegisteredUserPositiveTest(){
        clickOnLoginLink();
        fillLogiRegisterForm("kristitomash@gmail.com", "Aa12345!");
        clickOnLoginButton();
        Assert.assertTrue(isSingOutButtonPresent());


    }

}
