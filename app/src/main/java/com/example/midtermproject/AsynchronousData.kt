package com.example.midtermproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class AsynchronousData(
    val dao: DBDao,
) : ViewModel()
{
    //User
    fun getUser(username: String, codeUser: (User) -> Unit)
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            dao.getUser(username).collect()
            {
                if (it != null) {
                    codeUser(it)
                }
                else codeUser(User())
            }
        }
    }

    fun newUser(user: User)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.newUser(user)
        }
    }

    fun updateUser(username: String, name: String, phone: String, email: String, address: String)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.updateUser(username, name, phone, email, address)
        }
    }

    fun loyaltyGift(username: String)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.loyaltyGift(username)
        }
    }

    //Coffee
    fun getAllCoffee(codeCoffees: (List<Coffee>) -> Unit)
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            dao.getAllCoffee().collect()
            {
                codeCoffees(it)
            }
        }
    }
    fun getCoffee(name: String, codeCoffee: (Coffee) -> Unit)
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            dao.getCoffee(name).collect()
            {
                if(it != null) codeCoffee(it)
                else codeCoffee(Coffee())
            }
        }
    }

    fun initCoffee()
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.initCoffee()
        }
    }

    //Order
    fun getOrders(username: String, vararg states: Tristate, codeOrders: (List<Order>) -> Unit)
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            val list: MutableList<Order> = emptyList<Order>().toMutableList()
            for(state in states)
            {
                dao.getOrders(username, state).collect()
                {
                    list += it
                }
            }
            codeOrders(list)
        }
    }

    fun newOrderID(getID: (Int) -> Unit)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            getID(dao.newOrderID())
        }
    }

    fun updateOrder(orderID: Int, state: Tristate)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.updateOrder(orderID, state)
        }
    }

    //Transaction
    fun  buyCoffee(order: Order)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.buyCoffee(order)
        }
    }

    fun redeem(order: Order)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.redeem(order)
        }
    }

    fun insertOrder(order: Order)
    {
        viewModelScope.launch(Dispatchers.Default)
        {
            dao.insertOrder(order)
        }
    }
}