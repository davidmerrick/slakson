group = "io.github.davidmerrick.slakson"
version = "2.0.2"

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
}


dependencies {
    val micronautVersion by extra("1.3.4")

    // Main

    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")

    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-inject")
    implementation("io.github.microutils:kotlin-logging:1.7.2")
    implementation("io.micronaut:micronaut-http-client")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-simple:1.8.0-beta4")

    // Test

    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kaptTest("io.micronaut:micronaut-inject-java")

    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    testImplementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("io.micronaut.test:micronaut-test-kotlintest")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }

    test {
        useJUnitPlatform()
    }
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/davidmerrick/slakson")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}