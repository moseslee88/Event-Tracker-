# Event-Tracker-
I created a short, SpringREST web app that keeps a track of the ratio of at-bats per home run for some professional baseball athletes.
After configuring the project with Gradle configurations, I created the JPA side, my "Ballplayer" entity, and then i went to work on the Controller methods and DAO Impl.


I populated data to the database using information I got from [here](https://www.baseball-reference.com/teams/).  As a lifelong fan of baseball, it's always interesting to see exorbitantly-paid baseball players overperform, perform to their standards, or be a complete albatross and waste of money to their team.  At bats/ home run is one of the numerous ways, that
one can track the success (or lack thereof) of a slugger. If he is in a good groove, he should be hitting home runs at a pretty low rate. A high at-bats/home run ratio either means that he is a contact hitter, or he is just not hitting for power in a given season. I had a lot of fun with seeing how well some players were doing this year, especially once their salaries were revealed.  For example, even though Giancarlo Stanton is making 14.5 million dollars in salary this year, I think in my humble opinion that he is UNDERpaid because he is hitting 
home runs at a Babe Ruthian pace of 10.05 at-bats per home run, which is akin to roughly 1 every 3 games. For the purposes of this lab and brevity, I only filled mySql database with 
data from the best player of each National League team.  In the future, I can always refer back to this database, and add players from the American League, as well.
