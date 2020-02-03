package org.ch.tan.tester.ui.finders;

import org.ch.tan.tester.ui.Bugs;
import org.ch.tan.tester.ui.finders.Finder;

public class FinderFactory {
	
	public static Finder getFinder(String bug) {
		Finder finder = null;
		if (bug.equals(Bugs.CHECKBOX.bugName())) {
			finder = new CheckboxFinder();
		} else if(bug.equals(Bugs.LINKS.bugName())) {
			finder = new BrokenLinksFinder();
		} else {

		}
		return finder;
		
	}

}
