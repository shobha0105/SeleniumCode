#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: To verify homepage functionality

@home
Scenario: to verify count of links on homepage
#* launch application 
Given launch "chrome" browser and url as "https://the-internet.herokuapp.com/"
Then verify page  by "url"   "https://the-internet.herokuapp.com/" 
Then verify link count is 41
And close application



