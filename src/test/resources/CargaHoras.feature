Feature: Hour operations

    Scenario: Successfully save a new Hour
        When Trying to add a new hour register
        Then it should be saved on the database


    Scenario: Obtaining hour registers
        Given a user has saved registers
        When the user searches by id
        Then it should return an non empty list

    Scenario: Obtaining hour registers from a user not included
        Given a user has no hours registered
        When the user searches by id
        Then it should return nothing

    Scenario: Deleting a row
        Given a user has an hour register
        When it is deleted
        Then it doesn't appear anymore

    Scenario: Updating a row with full information
        Given a row exists
        When trying to update with full information
        Then the row is updated

    Scenario: Updating a row with partial information
        Given a row exists
        When trying to update
        Then the row is updated
        