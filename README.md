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


# Guide to Using JavaCC in IntelliJ IDEA and Command Prompt

This guide provides a step-by-step approach to working with JavaCC, including creating grammar files, compiling grammars, generating parsers, troubleshooting, and running files in IntelliJ IDEA and the command prompt.

## 3. Create a Grammar File

- Right-click on your source folder (e.g., `src/main/java`), navigate to `New > File`, and create a new file with a `.jj` extension (e.g., `MyGrammar.jj`).
- Write or paste your JavaCC grammar into this file.

## 4. Compile Your Grammar

### Manually

1. Open a terminal or command prompt.
2. Navigate to the directory containing your `.jj` file.
3. Run the command: `java -cp path/to/javacc.jar javacc MyGrammar.jj`
   - Replace `path/to/javacc.jar` with the actual path to your `javacc.jar` file and `MyGrammar.jj` with the name of your grammar file.

### Automating with IntelliJ

1. Go to `Run > Edit Configurations`.
2. Click the `+` button and select `Application`.
3. In the `Main class` field, enter `javacc`.
4. In the `Program arguments` field, enter the path to your `.jj` file relative to the project root.
5. In the `Classpath` field, add your project and the JavaCC library.
6. Apply the changes and run this configuration to compile your grammar.

## 5. Generate Parser

- Compiling the `.jj` file generates several Java files, including the parser and token manager. Include these generated files in your project and use them as part of your application.

## 6. Troubleshooting

- Ensure the JavaCC version is compatible with your project's Java version.
- If you encounter "class not found" or similar errors, double-check the classpath and ensure `javacc.jar` is correctly referenced.
- For syntax errors in the `.jj` file, consult the JavaCC documentation for proper grammar syntax.

## 7. Run File in IntelliJ

- After generating the parser, modify the main program to take input from the terminal.
- There will be a generated file, for example, `MyParser`. Run `MyParser` and check for errors.
- After running the main program, you should see the expected output.

## 8. Run File in the Command Prompt

### Javacc using in command prompt

1. Make the `.jj` file first.
2. Execute: `java -cp path/to/javacc.jar javacc MyGrammar.jj`
   - Replace `path/to/javacc.jar` with the actual path to your `javacc.jar` file and `MyGrammar.jj` with the name of your grammar file.
3. Compile with: `javac *.java`
4. For taking input from a file: `java MyLanguageParser < input.txt`
   - `MyLanguageParser` will be the name of your parser. In IntelliJ terminal, use: `Get-Content input.txt | java MyLanguageParser`

### Implementing JJTree

- Follow the guide on [how to implement JJTree on grammar](https://stackoverflow.com/questions/13902239/how-to-implement-jjtree-on-grammar).
- Make a file called, for example, `MyGrammar.jjt`.
- Then modify your main program like the code in the link above.
- Run the following command: `java -cp path/to/javacc.jar jjtree MyGrammar.jjt` then `java -cp path/to/javacc.jar javacc MyGrammar.jj`
- Compile with: `javac *.java`
- Run your parser with a test input: `java MyLanguageParser 'Your test input here'`

**Note:** If `java -cp` doesn’t work for you, then use only `jjtree MyGrammar.jjt` and `javacc MyGrammar.jj`.
...

## For Running the Generated Code

After you have generated the parser as per the instructions in the previous sections, you can run the generated code to see it in action. This example focuses on running a calculator program generated from a `.jj` file.

### Steps to Run the Calculator Program

1. **Navigate to the Generated Code Directory**: Open your project directory and navigate to the `Generation_of_code_calculator` folder.

2. **Locate the Calculator Grammar File**: Inside the directory, go to `src` and find the `Calculator.jj` file. This file contains the grammar definitions used by JavaCC to generate the parser.

3. **Compile and Run the Program**: Follow the instructions provided in the "Compiling Your Grammar" and "Running File in the Command Prompt" sections to compile the `.jj` file and run the generated parser. In this case, your commands in the terminal or command prompt might look something like this:

    ```bash
    java -cp path/to/javacc.jar javacc Calculator.jj
    javac *.java
    java Calculator
    ```

    Replace `path/to/javacc.jar` with the actual path to your `javacc.jar` file, and ensure you're in the directory containing `Calculator.jj` when you run these commands.

4. **View Your Output**: After running the `Calculator` program, your output will be displayed in the command prompt or terminal window. This output will show the results of the calculator operations defined in your `Calculator.jj` grammar file.

**Note**: Make sure you have followed the setup instructions correctly, especially regarding the installation of JavaCC and the configuration within your IDE or command line environment.

## Troubleshooting

If you encounter any issues while running your generated code, refer back to the "Troubleshooting" section for guidance on common problems and solutions.

...



