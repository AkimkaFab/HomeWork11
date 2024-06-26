import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.apache.tools.ant.RuntimeConfigurable
import org.jetbrains.kotlin.daemon.common.ensureServerHostnameIsSetUp
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.konan.target.hostTargetSuffix

//import org.slf4j.Logger


//val allureVersion = "2.24.0"
//val aspectJVersion = "1.9.20.1"
//val agent: Configuration by configurations.creating {
//    isCanBeConsumed = true
//    isCanBeResolved = true
//}

plugins {
    kotlin("jvm") version "1.9.20"
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("java")
//    id("io.qameta.allure") version "2.11.2"
//    id("io.qameta.allure-report") version "2.11.2"
//
//    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.27"
//    application
//    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"




repositories {
    mavenCentral()
    gradlePluginPortal()
}

//reporting {
//    baseDir = File("allureReports")
//}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
//    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
//    testImplementation("io.qameta.allure:allure-junit5")

//    implementation("io.qameta.allure:allure-commandline:2.19.0")

    testImplementation ("io.kotest:kotest-runner-junit5:5.6.0")
    testImplementation ("io.kotest:kotest-assertions-core:5.6.0")
    testImplementation("io.kotest:kotest-property:5.6.0")

    testImplementation("net.serenity-bdd:serenity-core:4.0.28")
    testImplementation("net.serenity-bdd:serenity-junit5:4.0.28")
    testImplementation("net.serenity-bdd:serenity-screenplay:4.0.28")
    testImplementation("net.serenity-bdd:serenity-ensure:4.0.28")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:4.0.28")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("junit:junit:4.13.2")

//    agent("org.aspectj:aspectjweaver:${aspectJVersion}")
    //testImplementation("io.qameta.allure:allure-junit5:3.0.0")

    //хз
    //classpath("com.github.johnrengelman:shadow:8.1.1")

//    shadow localGroovy()
//    shadow gradleApi()
    implementation("org.jdom:jdom2:2.0.6")
    implementation("org.ow2.asm:asm:6.0")
    implementation("org.ow2.asm:asm-commons:6.0")
    implementation("commons-io:commons-io:2.4")
    implementation("org.apache.ant:ant:1.9.4")
    implementation("org.codehaus.plexus:plexus-utils:2.0.6")
}


//apply plugin: "com.github.johnrengelman.shadow"
//apply plugin: "java"

tasks.test {
    useJUnitPlatform()
}

//tasks.test {
//    jvmArgs = listOf(
//        "-javaagent:${agent.singleFile}"
//    )
//}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

//tasks.withType<Test>().configureEach {
//    useJUnitPlatform()
//}

//application {
//    mainClass.set("MainKt")
//}

//allure {
//    version.set("2.19.0")
//    ensureServerHostnameIsSetUp()
//}

//detekt {
//    ignoreFailures = true
//    debug = true
//    baseline = file("src/test/resources/detektReport.xml")
//}


tasks.register<GradleBuild>("allureServeAndDetekt") {
    tasks = listOf("build", "detekt", "myAllureServe")
}

tasks.register<GradleBuild>("aggregateAndDetekt") {
    tasks = listOf("detekt", "aggregate")
}

//tasks.register<shadowJar>('shadowJar') {
//    enableRelocation true
//}