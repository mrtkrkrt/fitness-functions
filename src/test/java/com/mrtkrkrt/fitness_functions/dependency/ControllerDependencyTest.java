package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class ControllerDependencyTest {

    @Test
    public void controllers_should_be_accessed_only_services() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..controller..")
                .should().dependOnClassesThat().resideInAPackage("..service..");

        rule.check(classes);
    }

    @Test
    public void controller_should_be_accessed_from_only_services() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..controller..")
                .should().onlyHaveDependentClassesThat().resideInAPackage("..service..");

        rule.check(classes);
    }

    @ArchTest
    ArchRule controllers_should_be_accessed_only_services_rule_definition = ArchRuleDefinition.classes()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat().resideInAPackage("..service..");

    @ArchTest
    ArchRule controller_should_be_accessed_from_only_services = ArchRuleDefinition.classes()
            .that().resideInAPackage("..controller..")
            .should().onlyHaveDependentClassesThat().resideInAPackage("..service..");
}
