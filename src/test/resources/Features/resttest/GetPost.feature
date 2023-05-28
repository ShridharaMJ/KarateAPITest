Feature: Testing post request

  Background:
    * configure report = { showLog: true, showAllSteps: true }

  @V2Posts @Gorest
  Scenario: Validate posts requests from V2 controller
    Given url gorest
    And path 'public/v2/posts'
    When method GET
    Then status 200
    And print response
