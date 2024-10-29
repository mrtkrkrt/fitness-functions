package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class ClassNameMatchingTest {

    @Test
    public void repositories_should_be_accessed_by_service() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().haveNameMatching(".*Repository")
                .should().onlyHaveDependentClassesThat().resideInAPackage("..service..");

        rule.check(classes);
    }

    @ArchTest
    ArchRule repositories_should_be_accessed_by_service = ArchRuleDefinition.classes()
            .that().haveNameMatching(".*Repository")
            .should().onlyHaveDependentClassesThat().resideInAPackage("..service..");

}
