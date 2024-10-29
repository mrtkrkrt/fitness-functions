package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class ServiceDependencyTest {

    @Test
    public void controllers_should_only_accessed_from_services() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..controller..")
                .should().onlyBeAccessed().byAnyPackage("..service..", "..controller..");

        rule.check(classes);
    }

    @ArchTest
    ArchRule controllers_should_only_accessed_from_services_rule_definition = ArchRuleDefinition.classes()
            .that().resideInAPackage("..controller..")
            .should().onlyBeAccessed().byAnyPackage("..service..", "..controller..");
}
