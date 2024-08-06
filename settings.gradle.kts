pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // for uni-app x
        maven {
            url = uri("https://jitpack.io")
        }

        flatDir {
            dirs("./plugins/")
        }
    }
}

rootProject.name = "uniappx-offline-for-android"
include(":app")
include(":uniappx")
include(":kux-request")
