plugins {
    java
    application
    alias(libs.plugins.style)
    alias(libs.plugins.jagr.gradle)
}

version = file("version").readLines().first()

jagr {
    assignmentId.set("h03")
    submissions {
        val main by creating {
            studentId.set("ab12cdef")
            firstName.set("sol_first")
            lastName.set("sol_last")
        }
    }
    graders {
        val graderPrivate by creating {
            graderName.set("H03-Private")
            rubricProviderName.set("h03.H03_RubricProvider")
            configureDependencies {
                implementation(libs.annotations)
                implementation(libs.algoutils.tutor)
                implementation(libs.fopbot)
                implementation(libs.mockito.core)
                implementation("org.junit-pioneer:junit-pioneer:1.9.0")
            }
        }
        val graderJavadoc by creating {
            parent(graderPrivate)
            graderName.set("H03-Javadoc")
        }
    }
}

dependencies {
    implementation(libs.annotations)
    implementation(libs.algoutils.student)
    implementation(libs.fopbot)
    implementation(libs.mockito.core)
    testImplementation(libs.junit.core)
}

application {
    mainClass.set("h03.Main")
}

tasks {
    val runDir = File("build/run")
    withType<JavaExec> {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
    }
    test {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
        useJUnitPlatform()
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}
