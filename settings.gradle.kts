rootProject.name = "otus-java-course"
include("hw01-gradle")
include("hw02-collections")

pluginManagement {

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
    id("com.diffplug.spotless") version "6.22.0"

}
}
