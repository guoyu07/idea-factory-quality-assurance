Meta:
@category clientTests
@story RMI-1

Narrative: As a client I want to receive resposne from server

Scenario: User runs a single story

Given initialized client
When send sth to server
Then response is received

