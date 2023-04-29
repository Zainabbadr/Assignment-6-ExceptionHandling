# Assignment-6-ExceptionHandling
# Autosar Container Sorter

This program reads an Autosar XML file, extracts container information, sorts the containers alphabetically by their short names, and generates a modified XML file with the sorted containers.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- Autosar XML file (.arxml) to process

### Running the Program

1. Clone or download the project to your local machine.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java source files using the following command:
4. Run the program with the Autosar XML file as an argument using the following command:
Replace `<autosar_file.arxml>` with the path to your Autosar XML file.
5. The program will process the file, sort the containers, and generate a modified XML file with the suffix `_mod.html`.
For example, if your input file is `input.arxml`, the output file will be `input_mod.html`.

## Exception Handling

The program includes exception handling for specific scenarios:

- `NotVaildAutosarFileException`: Thrown when the input file does not have the `.arxml` extension.
- `EmptyAutosarFileException`: Thrown when the input file is empty.

## Customizing the Program

You can modify the behavior of the program by editing the `Container` class and the main method in the `App` class.

- `Container` class: This class represents an Autosar container and implements the `Comparable` interface for sorting.
You can customize the comparison logic in the `compareTo` method to change the sorting order.

- `App` class: The `main` method is the entry point of the program. You can modify the code to suit your specific requirements.
For example, you can change the output file format or add additional processing steps.

## License

This project is licensed under the [MIT License](LICENSE).

