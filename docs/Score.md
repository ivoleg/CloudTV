## Specifications: Score

In addition to the obvious specifications illustrated in the UML class diagram, the
`Score` class must satisfy the following specifications:

1. `Score` objects **must be immutable**.
2. If a constructor is passed a key that is `null` or empty (i.e.,"") then the constructor must throw an 
   `IllegalArgumentException`.
3. The `Score(Stringkey)` constructor must construct a Score object with a `value` attribute of 0.0.
4. The `compareTo(Scoreother)` method must return `-1/0/1` if `this.value` is less
   than/equal to/greater than, `other.value` with the following caveats: 
   + 4.1 If `this.value` and `other.value` are both `null` then it must return `0`. 
   + 4.2 If `this.value` is `null` and `other.value` is not then it must return `-1`. 
   + 4.3 If `other.value` is `null` and `this.value` is not then it must return `1`.
5. The `toString(boolean verbose)` method must return a `String` representation of the `Score` object.
   + If `verbose` is `true` then:
        + If the `value` attribute is not `null` then the `String` must contain the `key` attribute, 
          followed by the `String` literal `":"`, followed by a single space, 
          followed by the `value` attribute (in a field of width 5 with 1 digit to the right of the decimal point).
        + If the `value` attribute is `null` then the `String` must contain the `key` attribute, 
          followed by by the `String` literal `":"`, followed by a single space, 
          followed by the `String` literal `"N/A"` (right-justified in a field of width 5).
   + If `verbose` is `false` then:
        + If the `value` attribute is not `null` then the `String` must contain the `value` attribute 
          (in a field of width 5 with 1 digit to the right of the decimal point).
        + If the `value` attribute is `null` then the `String` must contain the `String` literal `"N/A"` 
          (right-justified in a field of width 5).
6. The `toString()` method must return a terse `String` representation of the `Score` object.   
   Note that, while `null` key attributes are invalid (i.e., every `Score` object must have a non-null,
   non-empty key attribute), `null` value attributes are valid 
   (and are used to indicate that the `Score` is missing).
