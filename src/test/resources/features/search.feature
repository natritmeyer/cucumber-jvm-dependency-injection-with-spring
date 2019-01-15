Feature: Search for content

  Scenario: Search for information
    Given I am on the bing search engine
    When I enter a search term
    Then relevant results for that search term are displayed
