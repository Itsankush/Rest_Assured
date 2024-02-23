Feature: Doc string example

Scenario: User provides feedback
  Given the user is on the feedback page
  When the user provides the following feedback:
    """
    This is a sample feedback message.
    It can have multiple lines.
    """
  And clicks on the submit button
  Then the feedback should be submitted successfully
