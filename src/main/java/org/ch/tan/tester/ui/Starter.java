package org.ch.tan.tester.ui;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.ch.tan.tester.ui.finders.Finder;
import org.ch.tan.tester.ui.finders.FinderFactory;


public class Starter {
	
	public static void main(String[] args) throws Exception {

		System.out.println("starting searching for bugs ...");
		System.out.println("with arguments ");
		for (String string : args) {
			System.out.println(string);
		}
		Options options = new Options();
		options.addOption("help", false, "show help");
		options.addOption("url", true, "site url to test");
		options.addOption("bugs", true, "the comma-separated list of bugs to search");


		String url = null;
		String bugs = null;
		List<String> bugList;

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			e.printStackTrace();
			//printHelp(options);
		}
		
		if (cmd.hasOption("help")) {
			System.out.println("Utility to test web UI. Usage: TBD ");
			return;
		} else {

			if (cmd.hasOption("bugs")) {
				bugs = cmd.getOptionValue("bugs");
			} else {
				bugs = "TBD";
			}
			bugList = createBugList(bugs);
			
			if (cmd.hasOption("url")) {
				url = cmd.getOptionValue("url");
			} else {
				url = "google.com";
			}
			
			for (String bug : bugList) {
				findBug(bug, url);
			}

		}
	}

	private static void findBug(String bug, String url) {
		Finder finder = FinderFactory.getFinder(bug);
		finder.verify(url);
	}

	private static List<String> createBugList(String bugs) {
		String[] bgs = bugs.split(",");
		return Arrays.asList(bgs);
	}



}