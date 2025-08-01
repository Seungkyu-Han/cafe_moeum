plugins {
    kotlin("jvm") version "1.9.25"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.swagger.core.v3:swagger-annotations:2.2.34")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}