import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec

// https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/#configurations-and-dependencies
// Private methods exist to hide the "dirty" implementation from public methods.

// region Plugins
private fun PluginDependenciesSpec.plugin(plugin: String) = id(plugin)

fun PluginDependenciesSpec.plugins(vararg plugins: String) = plugins.forEach { plugin(it) }
// endregion

// region Kapt
private fun DependencyHandlerScope.kapt(dependency: String)
        = "kapt"(dependency)

private fun DependencyHandlerScope.kaptTest(dependency: String)
        = "kaptTest"(dependency)

private fun DependencyHandlerScope.kaptAndroidTest(dependency: String)
        = "kaptAndroidTest"(dependency)

fun DependencyHandlerScope.kapts(vararg dependencies: String)
        = dependencies.forEach { kapt(it) }

fun DependencyHandlerScope.kaptTests(vararg dependencies: String)
        = dependencies.forEach { kaptTest(it) }

fun DependencyHandlerScope.kaptAndroidTests(vararg dependencies: String)
        = dependencies.forEach { kaptAndroidTest(it) }
// endregion

// region Implementation
private fun DependencyHandlerScope.debugImplementation(dependency: String)
        = "debugImplementation"(dependency)

private fun DependencyHandlerScope.releaseImplementation(dependency: String)
        = "releaseImplementation"(dependency)

fun DependencyHandlerScope.implementations(vararg dependencies: String)
        = dependencies.forEach { "implementation"(it) }

fun DependencyHandlerScope.implementation(dependencyNotation: String, dependencyConfiguration: ExternalModuleDependency.() -> Unit)
        = "implementation"(dependencyNotation, dependencyConfiguration)

fun DependencyHandlerScope.debugImplementations(vararg dependencies: String)
        = dependencies.forEach { debugImplementation(it) }

fun DependencyHandlerScope.releaseImplementations(vararg dependencies: String)
        = dependencies.forEach { releaseImplementation(it) }

fun DependencyHandlerScope.testImplementations(vararg dependencies: String)
        = dependencies.forEach { "testImplementation"(it) }

fun DependencyHandlerScope.androidTestImplementations(vararg dependencies: String)
        = dependencies.forEach { "androidTestImplementation"(it) }

fun DependencyHandlerScope.androidTestImplementation(dependency: String, dependencyConfiguration: ExternalModuleDependency.() -> Unit)
        = "androidTestImplementation"(dependency, dependencyConfiguration)

fun DependencyHandlerScope.testImplementation(dependencyNotation: String, dependencyConfiguration: ExternalModuleDependency.() -> Unit)
        = "testImplementation"(dependencyNotation, dependencyConfiguration)

// endregion

// region Project
private fun DependencyHandlerScope.implementation(dependency: ProjectDependency)
        = "implementation"(dependency)

private fun DependencyHandlerScope.debugImplementation(dependency: ProjectDependency)
        = "debugImplementation"(dependency)

private fun DependencyHandlerScope.testInternalImplementation(dependency: ProjectDependency)
        = "testImplementation"(dependency)

private fun DependencyHandlerScope.api(dependency: ProjectDependency)
        = "api"(dependency)

private fun DependencyHandlerScope.androidTestImplementation(dependency: ProjectDependency)
        = "androidTestImplementation"(dependency)

fun DependencyHandlerScope.implementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
            .forEach { implementation(it) }
}

fun DependencyHandlerScope.debugImplementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
            .forEach { debugImplementation(it) }
}

fun DependencyHandlerScope.testImplementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
            .forEach { testInternalImplementation(it) }
}

fun DependencyHandlerScope.androidTestImplementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
            .forEach { androidTestImplementation(it) }
}

fun DependencyHandlerScope.apiProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
            .forEach { api(it) }
}
// endregion

private fun DependencyHandlerScope.compileOnly(dependency: String)
        = "compileOnly"(dependency)

fun DependencyHandlerScope.compileOnly(vararg dependencies: String) {
    dependencies.forEach { compileOnly(it) }
}

private fun DependencyHandlerScope.api(dependency: String)
        = "api"(dependency)

fun DependencyHandlerScope.apis(vararg dependencies: String) {
    dependencies.forEach { api(it) }
}
