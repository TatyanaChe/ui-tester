package org.ch.tan.tester.ui.finders;

import static com.codeborne.selenide.Selenide.open;

import org.ch.tan.tester.ui.pages.CheckboxPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CheckboxFinder implements Finder {

	public void verify(String url) {
		//String url = "http://www.echoecho.com/htmlforms09.htm";
		CheckboxPage page = open(url, CheckboxPage.class);
		

		
		ElementsCollection checks = page.findAllCheckboxes();
		int size = checks.size();
		int i = 0;
		Selenide.sleep(1000);
		StringBuffer sb = new StringBuffer("\nFound " + size + " check elements.");
		int count = 1;
		for (SelenideElement check : checks) {
			sb.append("\n" + count++ + " element: " + check);
			Selenide.sleep(300);
			if (check.isDisplayed()) {
				sb.append("\n it is dislayed");
				verifyCheck(sb, check);
			} else {
				sb.append("\n it is not displayed");
			}
		}
		System.out.println("   ******   ");
		System.out.println(sb.toString());
		Selenide.sleep(6000);
	}
	
	private boolean verifyCheck(StringBuffer sb, SelenideElement check) {
		boolean status = check.is(Condition.selected);
		sb.append("\n initial element state     : " + status);
		//sb.append("\n clicking on checkbox");
		check.click();
		boolean secondStatus = check.is(Condition.selected);
		sb.append("\n after clicking, new  state: " + secondStatus);
		boolean firstTry = status != secondStatus;
		
		//sb.append("\n again clicking on checkbox");
		check.click();
		boolean thirdStatus = check.is(Condition.selected);
		sb.append("\n after clicking, new  state: " + thirdStatus);

		boolean secondTry = secondStatus != thirdStatus;
		
		boolean isCorrect = firstTry && secondTry;
		if (isCorrect) {
			sb.append("\n this checkbox passed verification");
		} else {
			sb.append("\n this checkbox failed verification");
		}
		return isCorrect;

	}


}
