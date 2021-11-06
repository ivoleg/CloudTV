## Specifications: TotalSystem

In addition to the obvious specifications illustrated in the UML class diagram and the specifications for the parent class and interface, the `TotalSystem` class must satisfy the following specifications:

1. public methods must not have any side effects. That is, they must not change the parameters that they are passed in any way (e.g., the list that is passed to the calculate() method must not be changed in any way) and they must not change attributes that are not “owned” (i.e., attributes that are aliases) in any way.
2. You may assume that the `calculate()` method is passed a list that does not contain any `null` elements.
3. If the value of a particular `Score` ismissing (i.e.,`null`) then a value of 0.0 must be used. 
   Note: The `Missing` class has a method that can be used to accomplish this.
4. The `calculate()` method must calculate the total of the list of `Score` objects it is passed.
   + If the list is `null` then it must throw a `SizeException`.
   + If the list is empty then it must throw a `SizeException` exception. 
   + Otherwise, it must return a `Score` object with the given key and a value equal to the total of the `Score` objects in the list.

