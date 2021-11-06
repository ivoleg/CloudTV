## **Epics**

- [ ] E1.  As a salesperson I want the system to be able to be used with any judged competition so that I can sell it to the widest possible market.
- [ ] E2.  As a system administrator I want to be able to enter the attributes of a judged competition and have the system get the relevant information from the user, perform the relevant calculations, and display the relevant results so that the system can be used for different kinds of judged competitions.
- [ ] E3.  As a user I want to be able to enter the numeric scores given by judges in a competition to different participants, have the system perform the relevant calculations, and have the system display the results so that I don’t have to perform the calculations manually.
- [ ] E4.  As a salesperson I want the system to be able to handle diving competitions with different numbers of divers, judges, and scoring rules so that we can sell the system to several potential customers that have expressed an interest in such a system.
- [ ] E5.  As a user I want to be able to enter the numeric scores given by judges in a diving competition to different divers and have the system calculate raw scores for each dive and the total points earned by each diver (accounting for the degree of difficulty of the dives and situations in which the high and low score must be dropped) so that I can use the system at upcoming intra-departmental 1-meter springboard diving competitions..
- [ ] E6.  As a system administrator I want the capabilities of the system for diving competitions to be “hard-coded” so that I don’t have to configure this version.

## **Sprintable Stories** **ID Story**

| ID   | Story                                                        | Acceptance Criteria                                          |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| S1   | As a salesperson I want the system to work for an intra-departmental diving competition with two required dives (101B and 102C) and five judges (from Albania, Belgium, Canada, Djibouti, and El Salvador) in which the lowest and highest scores are dropped and the raw score is calculated as an evenly-weighted total of the other scores so that the system can be used right away in several upcoming events involving one of our perspective clients. | ☐ The system calculates the correct result for two system tests with this competition structure. |
| S2   | As a salesperson I want the system to be able to work when a single judge is unable to properly score a dive so that the system can be used even when judges are incompetent. | ☐ The system calculates the correct result for one system test which has a non-numeric score for a single judge.<br />☐ The system displays the correct result for one system test which has a non-numeric score for a single judge. |
| S3   | As a user I want the system to be able to calculate the final score for intra-departmental diving competitions so that I don’t have to perform the calculations by hand. | ☐ The system calculates the correct result for one integration test with complete information. |
| S4   | As a user I want the system to be able to handle missing weights (by using a weight of 1.0) so that I can use it even when I have incomplete information about weights. | ☐ The system calculates the correct result for one integration test with one weight missing.<br />☐ The system calculates the correct result for one integration test with all weights missing. |
| S5   | As a user I want the system to be able handle invalid weights (i.e., weights that are less than 1.0) by using a weight of 1.0 so that I can use it even when weights have been entered incorrectly. | ☐ The system calculates the correct result for one integration test with one invalid weight. |
| S6   | As a user I want the system to be able handle missing scores by using a score of 0.0 so that I can use it even scores aren’t entered. | ☐ The system calculates the correct result for one integration test with one score missing.<br />☐ The system calculates the correct result for one integration test with all scores missing.<br />☐ The system calculates the correct result for one integration test with a missing score and missing weight. |
| S7   | As a user I want to be able to enter all of the scores for a diver at the command line so that the system is easy to use. | ☐ The system calculates the correct result for two system tests with no missing scores. |
| S8   | As a user I want to be able to enter missing scores as “N/A” so that they can be entered easily. | ☐ The system calculates the correct result for one system test with values for one judge entered as “N/A” from the command line. |
| S9   | As a user I want the system to display the scores for both dives and the total points after I enter all of the scores at the command line course so that I don’t have to perform the calculations by hand. | ☐ The system displays the correct output for two system tests with no missing scores.<br />☐ The system displays the correct output for one system test with one missing value from one judge entered as “N/A” from the command line. |









