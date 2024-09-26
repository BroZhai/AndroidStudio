plugins {
//    应用了一个插件，表示这个引用程序是可以直接运行的
    id("com.android.application")
}

android {
//    安卓必须包
    namespace = "comp4342.android.lab1"
    compileSdk = 33 //指定'开发编译'的版本

    defaultConfig {
        applicationId = "comp4342.android.lab1" //指定'项目包名'
        minSdk = 24 //指定项目'最低兼容版本'
        targetSdk = 33  //标明在'该版本'已经做过了'充分的测试'
        versionCode = 1  //指定项目的'版本号‘
        versionName = "1.0" //指定项目的版本名

        //下面这个是用于’单元测试‘的
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes { //用于生成'安装文件'的相关配置
        //里面会有俩闭包，一个叫debug{},另一个叫release{}
        /*debug: 生成"测试版"安装包的相关配置 (可忽略不写)
        *release: 生成"正式版"安装包的相关配置
        * */
        release { //正式版安装文件
            isMinifyEnabled = false //是否启用'代码混淆' (防止程序被逆向)
            proguardFiles( //指定'混淆'的配置项
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
//   指定当前项目所有的'依赖关系',非常强大
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}