package tests;

import base.BaseTest;
import data.UsersDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class DataDrivenTest extends BaseTest {

    @Test(dataProvider="formData", dataProviderClass = UsersDataProvider.class)
    public void submitWithDifferentGenders(String gender, String phone) {

        PracticeFormPage form = new PracticeFormPage(driver);
        form.fillForm("Geo","User","test@test.com",gender,phone,"Delhi");
        form.submitForm();

        Assert.assertEquals(form.getSuccessMessage(), "Thanks for submitting the form");
    }
}
