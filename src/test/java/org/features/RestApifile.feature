Feature: ResApifile

  @RestApi
  Scenario: To check rest api framework
    Given All the parameters to hit rest API
    When the Get API is called
    Then Get valid response code from API
    Then Validate All the Fields in The Response

  @PostAPI
  Scenario: Add pet to the store
    Given Prepare the parameters to hit API
    When the Post API is called
    Then Valid Response code from POST API
    Then i validate all the reponse body