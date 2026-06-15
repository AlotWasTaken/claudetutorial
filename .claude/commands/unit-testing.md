---
name: unit-testing
description: A skill made for making unit tests. This skill should be used whenever prompted to make unit tests, as it contains information about the project that isn't otherwise clear from just evaluating the code. 
metadata:
  author: me!
  version: 2.1.0
  date: 6/5/26
---

# Test Generation Guidelines

## Component Types & Their Testing Approaches

### For UI elements...
- Use Junit4 for writing tests
- Focus on rendering and user interactions
- Test props/inputs and outputs/events (if there are any)

### For functional elements...

- For now, test basic I/O to see if they do what is expected.

## Other Testing Info

- Make testing names human-readable camel case
- Use comments when the above is not possible
- Write these tests into their respective test files. For Example, java focused tests of a specific class might belong in app/src/test/java/com/example/testapp1, whereas andriod focused ones might belong in app/src/androidTest

## Common Mistake to Avoid

- to be added