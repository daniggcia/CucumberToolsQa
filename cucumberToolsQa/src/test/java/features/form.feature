Feature: Register Form

Scenario: Form Registration with Valid Data
Given  the website Toolsqa is available
When  register my data
And click button submit
Then  the recorded data is displayed
And we close the browser