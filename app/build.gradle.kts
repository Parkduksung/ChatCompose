plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.chatcompose"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.5.31")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-test-manifest:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation-layout:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.animation:animation:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.runtime:runtime:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.runtime:runtime-livedata:${rootProject.extra["compose_version"]}")
    implementation("androidx.navigation:navigation-compose:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")


    //app libs
    implementation(AppDependencies.appLibraries)

    //jectpack libs
    implementation(AppDependencies.jetpackLibraries)

    //kapt libs
    kapt(AppDependencies.kaptLibraries)

    //network libs
    implementation(AppDependencies.networkLibraries)

    //test libs
    testImplementation(AppDependencies.testLibraries)
    testImplementation("org.mockito:mockito-inline:3.3.3")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    androidTestImplementation(AppDependencies.androidTestLibraries)

    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("com.google.android.material:material:1.3.0-alpha03")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")

    // testImplementation for pure JVM unit tests
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")

    // androidTestImplementation for Android instrumentation tests
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")
}