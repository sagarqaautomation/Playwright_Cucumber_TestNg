package StepDefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature",
glue= {"StepDefinations"},
monochrome = true,
plugin= {"pretty", "html:target/HtmlReports/report.html"},
tags="@smoke or @regression")

public class TestRunner extends AbstractTestNGCucumberTests {
}

