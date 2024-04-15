package selenium;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumTest {

  @Test
  public void automationTest(){

    //Navigate and wait
    open("https://explorecalifornia.org/contact.htm");

    $("#name").should(appear);
    $("#comments").should(appear);

    //Inputs
    $("#name").setValue("Yuliya Sakharava");
    $("#state").selectOptionContainingText("Texas");
    $("#backpack").click();
    $(By.name("newsletter")).selectRadio("yes");

    //Assertions
    $("#name").shouldHave(value("Yuliya Sakharava"));

    String state = $("#state").getSelectedText();
    assert(state).equals("Texas");

    $("#backpack").shouldBe(selected);

    $(By.name("newsletter")).shouldHave(value("yes"));
  }
}
