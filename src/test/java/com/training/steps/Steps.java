package com.training.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	WebDriver driver;
	LoginPage login;
	HomePage home;
	@Before(order=0)
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Before(order=1) // we can have multiple before and after methods using parameter order
	public void setUp1() {
		driver.manage().window().maximize();
	}
	@Given("User launch the salesforce application")
	public void user_launch_the_salesforce_application() {
		driver.get("https://login.salesforce.com/");
		System.out.println("Launch the application");
	}

	@When("user on {string}")
	public void user_on(String page) {
	    if(page.equalsIgnoreCase("LoginPage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("HomePage"))
	        home=new HomePage(driver);
	}

	@When("user enters the value into text box username")
	public void user_enters_the_value_into_text_box_username_as() throws Exception {
	    login.EnterintoUserName();
	    System.out.println("UserName is Entered");
	}

	@When("user enters the value into text box Password")
	public void user_enters_the_value_into_text_box_password_as() throws Exception {
	    login.EnterIntoPassWord();
	    System.out.println("Password is Entered");
	}

	@Then("Click on login Button")
	public void click_on_login_button() {
	    login.clickLoginButton();
	}

	@Then("verify user successfully logged in")
	public void verify_user_successfully_logged_in() {
	    System.out.println("Application is successfully logged in");
	}

	@Then("verify page title {string}")
	public void verify_page_title(String expectedTitle) {
		String actual= home.getTitleOfThePage();
	    if(actual.equals(expectedTitle))
	    	System.out.println("User is in home page");
	    else
	    	System.out.println("User is not in home page");
	}
	
	@Then("Verify the Error Message")
	public void verify_the_error_message() {
		login.loginErrorMessage();
		System.out.println("Error Message is verified");
	}
	@Then("Click on Rememberme checkbox")
	public void click_on_rememberme_checkbox() {
		login.checkRememberme();
		System.out.println("Remember me is clicked");
	}
	@When("User enter into UserMenu")
	public void user_enter_into_user_menu() {
		home.enterintoUsermenu();
		System.out.println("UserMenu dropdown is clicked");
	}

	@Then("Click logout")
	public void click_logout() {
		home.enterintologout();
		System.out.println("logout is clicked");
	}

	@Then("Verify the UserField")
	public void verify_the_user_field() {
		login.CheckUserField();
		System.out.println("User field is verified");
	}

	@Then("User Click ForgetPassword Link")
	public void user_click_forget_password_link() {
		login.forgotPassword();
		System.out.println("forget password is clicked");
	}

	@Then("User Enter UserNameField")
	public void user_enter_user_name_field() throws Exception {
		login.UserNameField();
		System.out.println("username field is entered");
	}

	@Then("User Click Continue")
	public void user_click_continue() {
		login.Continue();
		System.out.println("Continue button is clicked");
	}

	@Then("User Verify ForgetPassword Alert Message")
	public void user_verify_forget_password_alert_message() {
		login.ForgetPasswordMessage();
		System.out.println("Forget password alert message is verified");
	}

	@When("user enters the Wrong value into text box Password")
	public void user_enters_the_wrong_value_into_text_box_password() throws Exception {
		login.EnterIntoWrongPassword();
		System.out.println("Wrong password is entered");
	}

	@Then("User Verify the Wrong Password AlertMessage")
	public void user_verify_the_wrong_password_alert_message() {
		login.WrongPasswordAlertMessage();
		System.out.println("wrong password alert message is verified");
	}
	
}