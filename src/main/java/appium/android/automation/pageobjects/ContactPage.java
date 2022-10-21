package appium.android.automation.pageobjects;

import org.openqa.selenium.By;

public class ContactPage {

    public By addContactButton = By.id("com.android.contacts:id/floating_action_button_container");
    public By cancelButton = By.id("com.android.contacts:id/left_button");
    public By firstNameInput = By.xpath("//android.widget.EditText[@text='First name']");
    public By lastNameInput = By.xpath("//android.widget.EditText[@text='Last name']");
    public By emailInput = By.xpath("//android.widget.EditText[@text='Email']");
    public By phoneInput = By.xpath("//android.widget.EditText[@text='Phone']");
    public By saveButton = By.id("com.android.contacts:id/editor_menu_save_button");
    public By createdUserValidation = By.id("com.android.contacts:id/cliv_name_textview");

}
