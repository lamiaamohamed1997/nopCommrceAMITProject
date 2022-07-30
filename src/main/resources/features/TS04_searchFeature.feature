@smoke
Feature: 4-Search - guest user should be able to search for any product

  Scenario Outline: guest user searches for a product keyword and view results successfully
    Given guest user clicks on search tab
    When guest user enters search keyword "<keyword>"
    And guest user hits enter to search
    Then search results are displayed for user with "<keyword>"
    Examples:
      | keyword |
      | book    |
      | laptop  |
      | nike    |

  Scenario Outline: guest user searches with sku and view results successfully
    Given guest user clicks on search tab
    When guest user enters search sku "<sku>"
    And guest user hits enter to search
    Then guest user clicks on item to view details
    And product sku matches selected "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |