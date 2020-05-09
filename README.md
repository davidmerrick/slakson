Slack Kotlin library for building bots with [Micronaut](https://micronaut.io/).

Features:
* API objects are annotated with Micronaut's `@Introspected` for reflection-free serialization and deserialization.
* Slack client that's configurable via `annotations.yml`.

# Publishing

This package is published to GitHub's package repository.

1. Rev the `version` in `build.gradle.kts`
2. Set environment variables `GITHUB_USERNAME` and `GITHUB_TOKEN`
3. Run `./gradlew publish`

# Reference

* [Publishing to GitHub Package Repository](https://help.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-gradle-for-use-with-github-packages)