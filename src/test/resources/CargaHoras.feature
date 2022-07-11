Feature: Hour operations

    Scenario: Successfully save a new Hour
        When Trying to add a new hour register with 8 hours
        Then it should be saved on the database


    Scenario: Obtaining hour registers
        Given a user has loaded 2 hours for Project 34 on Task 20
        When the user searches their workload
        Then it should return a list of their worked hours

    Scenario: Obtaining hour registers from a user who hasn't worked yet
        Given a user has no hours registered
        When the user searches their worked hours
        Then it should return nothing

    Scenario: Deleting registers
        Given a user has loaded 4 hours for Project 33 in Task 12
        When that load is deleted
        Then it doesn't appear anymore

    Scenario: Updating registers with full information
        Given a user has loaded 6 hours in Task 10 of Project 3
        When updating hours to 10, Project to 9, Task to 2 and description to "Create login"
        Then the update is reflected

    Scenario: Updating registers with partial information
        Given a user has loaded 4 hours on Task 11 for Project 32
        When updating only the hours to 11
        Then the hours are updated
        