---
name: documentation
description: This skill is made for documenting a file. This skill expects at least one file as context to document; if the user doesn't provide such, ask the user again.
arguments:
  - name: file
    description: Path to the file to review
    required: true
allowed-tools:
  - edit
model: sonnet
effort: high
---

If an argument at $0 is found and is a valid file name, generate documentation for that. Otherwise, if the keyword is specifically "--ALL", then write documentation for the entire codebase if a file is of type .kt or .java.

# Documentation Generation Guidelines

- For now, start with the generic `/** */` format
- Generate documentation for content of a specified file(s)
- Skip over methods or classes that are labeled with a @HUMAN, as those are to be documented by a human.
- No inline comments: document only method or class headers.
- If some code already is documented, update that documentation if it would be more accurate due to code changes.
- At the end of file, comment "AI-DOCUMENTATION", and then outline what changes were made to that file via AI. Formatted like
```java
/**
 * AI-DOCUMENTATION
 * The following documentation was AI generated:
 * - summary 
 * - of 
 * - changes
 */
```