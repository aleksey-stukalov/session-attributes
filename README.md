# session-attributes

This sample is developed in response to 
[this question](https://www.cuba-platform.com/support/topic/company-selector-in-main-window) on the CUBA support forum.

## Data Model

The application contains the [BusinessUser](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/global/src/com/company/sattr/entity/BusinessUser.java) enity, that refers to the system User, 
which comes along with CUBA and used for security and auth purposes. A business user also encapsulates 
additional information that is used by the business logic of your CUBA application. 
In this sample it has additional reference to the [Company](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/global/src/com/company/sattr/entity/Company.java) enity.

## Functional Overview

The application retrieves information about the related business user for a logged-in user 
and adds it into the session attribures, so it can be taken from it at any time. Find the implementation of this part [here]()

In the [main screen implementation]() contains an example of how you can access this session attribute from the controller.
It sets a lookup field (in the top right corner) to a value, that is saved in the business user coming from session attributes.

## Useful Links

1. Read how to hook global application actions like login in the official [documentation](https://doc.cuba-platform.com/manual-6.5/gui_web.html). Find how it is implemented in this project [here] and [here].
2. Learn how to manipulate with the session attributes by reading [this chapter]() of the docs.
