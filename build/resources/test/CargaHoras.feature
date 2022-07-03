Feature: Hour operations

    Scenario: Successfully save a new Hour
        When Trying to add a new hour register
        Then it should be saved on the database

    Scenario: Unsuccessfully save a new Hour
        When trying to add a new hour register without correct entry
        Then it shouldn't be saved on the database

    Scenario: Obtaining hour registers
        Given a user has saved registers
        When the route is called
        Then it should return an non empty list

    Scenario: Obtaining hour registers from a user not included
        Given a user has no hours registered
        When the route is called
        Then it should return nothing

    Scenario: Deleting a row
        Given a user has an hour register
        When it is deleted
        Then it doesn't appear anymore

    Scenario: Deleting a non existent row
        Given a row doesn't exist
        When trying to delete it
        Then it shouldn't do anything

    Scenario: Updating a row with full information
        Given a row exists
        When trying to update with full information
        Then the row is updated

    Scenario: Updating a row with partial information
        Given a row exists
        When trying to update
        Then the row is updated

    Scenario: Updating a row that doesn't exist
        Given a row doesn't exist
        When trying to update
        Then nothing is updated