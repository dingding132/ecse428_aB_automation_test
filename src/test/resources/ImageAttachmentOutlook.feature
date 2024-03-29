Feature: Outlook send email with image attachment

  Scenario: Attaching an image to email with one recipient
    Given I am on the new message page
    And I have added a single email recipient
    And I have written a subject
    When I attach a .png image
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching two images to email with one recipient
    Given I am on the new message page
    And I have added a single email recipient
    And I have written a subject
    When I attach two .png images
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching an image to email with two recipients
    Given I am on the new message page
    And I have added two email recipients
    And I have written a subject
    When I attach a .png image
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching a jpeg image to email with one recipient
    Given I am on the new message page
    And I have added a single email recipient
    And I have written a subject
    When I attach a .jpeg image
    And I click on “send” button
    Then I should be able to see the email in my “Sent” folder

  Scenario: Attaching a image over 33MB to email with one recipient
    Given I am on the new message page
    And I have added a single email recipient
    And I have written a subject
    When I attach a .png image over 33MB
    Then a file too large error message appears