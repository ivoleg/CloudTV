# Reassessment Coursework  - CloudTV

An individual coursework to be completed in the spring of 2021.

## 1 Learning Objectives

The main aim of this assignment is to help you review (and demonstrate that you have acquired) the knowledge and skills required to program in Java to a semi-professional level. From a language and algorithms perspective, there is nothing new in this assignment that you haven't already seen during the module. This assignment will expose you to the kinds of software engineering documents you will be reading and writing throughout your career as a software developer.

## 2 Overview

*CloudTV* is a (fictitious) company that designs, creates and markets products that provide a cloud perspective on television. Their products make television both more interactive and more informative.

They are in the process of developing a suite of products called `forScore` for judged competitions of various kinds (e.g., sporting events like diving and gymnastics, singing contests, dance competitions). These products will be used by the organizers and the broadcasters of the events, and the viewers/audience. They have hired you to construct several interfaces/classes that will, ultimately, become part of these products.

These classes/interfaces will initially be used by an application that can be used to score the required program for one diver in a springboard diving competition. For example, running this application with the command-line parameters `8.5 9.0 5.0 8.0 7.5 7.5 8.0 4.0 9.0 7.5 Thomas` should generate the following output.

```
Results for Thomas

                               ALB BEL CAN DJI ESA |  Raw
           Forward Dive - Pike 8.5 9.0 5.0 8.0 7.5 | 24.0
     Forward Somersault - Tuck 7.5 8.0 4.0 9.0 7.5 | 23.0
                 Points:  63.4
  
```

As another example, running this application with the command-line parameters `4.5 4.0 9.0 5.5 5.0 6.0 6.5 9.5 6.0 6.5 Fox` should generate the following output.

```
Results for Fox

                               ALB BEL CAN DJI ESA |  Raw
           Forward Dive - Pike 4.5 4.0 9.0 5.5 5.0 | 15.0
     Forward Somersault - Tuck 6.0 6.5 9.5 6.0 6.5 | 19.0
                 Points:  46.1
  
```

## 3 Documentation

You already know about an agile process known as "scrum", and you will use scrum to complete this final assignment. All of the documents prepared for this assignment assume that CloudTV uses scrum. 

The terminology that CloudTV uses when discussing `forScore` and its functionality are described in the following document:

- [Product Domain Glossary](docs/Glossary.md)

When using scrum, time is divided into time intervals called *sprints* that typically last 1-2 weeks, and product features are organized into *stories*. We obviously don't have that amount of time available to us so all the time intervals are necessarily shortened. 

CloudTV categorizes stories as either *epics*, abstract stories that might take several releases (developed over the course of many months) to completely realize, and *sprintable stories* that describe what will be completed in a single sprint (and included in the product at the end of the sprint). The sprintable stories (which are what you are concerned with for this assignment) for `forScore` have been collected in the following document (along with some epics that are not part of this assignment).

- [Stories for forScore](docs/Stories.md)

Your team at CloudTV used the sprintable stories to create a set of tasks for this assignment. The other members of your team completed some of the tasks and have left others for you to complete. The complete set of tasks is contained in the following document.

- [Tasks for forScore](docs/Tasks.md)

Some of the tasks have already been completed by other team members, the evidence for which is contained in the following artefacts:

- [Engineering Design for `forScore`](EngineeringDesign_forScore.pdf)
- Implementation of the main class (named `IndividualScorer` in the `app` package) for this release (see repository)
- Implementation of the `DifficultyTable1mS` class (in the `diving` package) for this release (see repository)
- [Specification of the `Position` enum](docs/Position.md)
- [Specification of the `Missing` class](docs/Missing.md)
- [Specification of the the `Score` class](docs/Score.md)
- [Specification of the `SizeException` class](docs/SizeException.md)
- [Specification of the `DropRule` class](docs/DropRule.md)
- [Specification of the `TotalSystem` class](docs/TotalSystem.md)
- [Specification of the `WeightedTotalSystem` class](docs/WeightedTotalSystem.md)
- [System/Integration Tests for forScore](docs/Tests.md)

You must complete the tasks that have not been "checked-off". The code you write must be consistent with the documents prepared by the team.

The completed tasks from the list are: 1, 2, 3, 7, 8, 12, 13, 14, 15, 19, 20, 21, 23, 24, 25, 26, 32, 34, 35, 36, 37, and 38.

##  5 Testing

Some of the tasks that you must complete involve unit testing. You must use JUnit (v5) for this purpose. Your JUnit test suite should cover all statements and all branches (as measured by `EclEmma`) in **all of the classes/enums you write**. You should not write tests for the code that was provided to you. **Your tests must be in a package named `testing` and each test class must include the word "Test" in its name.**

## 6 A Possible Process

The tasks are organized by story. Hence, though they are numbered (so that they can be referred to in documents and conversations), the numbers should not, in any way, influence the order in which you complete them. I would suggest you sequence your activities as follows:

- [ ] Read all of the documents.
- [ ] Review the source code for the `IndividualScorer` class so that you understand how the classes you are implementing will be used.
- [ ] Test, implement, and debug the `Position` enum.
- [ ] Test, implement, and debug the `Missing` class.
- [ ] Test, implement, and debug the `Score` class.
- [ ] Test, implement, and debug  the `SizeException` class.
- [ ] Implement the `ScoringSystem` interface.
- [ ] Think about how the `WeightedTotalSystem` and `TotalSystem` classes should be related (if at all).
- [ ] Test, implement and debug the `WeightedTotalSystem` or `TotalSystem` class (whichever one you think should be implemented first).
- [ ] Test, implement and debug the `WeightedTotalSystem` or `TotalSystem` class (whichever one you think should be implemented second).
- [ ] Implement the `Rule` interface.
- [ ] Test, implement, and debug the `DropRule` class.
- [ ] Test and debug the complete system (using the main class named `IndividualScorer`).

## 7 Submission

You must submit, via the usual `add/commit/push` `GitHub Classroom` cycle:

1. Your implementation of the required interfaces/classes/enums in the appropriate package(s). 
2. JUnit tests for all of your classes/enums in a package named `testing`.

## 8 Grading

Your submission will be graded as follows:

- Conformity to the Style Guide (Style) - 10% (All or Nothing)
- Passing your Tests (SelfTests) - 10% (All or Nothing)
- Coverage of your Tests (Coverage) - 20% (Partial Credit Possible)
- Correctness of your Code (OfficialTests) - 60% (Partial Credit Possible)

Points will be deducted for code that is unclear, inelegant, and/or poorly documented.

## 9 Reminders

Remember to read and follow all policies related to coursework assignments (including style guides, submission requirements, collaboration rules, etc...).

------