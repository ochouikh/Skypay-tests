#ifndef ACCOUNTSERVICE_HPP
#define ACCOUNTSERVICE_HPP

#include <iostream>

class AccountService
{
    private:

    public:
        AccountService();
        virtual ~AccountService();
        virtual void deposit(int amount) = 0;
        virtual void withdraw(int amount) = 0;
        virtual void printStatement() = 0;
};

#endif