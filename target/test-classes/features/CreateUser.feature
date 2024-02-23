Feature: User Creation

@UserCreation
  Scenario: Create user
    Given Post request with <name> <job>
    Then Get the user
