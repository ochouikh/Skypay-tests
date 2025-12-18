#ifndef ACCOUNT_HPP
#define ACCOUNT_HPP

#include "AccountService.hpp"
#include <vector>
#include <ctime>
#include <iostream>
#include <iomanip>

class Account: public AccountService
{
private:
    std::vector<std::pair<int, int>> transactions;
    std::vector<struct tm> dates;
    int total;

public:
    Account();
    ~Account();
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
};

#endif