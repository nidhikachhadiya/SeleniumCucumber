Feature: "Validate Login Functionality of Facebook"
Scenario:
  Given Launch Chrome driver and hit Facebook URL
  When Add username and wrong password and click on login button
  Then Message should displayed as The password that you've entered is incorrect. Forgotten password