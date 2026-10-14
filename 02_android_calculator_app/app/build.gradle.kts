plugins {
    id("com.android.application")
}

android {
    namespace = "kr.ac.khu.lab05.calculator"
    compileSdk = 36

    defaultConfig {
        applicationId = "kr.ac.khu.lab05.calculator"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// 화면은 Android 기본 프레임워크(Activity, EditText, Button, TextView)만 사용
dependencies {
    // 계산 로직(FourBasicOpt) 단위 테스트 - 실습 1 TDD 와 같은 테스트 케이스
    testImplementation("junit:junit:4.13.2")
}
