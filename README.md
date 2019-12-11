# BilliardsApp
An android application that obtains player and team information from Amateur Billiards League database and uses this data to track game and match scores. 

ABLS2-Copy/app/src/main/java/com/example/abls for code 

Classes -

Screen 1 - Start (No name and password needed for test version)

Screen 2 - TeamListActivity/TeamListFragment

Screen 3 - TeamActivity/TeamFragment

Screen 4.1 - ScoreActivity/ScoreFragment

Screen 4.2 - RosterActivity/RosterFragment

Screen 4.3 - MatchListAcivity/MatchListFragment

Screen 5.1 - ChoosePlayerAListActivity/ChoosePlayerAListFragment (from ScoreActivity/ScoreFragment)

Screen 5.2 - RosterActivity/RosterFragment (from ScoreActivity/ScoreFragment, recycles Screen 4.2 to display opposing teams roster)

Screen 6 - ChoosePlayerBListActivity/ChoosePlayerBListFragment

Screen 7 - MatchInfoActivity/MatchInfoFragment 

Screen 8 - GameActivity/GameFragment (recycles depending on the number of games per player match and team match)


Background - Makes calls to the api to retrieve and set information on the database

Game - Keeps track of important information for each game

Match - Singleton that keeps tracks of the entire match, including a list of every game played

Player - For use with the login function call to the api.

Player2 - For use with the getRoster function call to the api (for opposing players)

Team - For use with the getTeams function call to the api (main players teams)

Team2 - For use with the getRoster function call to the api (opposing teams)

TeamList/MatchList - Singletons for holding information about the mainplayers teams and matches for that night

