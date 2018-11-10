Feature: To verify Multiple windows functionality
Scenario: to click on Multiple windows link and verify the respective screen
#* launch application 
Given launch "chrome" browser and url as "https://the-internet.herokuapp.com/"
Then verify page  by "url"   "https://the-internet.herokuapp.com/"  
Then click on "Multiple Windows" link
Then verify page  by "url"   "https://the-internet.herokuapp.com/windows"
Then click on "Click Here" link of multiple windows page
Then switch to window with "url" as "https://the-internet.herokuapp.com/windows/new"
Then verify "New Window" text
Then switch to window with "url" as "https://the-internet.herokuapp.com/windows"
Then verify "Opening a new windows" text
And close application

