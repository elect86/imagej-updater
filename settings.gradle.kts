rootProject.name = "imagej-updater"

includeBuild("../pom-scijava/gradle-scijava")

dependencyResolutionManagement.versionCatalogs.create("libs")
    .from(files("../pom-scijava/target/gradle/version-catalog/libs.versions.toml"))