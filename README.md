# Lab5: Grammar based parsing

In this lab, you are to perform syntax checking of a hypothetical programming language.

## The language

The language is a procedural calculator of numerical values.  The language supports the following types of statements:

- Basic arithemtic expressions over numerical values
- Print statements involving a mixture of string literals and numerical expressions
- Assignments of variables
- If-else branching over logical conditions
- For-loops over a _fixed_ integer range
- Declaration of functions with parameters

You are given a collection of valid programs to illustrate the syntax of the language.

### Simple expression

Basic arithemtic expressions that ends with `;` are considered valid statements.  A program is one or more statements.
Here is an example of three expression statements.

```
3.1415;
3.14 * (10 + 12.4) * 2;
pi * (r ** 2);
```

### Variable assignment

We can create symbol bindings between variable names and expressions.

```
pi = 3.1415;
r = 10 + 12.5;
area = pi * r ** 2;
```

### Comments

We support Java-style comments with `//`.

```
pi = 3.1415; // the constant
r  = 10;     // radius
pi * r ** 2; // the area
```

## Print statements

We can print a mixture of string literals and expressions.

```
print("Radius is", r, "Area is", pi * r ** 2);
```

### Function invocation

We support functions to be used in the expressions.

```
pi = 3.1415;
r1 = 100;
r2 = r1 * cos(45);
r3 = r1 * sin(45);
```

### Branching

We support if-else constructs.

```
if r3 < r2 {
  print("radius 3 is less than radius 2");
} else {
  print("radius 3 is NOT less than radius 2");
}
```

### For loop

We support a very simple form of for-loop.  The for-loop can only iterate over a range of integers specified by
integer literals.  An index variable is specified.

```
sum = 0;
for i in 0 to 10 {
  print("Index", i, "Sum", sum);
  sum = sum + i;
}
```

### Declaration of functions

Finally, we support declaration of user-defined functions.

```
function areaOfCircle(radius) {
  pi = 3.1415;
  pi * radius ** 2;
}

r = 10;
print("Radiius", r, "Area", area(r));
```

# Building a parser

Your task is to author a lexer and parser that can accept valid programs, but rejects invalid programs.  In this assignment, we are not concerned about the actual computational execution of the source code.

## Test code

You will find 10 valid programs, and 10 invalid programs containing various syntactic errors.  Your parser should accept all the valid programs, and reject the invalid programs.

## Authoring the grammar

Create the grammar `Calc.g4` using Antlr.  Make sure the start symbol is called `program`.  You are free to introduce any syntactic variables as well as tokenization rules.

## Learn the Java application code.

For this assignment, you are given two Java classes that will drive the authored grammar:

- `Check.java`.  It contains a static method `Check.file(String filename)` that will check the syntactic validity
of the specified file.  It will use the lexical analyzer to create the token stream, and parses the token stream
using the `CalcParser`.

- `ErrorListener.java` is an implementation of Antlr's `BaseErrorListen`.  It provides a basic error reporting upon tokenization and parsing.

- Study the code to understand how error handling is done for Antlr.  You are expected to do this for future assignments.

# Checking your work

A Makefile is given to you with the following targets:

- `make g4`: compiles the Antlr grammar and generates the necessary Java source files.
- `make java`: compiles the Java source files to generate the Java classes.
- `make check`: uses the generated Java parser to check the validity of all test files.
- `make clean`: removes all generated files
