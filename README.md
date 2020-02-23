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
