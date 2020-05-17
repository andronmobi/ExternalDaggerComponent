import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
}

dependencies {
    // Android Gradle
    // https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
    implementation("com.android.tools.build:gradle:3.6.3")

    // Must be the same value as PluginsVersions.kotlin
    // Kotlin
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.71")
}