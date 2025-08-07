plugins {
    id("com.android.application")
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-android")
    id("kotlin-kapt")
    //id("com.google.devtools.ksp")
    alias(libs.plugins.hilt)
    id("maven-publish")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = rootProject.extra["compileSdk"] as Int
    namespace = "com.sarang.torang"
    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["targetSdk"] as Int
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.sarang.torang.CustomTestRunner"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    hilt {
        enableTransformForLocalTests = true
    }

    android.buildFeatures.buildConfig = true

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
        }

        getByName("release") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    /** HILT */
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.nav.compose) // hiltViewModel

    /** Retrofit */
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    /** Room */
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1") // To use Kotlin annotation processing tool (kapt)
    //ksp("androidx.room:room-compiler:2.6.1") // To use Kotlin Symbol Processing (KSP)
//    implementation("androidx.room:room-rxjava2:2.6.1") // optional - RxJava2 support for Room
//    implementation("androidx.room:room-rxjava3:2.6.1") // optional - RxJava3 support for Room
//    implementation("androidx.room:room-guava:2.6.1") // optional - Guava support for Room, including Optional and ListenableFuture
//    testImplementation("androidx.room:room-testing:2.6.1") // optional - Test helpers
//    implementation("androidx.room:room-paging:2.6.1") // optional - Paging 3 Integration
    implementation("androidx.room:room-ktx:2.6.1")

    /** TEST Start */
    testImplementation(libs.junit)
    androidTestImplementation(libs.x.junit.ext)
    androidTestImplementation(libs.x.espresso.core)
    testImplementation(libs.kotlinx.coroutines.test) // coroutines unit test
    androidTestImplementation(libs.x.ui.test.junit4) // Test rules and transitive dependencies
    debugImplementation(libs.x.ui.test.manifest) // Needed for createAndroidComposeRule, but not createComposeRule

    // Hilt Start
    // For Robolectric tests.
    testImplementation(libs.hilt.testing)
    kaptTest(libs.hilt.compiler)
    testAnnotationProcessor(libs.hilt.compiler)

    // For instrumented tests.
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
    androidTestAnnotationProcessor(libs.hilt.compiler)
    // Hilt End
    /** TEST End */

    /** Compose */
    androidTestImplementation(platform(libs.x.compose.bom))
    implementation(libs.x.ui) //없으면 @Composable import 안됨
    implementation(libs.x.ui.graphics)
    implementation(libs.x.ui.tooling.preview) // Android Studio Preview support
    debugImplementation(libs.x.ui.tooling)
    implementation(libs.material3) //JetNews Main 따라하기
    implementation(libs.material3.windows.size)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.nav.compose)
    androidTestImplementation(libs.x.ui.test.junit4) //runTest
    debugImplementation(libs.x.ui.test.manifest) // Needed for createAndroidComposeRule, but not createComposeRule:

    /** Navigation start */
    // Kotlin
    implementation(libs.nav.fragment.ktx)
    implementation(libs.nav.ui.ktx)

    // Feature module Support
    implementation(libs.nav.dynamic.features.fragment)

    // Testing Navigation
    androidTestImplementation(libs.nav.testing)

    // Jetpack Compose Integration
    implementation(libs.nav.compose)
    /** Navigation end */

    implementation(project(":library"))

    implementation(libs.theme)
//    implementation(libs.instagramGallery)
//    implementation(libs.mediaContentResolver)
//    implementation(libs.torangBottomSheet)
    implementation(libs.commonImageLoader)
}