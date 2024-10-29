package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class AnnotationTests {

    @Test
    public void services_should_annotated_with_service() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");

        ArchRule rule = ArchRuleDefinition.classes().that().haveSimpleNameEndingWith("ServiceImpl")
                .should().beAnnotatedWith(Service.class);

        rule.check(classes);
    }

    @ArchTest
    ArchRule services_should_annotated_with_service = ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("ServiceImpl")
            .should().beAnnotatedWith(Service.class);
}
