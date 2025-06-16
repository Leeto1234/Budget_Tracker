# 💰 BudgetSmart - Personal Finance Management App

## 📱 Overview

BudgetSmart is a modern, feature-rich personal finance management application for Android that helps users track their income, expenses,
and achieve their financial goals. With a vibrant, gamified interface and comprehensive budgeting tools,
BudgetSmart makes financial management engaging and intuitive.

## ✨ Features

### 🏠 **Dashboard & Overview**
- **Real-time Balance Tracking**: View your total balance, income, and expenses at a glance
- **Recent Transactions**: Quick access to your latest financial activities
- **Vibrant UI**: Modern gradient designs with smooth animations
- **Quick Actions**: Fast access to add income/expenses and view statistics

### 💸 **Income & Expense Management**
- **Easy Transaction Entry**: Intuitive dialogs for adding income and expenses
- **Category Organization**: Organize transactions by customizable categories
- **Date Tracking**: Automatic date recording with manual override options
- **Notes & Descriptions**: Add detailed descriptions to your transactions

### 📊 **Budget Planning**
- **Budget Setting**: Set monthly, weekly, or custom period budgets
- **Category Budgets**: Individual budget limits for different spending categories
- **Progress Tracking**: Visual progress indicators for budget adherence
- **Overspending Alerts**: Smart notifications when approaching budget limits

### 📈 **Statistics & Analytics**
- **Spending Insights**: Detailed breakdowns of your spending patterns
- **Visual Charts**: Beautiful charts and graphs for data visualization
- **Trend Analysis**: Track your financial progress over time
- **Export Options**: Generate reports for external analysis

### 🎮 **Gamification System**
- **User Levels**: Progress through levels based on financial activities
- **Achievement Badges**: Unlock badges for reaching financial milestones
- **XP System**: Earn experience points for consistent budgeting
- **Streak Tracking**: Maintain daily/weekly financial tracking streaks

### 👤 **User Management**
- **Secure Authentication**: User registration and login system
- **Profile Management**: Personalized user profiles
- **Session Management**: Secure session handling
- **Multi-user Support**: Support for multiple user accounts

## 🎨 Design Highlights

### **Modern UI/UX**
- **Vibrant Color Schemes**: Eye-catching gradients and color combinations
- **Material Design 3**: Latest Material Design principles
- **Smooth Animations**: Engaging transitions and micro-interactions
- **Responsive Layout**: Optimized for various screen sizes

### **Visual Elements**
- **Gradient Backgrounds**: Dynamic gradient designs throughout the app
- **Floating Elements**: Decorative shapes and visual enhancements
- **Card-based Design**: Clean, organized information presentation
- **Custom Icons**: Unique iconography for better user experience

## 🛠️ Technologies Used

### **Core Technologies**
- **Language**: Kotlin
- **Platform**: Android (API 21+)
- **Architecture**: MVVM Pattern
- **Database**: SQLite with custom DatabaseHelper
- **UI Framework**: Android Views with Material Components

### **Key Libraries & Components**
- **Material Components**: Modern UI components
- **RecyclerView**: Efficient list displays
- **CardView**: Card-based layouts
- **Navigation Component**: Fragment navigation
- **ViewBinding**: Type-safe view references

### **Design Resources**
- **Vector Drawables**: Scalable icons and graphics
- **Gradient Drawables**: Custom gradient backgrounds
- **Shape Drawables**: Custom shapes and decorations
- **Animation Lists**: Animated visual elements

## 🗄️ Database Schema

### **Users Table**
\`\`\`sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
\`\`\`

### **Expenses Table**
\`\`\`sql
CREATE TABLE expenses (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    amount REAL NOT NULL,
    description TEXT,
    category TEXT,
    date TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
\`\`\`

### **Income Table**
\`\`\`sql
CREATE TABLE income (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    amount REAL NOT NULL,
    source TEXT NOT NULL,
    note TEXT,
    date TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
\`\`\`

### **Categories Table**
\`\`\`sql
CREATE TABLE categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    name TEXT NOT NULL,
    color TEXT,
    icon TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
\`\`\`

### **Budgets Table**
\`\`\`sql
CREATE TABLE budgets (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    category_id INTEGER,
    amount REAL NOT NULL,
    period TEXT NOT NULL,
    start_date TEXT NOT NULL,
    end_date TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);
\`\`\`

## 🚀 Installation & Setup

### **Prerequisites**
- Android Studio Arctic Fox or later
- Android SDK API 21 or higher
- Kotlin 1.5.0 or later

### **Installation Steps**

1. **Clone the Repository**
   \`\`\`bash
   git clone https://github.com/yourusername/budgetsmart.git
   cd budgetsmart
   \`\`\`

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Sync Project**
   - Android Studio will automatically sync the project
   - Wait for Gradle sync to complete

4. **Run the Application**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`

### **Build Variants**
- **Debug**: Development build with debugging enabled
- **Release**: Production build with optimizations

## 🎯 Usage Guide

### **Getting Started**
1. **Registration**: Create a new account with email and password
2. **Login**: Sign in with your credentials
3. **Dashboard**: View your financial overview on the home screen
4. **Add Transactions**: Use the income/expense buttons to record transactions
5. **Set Budgets**: Navigate to the budget section to set spending limits
6. **Track Progress**: Monitor your financial goals in the statistics section
7. **Earn Achievements**: Complete financial milestones to unlock badges

### **Key Features Usage**

#### **Adding Income**
1. Tap the "Income" button on the dashboard
2. Enter the amount and source
3. Add optional notes
4. Save the transaction

#### **Recording Expenses**
1. Tap the "Expense" button on the dashboard
2. Enter amount and description
3. Select a category
4. Choose the date
5. Save the expense

#### **Setting Budgets**
1. Navigate to the Budget section
2. Tap "Set Budget"
3. Enter the budget amount
4. Select the time period
5. Choose categories (optional)
6. Save the budget



### **Areas for Contribution**
- 🐛 Bug fixes
- ✨ New features
- 🎨 UI/UX improvements
- 📚 Documentation updates
- 🧪 Test coverage
- 🌐 Localization

## 🐛 Known Issues

- [ ] Export functionality needs implementation
- [ ]  sync feature in development
- [ ] Some animations may lag on older devices
- [ ] Category icons need expansion


### **Technical Improvements**
- **Room Database**: Migration to Room for better ORM
- **Jetpack Compose**: Modern UI toolkit adoption
- **Coroutines**: Improved asynchronous operations
- **Repository Pattern**: Better data layer architecture
- **Unit Testing**: Comprehensive test coverage
- **CI/CD Pipeline**: Automated testing and deployment

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

\`\`\`
MIT License

Copyright (c) 2024 BudgetSmart

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
\`\`\`

## 👥 Authors & Acknowledgments

### **Development Team**
- **Lead Developer**: [Your Name]
- **UI/UX Designer**: [Designer Name]
- **Contributors**: See [CONTRIBUTORS.md](CONTRIBUTORS.md)

### **Acknowledgments**
- Material Design team for design guidelines
- Android development community for best practices
- Open source libraries and their maintainers
- Beta testers and early adopters

## 📞 Support & Contact

### **Getting Help**
- 📧 **Email**: support@budgetsmart.app
- 🐛 **Bug Reports**: [GitHub Issues](https://github.com/yourusername/budgetsmart/issues)
- 💬 **Discussions**: [GitHub Discussions](https://github.com/yourusername/budgetsmart/discussions)
- 📖 **Documentation**: [Wiki](https://github.com/ST10392005/OPSC6311_PART3-Budget-Master/new/master?fil)

<div align="center">
  <p>Made with ❤️ for better financial management</p>
  <p>⭐ Star this repository if you found it helpful!</p>
</div>
