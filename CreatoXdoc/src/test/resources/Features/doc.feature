Feature: Test documentation feature functionality

Scenario: Verify user is navigated to add documentation to the new feature form
	
	Given user is on add doc page
	When user clicks on Create a New Feature documentation
	Then user should be navigated to Add New Feature Documentation section form

Scenario Outline: Verify user is able to add documentation to the new feature
    Given user is on add doc page
    When user clicks on Create a New Feature documentation
    Then user should be navigated to Add New Feature Documentation section form
    And user enters title, <sub section title>, <sub sub section> and <content>
    When user clicks on upload documentation
    Then user should be navigated to selection page
    
Examples:
    | sub section title   | sub sub section                                                            | content                                                                                                                                                                 |
     | System Requirements | To install MyApp ensure your system meets the following requirements:      | Operating System: Windows 10 or higher, macOS 10.13 or higher, Linux (various distributions) Processor: Intel Core i3 or equivalent RAM: 4 GB minimum Disk Space: 500 MB free space Internet Connection: Required for initial setup and updates |	


Scenario Outline: Verify user is able to add documentation to the new feature with blank details

	Given user is on add doc page
	When user clicks on Create a New Feature documentation
	Then user should be navigated to Add New Feature Documentation section form
	And user enters <title>,   <sub section title>,   <sub sub section>  and  <content>
	When user clicks on upload documentation
	Then upload should be disabled
	
Examples:

	| title | sub section title | sub sub section | content | 
	
	|Installation | System Requirements | |  |
	
	|Installation | | To install MyApp, ensure your system meets the following requirements: | Operating System: Windows 10 or higher, macOS 10.13 or higher, Linux (various distributions) Processor: Intel Core i3 or equivalent RAM: 4 GB minimum Disk Space: 500 MB free space Internet Connection: Required for initial setup and updates |
	
	|| System Requirements | To install MyApp, ensure your system meets the following requirements: | Operating System: Windows 10 or higher, macOS 10.13 or higher, Linux (various distributions) Processor: Intel Core i3 or equivalent RAM: 4 GB minimum Disk Space: 500 MB free space Internet Connection: Required for initial setup and updates |
	
	| |  | ||	
	
	
Scenario: Verify Add a New sub section is disabled if no option is selected
	Given user is on add doc page
	When user clicks on Add a New subsection without selecting existing feature
	Then Add a New Sub section button should be disabled
	
Scenario: Verify Add a New sub section is disabled if option is selected
	Given user is on add doc page
	When user selects <feature>
	Then Add a New Sub section button should be enabled
	
	Examples:
	
		|feature|
	
		|Getting Started|
	
Scenario Outline: Verify user is navigated to sub section form page after selecting the existing feature

	Given user is on add doc page
	And user clicks on drop down
	When user selects <feature>
	And clicks on Add a New Sub section button 
	Then user should be navigated to sub section form page

	Examples:
	
		|feature|
	
		|Getting Started|

Scenario Outline: Verify user is able to select existing sub section in existing feature

	Given user is on add doc page
	And user clicks on drop down
	When user selects <feature>
	And clicks on Add a New Sub section button 
	Then user should be navigated to sub section form page
	And user clicks on drop down
	Then user should be able to select the existing <subSection>

Examples:
	
	|feature|subSection|
	|Course|Course 1|
	
	
Scenario Outline: Verify user is able to create a sub sub section documentation 

	Given user is on add doc page
	And user clicks on drop down
	When user selects <feature>
	And clicks on Add a New Sub section button 
	Then user should be navigated to sub section form page
	And user clicks on drop down
	Then user should be able to select the existing <subSection>
	And user entered <sub sub section>  and  <content>
	When user clicks on upload subsection documentation
	Then user should be navigated to selection page

Examples:	
	|feature|subSection|sub sub section|content|
	|Course|Course 1|To install MyApp,|To install MyApp, ensure your system meets the following requirements:|Scenario: Verify user is navigated to add documentation to the new feature form
	
Scenario Outline: Verify user is able to create a with missing details sub sub section documentation 

	Given user is on add doc page
	And user clicks on drop down
	When user selects <feature>
	And clicks on Add a New Sub section button 
	Then user should be navigated to sub section form page
	And user clicks on drop down
	When user selected the existing <subSection>
	And user entered <sub sub section>  and  <content>
	When user clicks on upload subsection documentation
	Then upload button should be disabled

Examples:	
	|feature|subSection|sub sub section|content|
	|Course|Course 1||To install MyApp, ensure your system meets the following requirements:|
	|Course|Course 1|To install MyApp,||
	|Course|Course 1|           |           |
	|Course||||



	

	
