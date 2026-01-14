AI Usage Log – DemoQA Practice Form Automation
This document records how AI tools were used in this project, as required by team guidelines.
1. Tool Used
   ChatGPT (OpenAI)
2. Original Prompt Given to AI
   Build a Selenium + TestNG automation framework for the DemoQA Practice Form. Use Page Object Model, include positive, negative and data-driven test cases. Use XPath locators and follow best practices.
3. Initial AI-Generated Output (Sample)
   @FindBy(id="firstName") WebElement firstName;
4. Issues Found During Review
   IDs were used instead of XPath. Gender handling limited. No separation of concerns.Validation logic was written directly in test classes using WebDriver.
5. Refactored Version Used
   @FindBy(xpath="//input[@id='firstName']") WebElement firstName;
   @FindBy(xpath="//input[@id='userNumber']") WebElement phone;
6. Improvements
   Stable XPath, better structure, multiple gender support, encapsulation.
   Validation logic moved from test class into Page Object using getPhoneFieldBorderColor()
7. Final Responsibility
   All AI-generated code was reviewed, modified, tested, and approved by the developer.