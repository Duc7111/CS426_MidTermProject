package com.example.midtermproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AsynchronousData(
    val dao: DBDao,
) : ViewModel()
{
    //User
    fun getUser(username: String, codeUser: (User) -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            codeUser(dao.getUser(username))
        }
    }

    fun newUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.newUser(user)
        }
    }

    fun updateUser(username: String, name: String, phone: String, email: String, address: String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.updateUser(username, name, phone, email, address)
        }
    }

    fun loyaltyGift(username: String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.loyaltyGift(username)
        }
    }

    //Coffee
    fun getAllCoffee(codeCoffees: (List<Coffee>) -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            codeCoffees(dao.getAllCoffee())
        }
    }
    fun getCoffee(name: String, codeCoffee: (Coffee) -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            codeCoffee(dao.getCoffee(name))
        }
    }

    //Order
    fun getOrders(username: String, vararg states: Tristate, codeOrders: (List<Order>) -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            val list: MutableList<Order> = List<Order>(0){ Order(0, "", "") }.toMutableList()
            for(state in states)
            {
                list += dao.getOrders(username, state)
            }
            codeOrders(list)
        }
    }

    fun newOrderID(getID: (Int) -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            getID(dao.newOrderID())
        }
    }

    fun updateOrder(orderID: Int, state: Tristate)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.updateOrder(orderID, state)
        }
    }

    //Transaction
    fun  buyCoffee(order: Order)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.buyCoffee(order)
        }
    }

    fun redeem(order: Order)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            dao.redeem(order)
        }
    }
}