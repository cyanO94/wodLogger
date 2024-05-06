package com.example.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun applyDependencyImpl(handler: DependencyHandler, libs: VersionCatalog, names: List<String>) = with(handler) {
    names.forEach {
        add("implementation", libs.findLibrary(it).get())
    }
}

fun applyDependencyKapt(handler: DependencyHandler, libs: VersionCatalog, names: List<String>) = with(handler) {
    names.forEach {
        add("kapt", libs.findLibrary(it).get())
    }
}