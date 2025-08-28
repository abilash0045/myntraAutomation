# Myntra Test Automation Framework

This project is a comprehensive test automation framework specifically designed for **Myntra** (https://www.myntra.com/), India's leading fashion e-commerce platform.

## 🎯 Project Overview

This framework has been adapted from a generic e-commerce automation framework to work specifically with Myntra's fashion e-commerce platform. It provides comprehensive test coverage for all major e-commerce functionalities including user management, product search, shopping cart, and checkout processes.

## 🏗️ Framework Architecture

### **Technology Stack**
- **Java**: Core programming language
- **Selenium WebDriver**: Web automation
- **TestNG**: Test framework
- **Maven**: Build and dependency management
- **Page Object Model**: Design pattern
- **Extent Reports**: Test reporting
- **Log4j**: Logging framework

### **Key Features**
- **Cross-browser Support**: Chrome, Firefox, IE
- **Parallel Execution**: Multi-threaded test execution
- **Data-Driven Testing**: Excel-based test data
- **Comprehensive Reporting**: Detailed test reports with screenshots
- **Modular Design**: Reusable components and methods

## 🧪 Test Coverage

### **Functional Areas**
1. **User Management**
   - Registration and login
   - Profile management
   - Account settings

2. **Product Management**
   - Product search and filtering
   - Category navigation (Men, Women, Kids)
   - Product details and reviews

3. **Shopping Experience**
   - Add to cart functionality
   - Wishlist management
   - Size selection and recommendations

4. **Checkout Process**
   - Address management
   - Payment methods
   - Order confirmation

5. **Order Management**
   - Order history
   - Order tracking
   - Returns and refunds

## 🚀 Quick Start

### **Prerequisites**
- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox browser
- Test credentials for Myntra

### **Setup**
1. Clone the repository
2. Update test credentials in `Configuration/Config.properties`
3. Create test data in `src/test/resources/TestData/MyntraTestData.xlsx`
4. Run tests using Maven commands

### **Execution**
```bash
# Run all tests
mvn clean test -DxmlFiles=testng_all.xml

# Run specific test groups
mvn clean test -DxmlFiles=testng_smoke.xml
mvn clean test -DxmlFiles=testng_sanity.xml
mvn clean test -DxmlFiles=testng_regression.xml
```

## 📊 Reports and Logs

### **Test Reports**
- **Location**: `test-output/ExtentReport/MyReport.html`
- **Features**: Detailed test results, screenshots, execution time

### **Logs**
- **Location**: `Logs/log4j.log`
- **Level**: INFO, DEBUG, ERROR

## 📁 Project Structure

```
MyStoreProject/
├── Configuration/
│   └── Config.properties          # Test configuration
├── src/
│   ├── main/java/com/mystore/
│   │   ├── actiondriver/          # Action methods
│   │   ├── actioninterface/       # Action interfaces
│   │   ├── base/                  # Base classes
│   │   ├── dataprovider/          # Test data providers
│   │   ├── pageobjects/           # Page object classes
│   │   └── utility/               # Utility classes
│   └── test/
│       ├── java/com/mystore/testcases/  # Test classes
│       └── resources/TestData/    # Test data files
├── test-output/                   # Test reports and logs
├── testng_*.xml                   # TestNG configuration files
└── pom.xml                        # Maven configuration
```

## 🔧 Configuration

### **Environment Setup**
- **URL**: https://www.myntra.com/
- **Browser**: Chrome (default)
- **Implicit Wait**: 10 seconds
- **Page Load Timeout**: 40 seconds

### **Test Data**
The framework uses Excel files for test data management:
- Product information
- User credentials
- Test scenarios

## 📈 Continuous Integration

The framework is designed to work with CI/CD pipelines:
- **Jenkins**: Automated test execution
- **Git**: Version control
- **Maven**: Build automation

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📞 Support

For questions or issues:
1. Check the documentation in `README_Myntra.md`
2. Review test logs and reports
3. Verify configuration settings
4. Ensure browser compatibility

## 📝 License

This project is for educational and testing purposes.

---

**Framework Version**: 2.0 (Myntra Adaptation)  
**Target Application**: Myntra E-commerce Platform  
**Last Updated**: December 2024
