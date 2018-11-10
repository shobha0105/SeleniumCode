Feature: To verify Dynamic loading functionality
Scenario: to click on Dynamic loading link and verify the respective screen
#* launch application 
Given launch "chrome" browser and url as "https://the-internet.herokuapp.com/"
Then verify page  by "url"   "https://the-internet.herokuapp.com/"  
Then click on "Dynamic Loading" link
Then verify page  by "url"   "https://the-internet.herokuapp.com/dynamic_loading"
Then click on "Example 1: Element on page that is hidden" link of dynamic loading page
Then switch to window with "url" as "https://the-internet.herokuapp.com/dynamic_loading/1"
Then click on Start button 
Then verify text as "Hello World!"
#Then click on "Example 2: Element rendered after the fact" link of dynamic loading page
#Then switch to window with "url" as "https://the-internet.herokuapp.com/dynamic_loading/2"
#Then click on Start button and verify text as "Hello World!"
And close application

