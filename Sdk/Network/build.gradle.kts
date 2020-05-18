plugins {
    id(BuildScript.AndroidLibrary)
    id(BuildScript.KotlinAndroid)
    id(BuildScript.KotlinAndroidExtensions)
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginsVersions.kotlin}")
}