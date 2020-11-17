Feature: Sending a message
  Agile Story: As a user, I should be able to send messages by clicking
               on Message tab under Active Stream.

  @fileUploading
  Scenario: User should be able to click on upload files and pictures from
            local disk, download from external drive, select documents from
            bitrix24, and create files to upload.
    Given User is on login page
    And  user logs in as "hr"
    And user navigates to "Activity Stream"
    When user clicks on Send Message button
    And user uploads following file:
       |File path|src/test/resources/testData/Screen Shot.png |
    And user clicks on Send button




