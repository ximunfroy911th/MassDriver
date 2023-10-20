plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    // Add the App Distribution Gradle plugin
    id("com.google.firebase.appdistribution")
}

android {
    namespace = "net.unboxit.massrfid"
    compileSdk = 33

    defaultConfig {
        applicationId = "net.unboxit.massrfid"
        minSdk = 24
        targetSdk = 33
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
            firebaseAppDistribution {
                artifactType = "APK"
                releaseNotes = "Add feature"
//                releaseNotesFile = "/path/to/releasenotes.txt"
                testers = "ximunfroy911th@gmail.com"
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.annotation:annotation:1.6.0")

    implementation("androidx.datastore:datastore-core:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
//    implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")
    implementation("androidx.datastore:datastore-preferences-rxjava3:1.0.0")

    // mvvm
    val coroutinesVersion = "1.4.3"
    val retrofitVersion = "2.9.0"
    val lifeCycleVersion = "2.2.0"
    val daggerHiltVersion = "2.46.1"
    val coilVersion = "1.2.2"
    val activity_version = "1.1.0"

    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.fragment:fragment-ktx:$activity_version")
    //ViewBinding
//    implementation("com.android.databinding:viewbinding:4.2.1")
    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-common:2.6.1")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")


    // DI
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")

    //for image rendering
    implementation("io.coil-kt:coil:$coilVersion")

    // Firebase service
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
