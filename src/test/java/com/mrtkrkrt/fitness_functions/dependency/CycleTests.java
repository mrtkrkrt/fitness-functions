package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.library.dependencies.SliceRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class CycleTests {

    @Test
    public void cycleTest() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");
        SliceRule sliceRule = slices().matching("com.mrtkrkrt.(*)..").should().beFreeOfCycles();
        sliceRule.check(classes);
    }

}
