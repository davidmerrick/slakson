Slack Kotlin library for building bots with [Micronaut](https://micronaut.io/).

Features:
* API objects are annotated with Micronaut's `@Introspected` for reflection-free serialization and deserialization.
* Slack client that's configurable via `annotations.yml`.

# Publishing

This package is published to GitHub's package repository.

1. Rev the `version` in `build.gradle.kts`
2. Set environment variables `BINTRAY_USERNAME` and `BINTRAY_API_KEY`
3. Run `./gradlew bintrayUpload -PbintrayUser=$BINTRAY_USERNAME -PbintrayKey=$BINTRAY_API_KEY`

# Reference

* https://medium.com/@sergio.igwt/publishing-a-kotlin-library-to-your-bintray-repo-using-gradle-kotlin-dsl-bdeaed54571a