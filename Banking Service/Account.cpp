#include "Account.hpp"

Account::Account()
{
    this->total = 0;
}

Account::~Account()
{
}

void Account::deposit(int amount) {
    time_t timestamp = time(NULL);
    this->dates.push_back(*localtime(&timestamp));
    this->total += amount;
    this->transactions.push_back(std::make_pair(amount, this->total));
    std::cout << "Deposited: " << amount << std::endl;
}

void Account::withdraw(int amount) {
    if (this->total - amount >= 0) {
        time_t timestamp = time(NULL);
        this->dates.push_back(*localtime(&timestamp));
        this->total -= amount;
        this->transactions.push_back(std::make_pair(amount * -1, this->total));
        std::cout << "Withdrawal attempted: " << amount << std::endl;
        return ;
    }
    std::cout << "Your account doesn't have this amount." << std::endl;
}

void Account::printStatement() {
    std::cout << "+-----------+----------+-----------+" << std::endl;
    std::cout << "| Date      | Amount   | Balance   |" << std::endl;
    std::cout << "+-----------+----------+-----------+" << std::endl;
    
    for (int i = this->transactions.size() - 1; i >= 0; i--)
    {
        char output[50];
        strftime(output, 50, "%m/%d/%y", &this->dates[i]);
        
        std::cout << "| " << std::left << std::setw(10) << output 
                  << "| " << std::right << std::setw(9) << this->transactions[i].first 
                  << "| " << std::right << std::setw(10) << this->transactions[i].second 
                  << "|" << std::endl;
    }
    
    std::cout << "+-----------+----------+-----------+" << std::endl;
}
