package appium.android.automation.steps;

import appium.android.automation.models.DataInjection;
import appium.android.automation.pageobjects.ContactPage;
import static appium.android.automation.utils.HexFrame.*;

public class ContactSteps {

    ContactPage contactPage = new ContactPage();
    DataInjection dataInjection = new DataInjection();

    public void createNewContact(){
        capabilitiesContactAndroid();
        hexClick(contactPage.addContactButton);
        hexClick(contactPage.cancelButton);
        hexWrite(contactPage.firstNameInput, dataInjection.getFirstName());
        hexWrite(contactPage.lastNameInput, dataInjection.getLastName());
        hexWrite(contactPage.emailInput, dataInjection.getEmail());
        hexWrite(contactPage.phoneInput, dataInjection.getPhone());
        hexClick(contactPage.saveButton);
        androidDriver.quit();
        capabilitiesContactAndroid();
        hexCompareTextAssert(contactPage.createdUserValidation,
                dataInjection.getFirstName() + " " + dataInjection.getLastName());
    }

}
