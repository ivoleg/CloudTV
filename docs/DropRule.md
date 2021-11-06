## **Specifications:** DropRule

In addition to the obvious specifications illustrated in the UML class diagram, the `DropRule` class must satisfy the following specifications:

1. public methods must not have any side effects. That is, they must not change the parameters that they are passed in any way (e.g., the `List` that is passed to the `apply()` method must not be changed in any way) and they must not change attributes that are not “owned” (i.e., attributes that are aliases) in any way.
2. You may assume that the `apply()`method is passed a list that does not contain any `null` elements.
3. The default constructo rmust construct a `DropRule` object that drops the lowest and highest element.
4. The `apply()` method must construct a new list that is a subset of the list it is passed.
   + If the `apply()` method is passed a `null` list then it must throw a `SizeException` exception.
   + If the `apply()` method is passed a list that contains fewer elements than are to be dropped then it must throw a `SizeException` exception.
   + If the `apply()` method is passed a list that contains the same number of elements as are to be dropped then it must throw a `SizeException` exception.
   + If the `apply()` method is passed a non-empty list that is sized appropriately then it must return a new list.
     + The elements of the new list must be aliases for (**not** copies of) the `Score` objects in the list it is passed.
     + Because each `Score` object in the list has a key that can be used to identify it, the new list need not be in the same order as the list it is passed.
     + The elements in (and size of) the returned list must be based on the values of the parameters that were passed to the constructor when the object was constructed.
       + If `shouldDropLowest` was `true` then it must drop exactly one of the elements with the lowest value in the original list. 
       + If `shouldDropHighest` was `true` then it must drop exactly one of the elements with the highest value in the original list. 
       + When dropping the highest and lowest, two elements must always be dropped, even if the highest and lowest have the same value.