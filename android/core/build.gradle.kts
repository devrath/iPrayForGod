apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(DataStorePreferences.datastorePreferences)
    "implementation"(AndroidX.coreKtx)
}