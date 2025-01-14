plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.shibler.transitionlayer"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.12.01")) // Remplacez par la version souhaitée
    implementation("androidx.compose.ui:ui:1.7.6") // Remplacez par la version souhaitée
    implementation("androidx.compose.ui:ui-graphics:1.7.6") // Remplacez par la version souhaitée
    implementation("androidx.compose.material3:material3:1.3.1") // Remplacez par la version souhaitée
    implementation("androidx.navigation:navigation-compose:2.8.5")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Shibler0"
                artifactId = "TransitionLayer"
                version = "1.0"
            }
        }
    }
}