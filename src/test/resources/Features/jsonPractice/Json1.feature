Feature: This is to practice KARATE json
  Scenario: testing Json
    * def cat = { name: 'Billie', scores: [2, 5] }
    * assert cat.scores[1] == 5

   Scenario Outline: testing Json with example
     * print "<name>"
     * print "<value>"
     Examples:
       |{ name: 'Billie', value:60 }|


