import org.gradle.kotlin.dsl.`maven-publish`

plugins { `maven-publish` }

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "ImageJ Updater"
                description = "Keeps components of ImageJ up-to-date."
                url = "https://imagej.net/plugins/updater"
                inceptionYear = "2009"
                organization {
                    name = "ImageJ"
                    url = "https://imagej.net/"
                }
                licenses {
                    license {
                        name = "Simplified BSD License"
                        distribution = "repo"
                    }
                }

                developers {
                    developer {
                        id = "ctrueden"
                        name = "Curtis Rueden"
                        url = "https://imagej.net/people/ctrueden"
                        roles.addAll("debugger", "reviewer", "support", "maintainer")
                    }
                }
                contributors {
                    contributor {
                        name = "Johannes Schindelin"
                        url = "https://imagej.net/dscho"
                        roles = setOf("founder")
                        id = "dscho"
                    }
                    contributor {
                        name = "Yap Chin Kiet (Google Summer of Code 2009)"
                    }
                    contributor {
                        name = "Albert Cardona"
                        url = "https://imagej.net/acardona"
                        id = "acardona"
                    }
                    contributor {
                        name = "Mark Longair"
                        url = "https://imagej.net/mhl"
                        id = "mhl"
                    }
                    contributor {
                        name = "Jarek Sacha"
                        url = "https://imagej.net/hinerm"
                    }
                    contributor {
                        name = "Mark Hiner"
                        url = "https://imagej.net/hinerm"
                        id = "hinerm"
                    }
                    contributor {
                        name = "Matthias Arzt"
                        url = "https://imagej.net/maarzt"
                        id = "maarzt"
                    }
                    contributor {
                        name = "Deborah Schmidt"
                        url = "https://imagej.net/frauzufall"
                        id = "frauzufall"
                    }
                }

                mailingLists {
                    mailingList {
                        name = "Image.sc Forum"
                        archive = "https://forum.image.sc/tag/imagej"
                    }
                }

                scm {
                    connection = "scm:git:https://github.com/imagej/imagej-updater"
                    developerConnection = "scm:git:git@github.com:imagej/imagej-updater"
                    tag = "HEAD"
                    url = "https://github.com/imagej/imagej-updater"
                }
                issueManagement {
                    system = "GitHub Issues"
                    url = "https://github.com/imagej/imagej-updater/issues"
                }
                ciManagement {
                    system = "GitHub Actions"
                    url = "https://github.com/imagej/imagej-updater/actions"
                }
            }
        }
    }
}

var MavenPomContributor.id: String
    @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
    set(value) = properties.put("id", value)