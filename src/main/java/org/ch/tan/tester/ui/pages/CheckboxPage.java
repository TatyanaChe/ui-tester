package org.ch.tan.tester.ui.pages;

import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.ElementsCollection;

public class CheckboxPage {
	
    private static final By CHECKBOX_LOCATOR = By.xpath("//input[@type='checkbox']");

	public ElementsCollection findAllCheckboxes() {
		return $$(CHECKBOX_LOCATOR);
	}


}
