plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//ROOM DATABASE
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.6.21-1.0.5"
}

android {
    namespace = "com.example.ejem16_basedatos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ejem16_basedatos"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        dataBinding =  true
    }
}

dependencies {

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
// To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
// To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$room_version")

    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}