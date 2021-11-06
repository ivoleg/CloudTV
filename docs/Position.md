## Specifications: Position

The `Position` enum is an encapsulation of a diver’s position. 
In addition to the obvious specifications illustrated in the UML class diagram, 
the `Position` enum must satisfy the following specifications:

1. The `STRAIGHT` instance must have a code of `'A'` and a description of `"Straight"`.
2. The `PIKE` instance must have a code of `'B'` and a description of `"Pike"`.
3. The `TUCK` instance must have a code of `'C'` and a description of `"Tuck"`.
4. The `FREE` instance must have a code of `'D'` and a description of `"Free"`.
5. The `FLY` instance must have a code of `'E'` and a description of `"Fly"`.
6. The `toString()` nethod must return the description.
7. The `fromCode(char code)` method must return the instance that corresponds to the
   given code or `null` if the code is invalid.
8. The `fromDescription(String description)` method must return the instance that
   corresponds to the given description (ignoring the case of the `String` objects) or 
   `null` if the description is invalid.
9. Appropriate `hashCode` and `equals` methods.
