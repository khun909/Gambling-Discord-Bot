This is a Discord Bot written with the JDA library wrapper that that communicates with the official Discord api. This bot also allows users to request information on the server or details or their own profiles. This bot is still in work/progress. Feel free to use this bot as you wish. 


****Commands*****
!serverinfo  Gives information on the server such as creation date.

!userinfo @[UserName] Gives information on a specific user in the discord server


****Roulette Commands****
!register ~Registers the user in the database with a budget of 1000 points.

!finance ~The user's current points is checked to see if it is below 1000 points, and 1000 points will be assigned.

!roulette [pointamount] ~If a successfull roll is initiated, the pointamount the person entered will be added to their current balance. If not it will be subtracted.

!balance ~Checks the user's current balance.

!ranking ~Checks the top 5 highest point balances and returns their names.

!donate [UserName] [pointamount] ~Gives another user pointamount as long as the donator has enough points.

