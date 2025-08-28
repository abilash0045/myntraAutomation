# Myntra Test Automation Framework

This project has been modified from the original e-commerce automation framework to work specifically with **Myntra** (https://www.myntra.com/), India's leading fashion e-commerce platform.

## 🎯 Overview

The framework has been completely adapted to test Myntra's fashion e-commerce functionality, including:
- User registration and login
- Product search and filtering
- Category navigation (Men, Women, Kids)
- Add to cart and wishlist functionality
- Complete checkout process
- Order management

## 🏗️ Framework Architecture

### **Page Object Model (POM)**
- **Base Classes**: WebDriver setup, configuration management
- **Page Objects**: 12 page classes covering the entire Myntra e-commerce flow
- **Action Driver**: Reusable action methods with enhanced functionality
- **Test Cases**: 9 test classes including Myntra-specific features
- **Data Providers**: Excel-based test data management
- **Reporting**: Extent Reports and Log4j logging

### **Key Components Modified**

#### 1. **Configuration**
- **URL**: Updated to `https://www.myntra.com/`
- **Test Credentials**: Updated for Myntra test environment
- **Browser Support**: Chrome, Firefox, IE

#### 2. **Page Objects Updated**

##### **IndexPage.java**
- Updated locators for Myntra's homepage elements
- Added cart and wishlist navigation
- Modified search functionality for Myntra's search bar

##### **LoginPage.java**
- Updated for Myntra's login modal
- Added support for "Login with Password" option
- Modified registration flow

##### **HomePage.java**
- Added category navigation (Men, Women, Kids)
- Updated profile and cart access
- Enhanced wishlist and order history validation

##### **SearchResultPage.java**
- Updated for Myntra's product listing page
- Added filter and sort functionality
- Enhanced product selection

##### **AddToCartPage.java**
- Updated for Myntra's product detail page
- Added size selection functionality
- Enhanced add to cart and wishlist features
- Added product price and title extraction

##### **OrderPage.java**
- Updated for Myntra's shopping bag
- Added quantity management
- Enhanced price calculations
- Added item removal functionality

#### 3. **New Test Cases**

##### **MyntraSpecificTest.java**
- Category navigation tests (Men, Women, Kids)
- Search with filters functionality
- Wishlist and cart functionality
- Myntra-specific feature validation

## 🧪 Test Scenarios

### **Smoke Tests**
1. **Logo Validation**: Verify Myntra logo is displayed
2. **Page Title**: Validate correct page title
3. **Category Navigation**: Test Men, Women, Kids category links
4. **Search Functionality**: Basic product search

### **Sanity Tests**
1. **User Login**: Test login functionality
2. **Product Search**: Search with filters and sorting
3. **Wishlist**: Add/remove items from wishlist
4. **Cart Management**: Add items to cart and manage quantities

### **Regression Tests**
1. **End-to-End Flow**: Complete purchase journey
2. **Account Creation**: New user registration
3. **Order Management**: Order history and details
4. **Payment Flow**: Complete checkout process

## 📊 Test Data Management

### **Excel Structure**
The framework uses `MyntraTestData.xlsx` with the following sheets:

1. **ProductDetails**
   - ProductName: Fashion items (shirts, dresses, shoes, etc.)
   - Size: Available sizes (S, M, L, XL, etc.)

2. **SearchProduct**
   - ProductName: Search terms
   - Category: Product categories

3. **Credentials**
   - Username: Test user email
   - Password: Test user password

4. **AccountCreationData**
   - Complete user registration data

## 🚀 Running Tests

### **Prerequisites**
- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox browser
- Test credentials for Myntra

### **Execution Commands**

```bash
# Run all tests
mvn clean test -DxmlFiles=testng_all.xml

# Run specific test groups
mvn clean test -DxmlFiles=testng_smoke.xml
mvn clean test -DxmlFiles=testng_sanity.xml
mvn clean test -DxmlFiles=testng_regression.xml

# Run with specific browser
mvn clean test -DxmlFiles=testng_all.xml -Dbrowser=Chrome
```

### **Test Groups**
- **Smoke**: Basic functionality tests
- **Sanity**: Core feature tests
- **Regression**: Complete workflow tests

## 📈 Reporting

### **Extent Reports**
- Location: `test-output/ExtentReport/MyReport.html`
- Features: Detailed test results with screenshots
- Categories: Passed, Failed, Skipped tests

### **Log4j Logging**
- Location: `Logs/log4j.log`
- Level: INFO, DEBUG, ERROR
- Format: Timestamp, Level, Message

## 🔧 Configuration

### **Config.properties**
```properties
url=https://www.myntra.com/
username=test@example.com
password=Test@123
browser=Chrome
implicitWait=10
pageLoadTimeOut=40
```

### **TestNG XML Files**
- `testng_all.xml`: All test cases
- `testng_smoke.xml`: Smoke tests only
- `testng_sanity.xml`: Sanity tests only
- `testng_regression.xml`: Regression tests only

## 🛠️ Framework Enhancements

### **New Features Added**
1. **Enhanced Action Class**: Added `getText()` method for element text extraction
2. **Myntra-Specific Locators**: Updated all XPath selectors for Myntra's UI
3. **Category Navigation**: Added support for fashion categories
4. **Wishlist Integration**: Complete wishlist functionality
5. **Size Selection**: Dynamic size selection for fashion items

### **Improved Error Handling**
- Better exception handling for dynamic elements
- Enhanced wait strategies for Myntra's responsive design
- Improved screenshot capture for failed tests

## 📝 Notes

### **Important Considerations**
1. **Dynamic Elements**: Myntra uses dynamic loading, so explicit waits are implemented
2. **Responsive Design**: Framework supports both desktop and mobile views
3. **Test Data**: Use realistic fashion product names and sizes
4. **Credentials**: Ensure test credentials are valid and active

### **Known Limitations**
1. **Captcha**: Some flows may encounter captcha (not handled in current version)
2. **OTP**: Phone verification may require manual intervention
3. **Payment**: Test payment methods may be required for complete checkout

## 🤝 Contributing

To contribute to this framework:
1. Follow the existing code structure
2. Add appropriate comments and documentation
3. Update test data as needed
4. Ensure all tests pass before committing

## 📞 Support

For questions or issues:
1. Check the existing documentation
2. Review test logs and reports
3. Verify test data and credentials
4. Ensure browser compatibility

---

**Framework Version**: 2.0 (Myntra Adaptation)  
**Last Updated**: December 2024  
**Target Application**: Myntra E-commerce Platform
