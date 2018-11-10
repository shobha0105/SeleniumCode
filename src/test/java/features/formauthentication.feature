Feature: To verify Form authentication functionality
@FA
Scenario: Verify Form Authentication screen with correct login credentials
#* launch application 
Given launch "chrome" browser and url as "https://the-internet.herokuapp.com/"
Then verify page  by "url"   "https://the-internet.herokuapp.com/"  
Then click on "Form Authentication" link
Then verify page  by "url"   "https://the-internet.herokuapp.com/login"
Then enter username as "tomsmith"
Then enter password as "SuperSecretPassword!"
Then click on Login button
Then verify page  by "url"   "https://the-internet.herokuapp.com/secure"
Then click on Logout button
And close application



