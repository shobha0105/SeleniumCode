Feature: To verify Alert functionality
Scenario: to click on Javascript alert link and verify the respective screen
#* launch application 
Given launch "chrome" browser and url as "https://the-internet.herokuapp.com/"
Then verify page  by "url"   "https://the-internet.herokuapp.com/"  
Then click on "JavaScript Alerts" link
Then verify page  by "url"   "https://the-internet.herokuapp.com/javascript_alerts"
Then click on Click for JS Prompt button
Then switch to alert pop up and settext as "This is the input text in the JS Prompt alert" and cancel it
Then click on Click for JS Alert button
Then switch to alert pop up and accept it
Then click on Click for JS Confirm button
Then switch to alert pop up and cancel it
#And close application

