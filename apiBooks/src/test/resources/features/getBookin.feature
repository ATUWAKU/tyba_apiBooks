Feature: As an Automator I want to create the automatic tests of the service to consult books to guarantee the quality

  Scenario Outline: Consult book Happy path
    When I request boo information with id "<BookId>"
    Then  The service must show
      |firstname  |lastname  |totalprice  |depositpaid  |checkin  |checkout  |
      |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>|<checkout>|
    Examples:
    |BookId|firstname|lastname|totalprice|depositpaid|checkin   |checkout  |
    |20899 |Jim      |Brown   |111       |true       |2018-01-01|2019-01-01|
    |1822  |Javier   |Sevilla|111       |true        |2018-01-01|2019-01-01|
    |19498 |Sally    |Brown   |111       |true       |2013-02-23|2014-10-23|