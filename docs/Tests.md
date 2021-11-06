# Tests

## Unit Tests

**The DropRule Class**

Lists: Empty List, null List, List with One Element, List with Two Elements, Small List with Unique Elements, Small List with Duplicates, Large List with Unique Elements, Large List with Duplicates, Small List with Identical Elements, Large List with Identical Elements
 Tests for Each List: Drop Lowest, Drop Highest, Drop Both

**The Missing Class**

Double Parameters: Zero Values, Positive Values, Negative Values, null Missing Value Parameter: Zero Values, Positive Values, Negative Values Lower Bound: Above the Value, Equal to the Value, Below the Value

## **Integration Tests**

Points must be calculated for one diver in a 1-meter springboard diving competition in which the degrees of difficulty are as follows:

| Dive                             | Degree of Difficulty |
| -------------------------------- | -------------------- |
| Forward Dive – Straight          | 1.4                  |
| Forward Dive – Pike              | 1.3                  |
| Forward Dive – Tuck              | 1.2                  |
| Forward Somersault – Straight    | 1.6                  |
| Forward Somersault – Pike        | 1.5                  |
| Forward Somersault – Tuck        | 1.4                  |
| Forward 1 1⁄2 Somersault – Pike  | 1.7                  |
| Forward 1 1⁄2 Somersault – Tuck  | 1.6                  |
| Forward Double Somersault – Pike | 2.3                  |
| Forward Double Somersault – Tuck | 2.2                  |
| Forward 2 1⁄2 Somersault – Pike  | 2.6                  |
| Forward 2 1⁄2 Somersault – Tuck  | 2.4                  |
| Forward Triple Somersault – Tuck | 2.9                  |
| Forward 3 1⁄2 Somersault – Tuck  | 3.0                  |

**IT Complete 01**

*Scores*

Forward Dive – Tuck: 8.5
Forward Double Somersault – Pike: 7.0 
Forward 3 1⁄2 Somersault – Tuck: 8.0 
Weighted Total
8.5*1.2 + 7.0*2.3 + 8.0*3.0 = 50.3

**IT Missing Weight 01**

*Scores*

Forward Dive – Tuck: 8.5
 Forward Double Somersault – Pike: 7.0 
Forward 3 1⁄2 Somersault – Tuck: 8.0
Back Dive – Pike: 9.0
*Weighted Total
8.5*1.2 + 7.0*2.3 + 8.0*3.0 +9.0*1.0 = 59.3

**IT Missing Weight 02**

*Scores*

Dive A – Tuck: 8.5
Dive B – Pike: 7.0
Dive C – Tuck: 8.0
*Weighted Total
8.5*1.0 + 7.0*1.0 + 8.0*1.0 = 23.5

**IT Invalid Weight 01**

*Invalid Weights*

Forward Dive – Tuck: 0.6 (instead of 1.2)

*Scores*

Forward Dive – Tuck: 8.5
Forward Double Somersault – Pike: 7.0 
Forward 3 1⁄2 Somersault – Tuck: 8.0
Back Dive – Pike: 9.0
*Weighted Total
8.5*1.0 + 7.0*2.3 + 8.0*3.0 +9.0*1.0 = 57.6

**IT Missing Score 01**

*Scores*

Forward Dive – Tuck: 8.5
Forward Double Somersault – Pike: 7.0 
Forward 3 1⁄2 Somersault – Tuck: 8.0 
Forward Dive – Pike: Missing
*Weighted Total
8.5*1.2 + 7.0*2.3 + 8.0*3.0 + 0.0*1.3 = 50.3

**IT Missing Score 02**

*Scores*

Forward Dive – Tuck: Missing
Forward Double Somersault – Pike: Missing 
Forward 3 1⁄2 Somersault – Tuck: Missing
*Weighted Total*
0.0*1.2 + 0.0*2.3 + 0.0*3.0 = 0.0

**IT Missing Score and Missing Weight 01**

*Scores*

Forward Dive – Tuck: 8.5
Forward Double Somersault – Pike: 7.0 
Forward 3 1⁄2 Somersault – Tuck: 8.0
Back Dive – Pike: Missing
*Weighted Total
8.5*1.2 + 7.0*2.3 + 8.0*3.0 + 0.0*1.0 = 50.3

## **System Tests**

Points must be calculated for the required program for a one diver in a sanctioned intra- departmental 1-metre springboard diving competition. Such competitions have two required dives, the forward dive in the pike position (101B) that has a degree of difficulty of 1.3, and a forward somersault in the tuck position (102C) that has a degree of difficulty of 1.4. There are five judges in all such competitions (from Albania, Belgium, Canada, Djibouti, and El Salvador) and the lowest and highest scores for each dive are dropped before the raw score is calculated. Then, the raw score for each dive is multiplied by its degree of difficulty and the two weighted scores are added to get the diver's total points.

**ST Complete 01**

Scores for 101B: 8.5 9.0 5.0 8.0 7.5
After dropping the high and low: 8.5 8.0 7.5 
Total: 24.0
Weighted total: 24.0 * 1.3 = 31.2

Scores for 102C: 7.5 8.0 4.0 9.0 7.5
After dropping the high and low: 7.5 8.0 7.5 
Total: 23.0
Weighted total: 23.0 * 1.4 = 32.2

Points: 31.2 + 32.2 = 63.4

**ST Complete 02**

Scores for 101B: 4.5 4.0 9.0 5.5 5.0
After dropping the high and low: 4.5 5.5 5.0 
Total: 15.0
Weighted total: 15.0 * 1.3 = 19.5

Scores for 102C: 6.0 6.5 9.5 6.0 6.5
After dropping the high and low: 6.0 6.5 6.5 
Total: 19.0
 Weighted total: 19.0 * 1.4 = 26.6

Points: 19.5 + 26.6 = 46.1

**ST Missing Score 01**

Scores for 101B: 8.5 9.0 5.0 N/A 7.5
After dropping the high and low: 8.5 5.0 7.5 
Total: 21.0
Weighted total: 21.0 * 1.3 = 27.3

Scores for 102C: 7.5 8.0 4.0 N/A 7.5
After dropping the high and low: 7.5 4.0 7.5 
Total: 19.0
Weighted total: 19.0 * 1.4 = 26.6

Points: 27.3 + 26.6 = 53.9