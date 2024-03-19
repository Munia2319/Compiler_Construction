# Compiler_Construction
A small compiler for calculator using javacc
# Setting Up JavaCC in IntelliJ IDEA

This guide will help you set up JavaCC in IntelliJ IDEA, enabling you to compile and run JavaCC grammar files.

## 1. Install JavaCC Plugin in IntelliJ (Optional)

IntelliJ IDEA does not have built-in support for JavaCC, but you can add it through a plugin, which provides syntax highlighting, code completion, and other useful features.

- Go to `File > Settings` (or `IntelliJ IDEA > Preferences` on macOS).
- Navigate to `Plugins`.
- Search for "JavaCC" in the Marketplace tab.
- Install the plugin and restart IntelliJ if required.

## 2. Set Up Your Project

### Create a New Project

- Start IntelliJ IDEA and create a new Java project by going to `File > New > Project`.

### Add JavaCC to Your Project

You can either download the JavaCC jar directly or use a build tool like Maven or Gradle.

#### Manual Download

- Download the JavaCC zip file from the official JavaCC website and extract it.
- Add the `javacc.jar` to your project's library:
  - Right-click your project and select `Open Module Settings`.
  - Go to `Libraries`, click the `+` button, and add the `javacc.jar` file.

[Additional Installation Information](https://stackoverflow.com/questions/60589049/how-to-setup-javacc-in-windows-10)

#### Using Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>net.java.dev.javacc</groupId>
    <artifactId>javacc</artifactId>
    <version>7.0.10</version> <!-- Check for the latest version -->
</dependency>

