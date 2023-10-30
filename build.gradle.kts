plugins {
    id("java")
}

group = "ru.kvardekkvar"

subprojects {
    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
            vendor.set(JvmVendorSpec.ADOPTIUM)
        }
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



