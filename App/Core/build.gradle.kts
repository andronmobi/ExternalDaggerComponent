plugins {
    id(BuildScript.AndroidLibrary)
    id(BuildScript.KotlinAndroid)
    id(BuildScript.Kapt)
}

android {

    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    kapts(
        "com.google.dagger:dagger-android-processor:2.27",
        "com.google.dagger:dagger-compiler:2.27"
    )

    implementations(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginsVersions.kotlin}",
        "com.google.dagger:dagger:2.27",
        "com.google.code.gson:gson:2.8.5"
    )

    implementationProjects(
        ":Sdk:Core"
    )
}