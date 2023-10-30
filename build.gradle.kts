plugins {
    id("java")
}

group = "ru.kvardekkvar"


subprojects {
    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-Xlint:all,-serial,-processing"))
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        val guava: String by project

        implementation( "com.google.guava:guava:$guava")
    }


}



