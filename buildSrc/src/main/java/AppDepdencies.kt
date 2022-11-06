import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    private val material = "com.google.android.material:material:${Versions.material}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    //mockito
    private val mockito_core = "org.mockito:mockito-core:${Versions.mockitoCore}"
    private val mockito_all = "org.mockito:mockito-all:${Versions.mockitoAll}"
    private val mockito_inline = "org.mockito:mockito-inline:${Versions.mockitoInline}"

    //jetpack
    private val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}"
    private val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private val room = "androidx.room:room-runtime:${Versions.room}"
    private val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    private val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    private val hilt_navigation = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation}"
    private val runtime = "androidx.compose.runtime:runtime-livedata:1.2.1"
    //kapt
    private val kapt_hilt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    private val kapt_room = "androidx.room:room-compiler:${Versions.room}"

    //network
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    private val scalars = "com.squareup.retrofit2:converter-scalars:${Versions.scalars}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockito_core)
        add(mockito_all)
        add(mockito_inline)
    }

    val jetpackLibraries = arrayListOf<String>().apply {
        add(viewmodel)
        add(hilt)
        add(room)
        add(fragment)
        add(activity)
        add(hilt_navigation)
        add(runtime)
    }

    val kaptLibraries = arrayListOf<String>().apply {
        add(kapt_hilt)
        add(kapt_room)
    }

    val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(gson)
        add(scalars)
    }

}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}