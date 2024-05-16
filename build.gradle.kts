plugins {
    embeddedKotlin("jvm")
}

repositories {
    mavenCentral()
    maven("https://maven.scijava.org/content/groups/public")
}

group = "net.imagej"
version = "1.0.2-SNAPSHOT"

dependencies {
    implementation(platform("org.scijava:pom-scijava"))

    // ImageJ dependencies
    implementation(libs.imagej.common)
    // SciJava dependencies
    implementation(libs.scijava.common)

    testImplementation(libs.junit.junit)
    testImplementation(libs.commons.lang.commonsLang)
}

tasks.withType<JavaCompile> {
    // to catch deprecation warnings
    // I fixed everything except Prefs
    options.isDeprecation = true
}