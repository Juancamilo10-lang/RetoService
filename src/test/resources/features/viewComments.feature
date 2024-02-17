 Feature: View comments by PostID

  @GetCommentsById
  Scenario Outline: View comments by PostID
    When I consume the endpoint by "<postId>"
    Then I willl be able to wiew the comments available for the desired PostId

    Examples:
    |postId|
    |      2|
