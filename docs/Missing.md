## Specifications: Missing

The `Missing` class is a utility class. In addition to the obvious specifications illustrated in the UML class diagram, 
the `Missing` class must satisfy the following specifications:
1. The default double value of a missing value must be 0.0.
2. The `doubleValue(Double number)` method must return the double value of the `Double` parameter unless it is `null`, 
   in which case it must return the default double value of a missing value.
3. The `doubleValue(Double number, double missingValue)` method must return the double value of the `Double` 
   parameter unless it is `null`, in which case it must return `missingValue`.
4. The `doubleValue(Double number, double missingValue, double lowerBound)` method must return the double 
   value of the `Double` parameter unless it is `null` or it is less than `lowerBound`, 
   in which case it must return `missingValue`.
