// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    // repositories and dependencies are moved to build.gradle.kts of buildSrc module
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
