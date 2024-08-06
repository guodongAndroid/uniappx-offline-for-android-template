// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath(files("plugins/uts-kotlin-compiler-plugin-0.0.1.jar"))
        classpath(files("plugins/uts-kotlin-gradle-plugin-0.0.1.jar"))
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}