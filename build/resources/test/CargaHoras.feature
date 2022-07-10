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

    Scenario: Deleting registers
        Given a user has an hour register
        When it is deleted
        Then it doesn't appear anymore

    Scenario: Updating registers with full information
        Given a user has saved registers
        When trying to update with full information
        Then the registers is updated

    Scenario: Updating registers with partial information
        Given a user has saved registers
        When trying to update with partial information
        Then the registers is updated
        