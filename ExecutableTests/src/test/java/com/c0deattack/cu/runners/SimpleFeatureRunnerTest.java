package com.c0deattack.cu.runners;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:features", format = {"pretty", "html:target/cucumber"}, glue = "com.c0deattack.cu.steps")
public class SimpleFeatureRunnerTest {
}
