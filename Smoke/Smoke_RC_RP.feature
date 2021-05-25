Feature: Validating Login Function

  @Automation @Regression @RWD @RC_Smoke @RC_Smoke1
  Scenario: RWD_Desktop_To Verify if user can start the challenge successfully
    Given User is logged in user name "user1" and password on DLX env
    And User is on the Book club landing Page
    When User taps on the "Create Challenge" CTA
    Then User should be navigated to the Create Challenge Page
    And User should be able to tap on the start Challenge CTA after filling all the mandatory fields with "ph3" and "Harry" title

  @Automation @Regression @RWD @RC_Smoke @RC_Smoke2
  Scenario: RWD DESKTOP To verify that user should be able to tap on Accept Challenges CTA to accept the reading challenge invite
    Given User is logged in user name "user3" and password on DLX env
    And User is on the Book club landing Page
    When User taps on the You have been challenged CTA RWD
    Then User should be able to view Reading Challenge overlay
    And Check that user able to tap on Accept Challenge CTA and user should navigate to accept challenge confirmation screen

   @Smoke_RP_Mob
  Scenario Outline: Mobile To verify the user can able to view details and join the programs available in myprogram tab
      Given Launch the  Application
    When Click location dropdown and enter the location and enter the school Name "<location>" and "<SchoolName>"
    And Enter the User Name and Password "<username>" and "<password>" click submit button
    And User is on the Book Club landing screen
    Then User should be able to tap on My Programs
    Then User should be able to see My Programs Landing screen with Active Draft Closed Programs
    Then Clicking on any Program card should open Program details on My Program Tab
    Then User should be able to tap on Open Programs
    Then User should be able to see Open Programs Landing screen with Ongoing and upcoming programs
    Then Clicking on any Program card should open Program details on Open Program Tab
    Examples:
     | location | SchoolName                    | username | password |
     | New York | Dlx Bnt Digital Site          | ph3      | ph3      |
