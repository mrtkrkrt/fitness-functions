package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class PackagePropertyTest {

    @Test
    public void services_should_be_in_services_package() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Service")
                .should().resideInAPackage("..service..");

        rule.check(classes);
    }

    @Test
    public void scontrollers_should_be_in_services_package() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Controller")
                .should().resideInAPackage("..controller..");

        rule.check(classes);
    }

    @ArchTest
    ArchRule services_should_be_in_services_package = ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("Service")
            .should().resideInAPackage("..service..");

    @ArchTest
    ArchRule controllers_should_be_in_services_package = ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("..controller..");
}
