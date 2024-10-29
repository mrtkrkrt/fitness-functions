package com.mrtkrkrt.fitness_functions.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.mrtkrkrt")
public class LayeredTests {

    @Test
    public void layeredTest() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.mrtkrkrt");
        Architectures.LayeredArchitecture layeredArchitecture = Architectures.layeredArchitecture().consideringAllDependencies()
                .layer("Controllers").definedBy("..controller..")
                .layer("Services").definedBy("..service..")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers");

        layeredArchitecture.check(classes);

    }
}
