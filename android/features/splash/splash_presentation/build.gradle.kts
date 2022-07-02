apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.featuresSplashSplashDomain))
    "implementation"(project(Modules.featuresOnboardingOnboardingPresentation))

    "implementation"(Coil.coilCompose)
    "implementation"(SplashScreen.splashAndroidApi)

}