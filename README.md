# session-attributes

This sample is developed in response to 
[this question](https://www.cuba-platform.com/support/topic/company-selector-in-main-window) on CUBA support forum.

## Data Model

The application contains the BusinessUser enity, that refers to the system User, 
which comes along with CUBA and used for security and auth purposes. A business user also encapsulates 
additional information that is used by the business logic of your CUBA application. 
In this sample it has additional reference to the Company enity.

## Functional Overview

The application retrieves information about the related Business user for a logged-in user 
and adds it into the session attribures, so it can be taken from it at any time. 

In the main screen shows an example of how you can access this session attribute from the controller.
It sets a lookup field (in the top right corner) to a value, that is saved in the business user coming from session attributes.   

## Implementation Details

