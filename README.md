# session-attributes

This sample is developed in response to 
[this question](https://www.cuba-platform.com/support/topic/company-selector-in-main-window) on the CUBA support forum.

## Data Model

The application contains the [BusinessUser](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/global/src/com/company/sattr/entity/BusinessUser.java) enity, that refers to the system User, 
which comes along with CUBA and used for security and auth purposes. A business user also encapsulates 
additional information that is used by the business logic of your CUBA application. 
In this sample it has an additional reference to the [Company](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/core/src/com/company/sattr/core/AfterUserLoginEventListener.java) enity.

## Functional Overview

The application retrieves information about the related business user for a logged-in user 
and adds it into the session attribures, so it can be taken from it at any time. Find the implementation of this part [here]().

In the [main screen implementation](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/web/src/com/company/sattr/web/screens/ExtAppMainWindow.java) contains an example of how you can access this session attribute from the controller.
It sets a lookup field (in the top right corner) to a value, that is saved in the business user coming from session attributes.

## Useful Links

1. Read about the global application login actions in the official [documentation](https://doc.cuba-platform.com/manual-latest/login.html). Find how to hook the events [here](https://doc.cuba-platform.com/manual-latest/events.html) and how it is implemented in this project [here](https://github.com/aleksey-stukalov/session-attributes/blob/master/modules/core/src/com/company/sattr/core/AfterUserLoginEventListener.java).
2. Learn how to manipulate with the session attributes by reading [this chapter](https://doc.cuba-platform.com/manual-latest/session_attr.html) of the docs.
3. Find information on how to extend the main screen [here](https://doc.cuba-platform.com/manual-latest/main_window_layout.html) or just click a few times in the CUBA Studio and it will scaffold an extension for the main screen for you.
4. Find another way of extending the system user entity in [this sample](https://github.com/aleksey-stukalov/ext-user).
