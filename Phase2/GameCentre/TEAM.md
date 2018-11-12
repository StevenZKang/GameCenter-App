# Group 0576 TEAM.md
---
## Contact information

Name | Email | Phone Number
--- | :---: | ---:
Christopher Marcok | chris.marcok@gmail.com | 647 767 1277 
Weiran Gu | weirangu@gmail.com | 613 600 8286
Thomas Liu | toms.liu@mail.utoronto.ca | 647 916 2674
Steven Kang | stevenz.kang@mail.utoronto.ca | 613 415 2126
Michelle Luo | michelle.luo@mail.utoronto.ca | 647 470 9428

### We will use either facebook group chat or discord to communicate.
---
## Team Contract
1. I will get my allotted work done on time.
2.  I will attend every team meeting and actively participate.
3. Should an emergency arise that prevents me from attending a team meeting, I will notify my team immediately.
4. The work will be divided roughly equally among all team members.
5. I will help my team to understand every concept in the project.
6. If I do not understand a concept or code, I will immediately ask my team for help.
7. All members of our team will do some coding. We will take turns coding while practicing pair coding.

We will alternate taking notes during meetings. By default Michelle will be the one to take notes.

Team Meeting:
## October 22, 2018

Today everyone cloned the repositories and we discussed briefly what we have to do (i.e.
required features, UI, dates to meet again) as well as created the MarkDown files.

## October 29, 2018

* Discussed the project flow, tasks required to be done and how we will split it.
* Spent time figuring out which classes needed to be activities and which don't.
* Made a UML document using LucidCharts to visualize the classes and how they will interact with each other.
* Designed simple UI for the app and discussed the optimal way to make our features intuitive to use.
* Decided what each activity required to perform it's function.

### Code-Related Discussion

* Want to abstract game classes so that when we implement more games, it should be simple to know what files we need for a new game
* Gamestate classes will be saved (serializable) so that they can be loaded later
* Create DBHandlers for username and scoreboard entries.
* Login Screen should have username and password fields
* Signup form in seperate activity, username and password. add restrictions to password (no empty password)
* Each game will appear in a game selection list, each shows the user's highscore in corner
* Game should autosave after each move, when app is closed or back button is pressed.
* Scoreboard has selection to choose from different games, or different difficulties (i.e. different tabs for 3x3, 4x4, 5x5)
* Cardview Design

App Design and flowchart:

![](https://i.imgur.com/IAsIdsR.jpg)

## November 1, 2018

* Discussed how to improve the implementation of the games using Fragments instead of activities
* Coded together in BA3200
* Helped each other understand the new code written as well as concepts such as fragments and ways
to build the UI/use XML.

## November 12, 2018

* Want to make 2048 game, Snake game. Other options are sudoku, solitaire, piano tiles, bejewelled, checkers.
* 2048 Can have undo and a meaningful autosave.
* Snake will not have undo. Could have saving functionality.
* Sudoku will have autosave and undo.
* Can make "Threes" game instead of 2048.
* Snake and 2048 use swiping gesture to control. Sudoku has the user tap and select (possibly each tile is a edittext).
* Presentation will be discussed later.
* Sliding Tiles solvable boards will be done via random moves from a solved state, can be refactored to check if the state is valid later.