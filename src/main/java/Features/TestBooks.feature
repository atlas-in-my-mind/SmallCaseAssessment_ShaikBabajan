Feature: Testing Books Details using GetBooks Url


  @TestCaseID_001 @Regression
  Scenario: Verify GetBooks API And Validate Data Types In Response
    Given I Get Books From ToolsQa BookStore
    Then I Verify The DataTypes Of Each Field In Response As Below
      | isbn   | title  | subTitle | author | publish_date | publisher | pages   | description | website |
      | String | String | String   | String | String       | String    | Integer | String      | String  |