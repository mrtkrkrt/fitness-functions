package com.mrtkrkrt.fitness_functions.dependency;

import com.mrtkrkrt.fitness_functions.service.UserService;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class ClassImplementationTest {

    @Test
    public void inheritanceTest() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().implement(UserService.class)
                .should().haveSimpleNameContaining("Impl");

        rule.check(classes);
    }

    @Test
    public void interfaceTest() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt.fitness_functions");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().areAssignableTo(UserService.class)
                .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controller..", "..service..", "..test..");

        rule.check(classes);
    }
}
