plugins {
    id(BuildScript.AndroidApplication)
    id(BuildScript.KotlinAndroid)
    id(BuildScript.KotlinAndroidExtensions)
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "fr.dappli.externaldaggercomponent"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    viewBinding.isEnabled = true
}

dependencies {
    testImplementation("junit:junit:4.12")

    androidTestImplementations(
        "androidx.test.ext:junit:1.1.1",
        "androidx.test.espresso:espresso-core:3.2.0"
    )

    implementations(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginsVersions.kotlin}",
        "androidx.appcompat:appcompat:1.1.0",
        "androidx.core:core-ktx:1.2.0",
        "androidx.constraintlayout:constraintlayout:1.1.3",
        "com.facebook.android:facebook-login:[5,6)"
    )
    implementationProjects(
        ":Sdk:Network"
    )
}
