#include "Account.hpp"
#include <iostream>
#include <string>
#include <limits>

int main(int argc, char const *argv[])
{
    Account client;
    std::string action;
    int amount;
    
    std::cout << "Banking System - Commands: deposit, withdraw, statement, exit" << std::endl;
    
    while (true) {
        std::cout << "\nEnter command: ";
        std::cin >> action;
        
        if (std::cin.fail()) {
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            std::cout << "Invalid input. Please try again." << std::endl;
            continue;
        }
        
        if (action == "exit") {
            break;
        } else if (action == "deposit") {
            std::cout << "Enter amount: ";
            if (!(std::cin >> amount)) {
                std::cin.clear();
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
                std::cout << "Invalid amount. Please enter a numeric value." << std::endl;
                continue;
            }
            if (amount <= 0) {
                std::cout << "Amount must be positive." << std::endl;
                continue;
            }
            client.deposit(amount);
        } else if (action == "withdraw") {
            std::cout << "Enter amount: ";
            if (!(std::cin >> amount)) {
                std::cin.clear();
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
                std::cout << "Invalid amount. Please enter a numeric value." << std::endl;
                continue;
            }
            if (amount <= 0) {
                std::cout << "Amount must be positive." << std::endl;
                continue;
            }
            client.withdraw(amount);
        } else if (action == "statement") {
            client.printStatement();
        } else {
            std::cout << "Invalid command. Use: deposit, withdraw, statement, or exit" << std::endl;
        }
    }
    
    return 0;
}
