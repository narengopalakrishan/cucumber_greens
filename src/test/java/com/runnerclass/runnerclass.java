package com.runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.base.Base_class;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/feature",
glue = "com/stepdefinition",

// for data table
//@CucumberOptions(features = "src/test/java/com/feature/DataTableExample.feature",
//glue = "com/stepdefinition/adactin_datatable",

monochrome = true,
dryRun = false,
plugin = {"pretty","html:target/htmlreport/login_report.html","json:target/jsonreport/login_report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags = ("@smoke")
)
public class runnerclass {
	
	@BeforeClass
	public static void launching_chrome() {
		System.out.println("Broswer will open soon");
		Base_class.chrome_open(30);
	}

	@AfterClass
	public static void closing_chrome() {
		System.out.println("Broswer will close soon");
		Base_class.close_or_quit("quit");
	}
}

