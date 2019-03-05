Feature: Gmail send email with image attachment

  Scenario: Attaching an image to email with one recipient
    Given I am on the new message page
    And I have selected a single email recipient
    When I click on the attach file button
    And I select a .png image I want to attach
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching two images to email with one recipient
    Given I am on the new message page
    And I have selected a single email recipient
    When I click on the attach file button
    And I select two .png images I want to attach
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching an image to email with two recipients
    Given I am on the new message page
    And I have selected a two email recipient
    When I click on the attach file button
    And I select a .png image I want to attach
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching a jpeg image to email with one recipient
    Given I am on the new message page
    And I have selected a single email recipient
    When I click on the attach file button
    And I select a .jpeg image I want to attach
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching a image over 25MB to email with one recipient
    Given I am on the new message page
    And I have selected a single email recipient
    When I click on the attach file button
    And I select a .png image over 25MB
    Then a file too large error message appears