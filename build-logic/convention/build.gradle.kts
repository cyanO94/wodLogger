plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "com.example.wodLogger.hilt"
            implementationClass = "HiltConventionPlugin"
        }
    }
}