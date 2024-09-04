Feature: test Login in tasking dev

  Scenario Outline: Login to tasking dev
    Given Launch QuickServe
    Then Login to QuickServe with "<fname>","<lname>","<emailId>" and "<emp_code>"
    And verify logged in user
    Then Select the environment
    
    
Examples: 
	    | fname  | lname | emailId | emp_code      |
	    | Namita | Singh | namita.singh@imerit.net | I1054 |