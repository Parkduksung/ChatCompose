buildscript {
    val compose_version by extra("1.1.0-beta03")
    val compose_ui_version by extra("1.1.1")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
    }


}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}