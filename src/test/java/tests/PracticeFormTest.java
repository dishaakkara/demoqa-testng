package tests;

import base.BaseTest;
import data.UsersDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    @Test
    public void positiveFormSubmission() {
        PracticeFormPage form = new PracticeFormPage(driver);

        form.fillForm("Geo","Home","geo@test.com","Male","9876543210","Chennai");
        form.submitForm();

        Assert.assertEquals(form.getSuccessMessage(), "Thanks for submitting the form");
    }
    @Test
    public void negativeMissingPhone() {
        PracticeFormPage form = new PracticeFormPage(driver);

        form.fillForm("Geo","Home","geo@test.com","Male","","Chennai");
        form.submitForm();
        String borderColor = form.getPhoneFieldBorderColor();
        Assert.assertTrue(borderColor.contains("rgb(220"));
    }
}