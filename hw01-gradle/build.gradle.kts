import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

    tasks {

    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("hw01")
        archiveVersion.set("0.1")
        archiveClassifier.set("")
        manifest {
            attributes(mapOf("Main-Class" to "ru.kvardekkvar.HelloOtus"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}