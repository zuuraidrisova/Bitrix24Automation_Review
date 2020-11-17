package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(

        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-report.html"
        },
        features = "src/test/resources/features",
        glue = "com/bitrix24/step_definitions",
        tags = "@fileUploading"
)
@RunWith(Cucumber.class)
public class CukesRunner {
}
