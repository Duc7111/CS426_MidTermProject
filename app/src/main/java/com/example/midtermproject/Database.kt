package com.example.midtermproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Transaction

@Entity
data class User(
    @PrimaryKey var username: String = "",
    var password: String = "",
    var name: String = "",
    var phone: String = "",
    var email: String = "",
    var address: String = "",

    var loyaltyPoint: Int = 0,
    var point: Int = 0,
)


@Entity
data class Coffee(
    @PrimaryKey var name: String = "",
    var drawableName: String = "",
)


@Entity(foreignKeys =
[
    ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("username"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(
        entity = Coffee::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("coffeeName"),
        onDelete = ForeignKey.CASCADE)
]
)
data class Order(
    @PrimaryKey var orderID: Int,
    var username: String,
    var coffeeName: String,
    var state: Tristate = Tristate.SMALL, // in cart, on going, done (history)

    var quantity: Int = 1,
    var shot: Boolean = false,
    var select: Boolean = false,
    var size: Tristate = Tristate.SMALL,
    var ice: Tristate = Tristate.SMALL,
)
{
    fun calCost() : Float
    {
        val x = when(size){
            Tristate.SMALL -> 1f
            Tristate.MEDIUM -> 1.5f
            Tristate.LARGE -> 1.75f}
        return 3 * x * (if(shot) 2 else 1) * quantity
    }

    override fun toString() : String
    {
        val sh = if(shot) "double" else "single"
        val se = if(select) "iced" else "hot"
        val si = if(size == Tristate.SMALL) "small" else if(size == Tristate.MEDIUM) "medium" else "large"
        val ic = if(ice == Tristate.SMALL) "less ice" else if(ice == Tristate.MEDIUM) "half ice" else "full ice"
        return sh + " | " + se + " | " + si + if(select) " | $ic" else ""
    }
}

@Dao
interface DBDao {
    //User Query
    @Query(
        "select * from User where userName = :userName"
    ) fun getUser(userName: String): User

    @Insert
    fun newUser(user: User)

    @Query(
        "update User set name = :name, phone = :phone, email = :email, address = :address where username = :username"
    ) fun updateUser(username: String, name: String, phone: String, email: String, address: String)

    @Query(
        "update User set loyaltyPoint = loyaltyPoint + 1, point = point + $pts where username = :username"
    ) fun gift(username: String)

    @Query(
        "update User set point = point - $redeemPts where username = :username"
    ) fun redeem(username: String)

    @Query(
        "update User set point = point + 100, loyaltyPoint = 0 where username = :username"
    ) fun loyaltyGift(username: String)

    //Coffee Query
    @Query(
        "select * from Coffee"
    ) fun getAllCoffee(): List<Coffee>

    @Query(
        "select * from Coffee where name = :name"
    ) fun getCoffee(name: String): Coffee

    //Order Query
    @Query(
        "select * from `order` where username = :username and state = :state"
    ) fun getOrders(username: String, state: Tristate): List<Order>

    @Query(
        "select max(orderID) + 1 from `order`"
    ) fun newOrderID() : Int

    @Insert
    fun newOrder(order: Order)

    @Query(
        "update `order` set state = :state where orderID = :orderID"
    ) fun updateOrder(orderID: Int, state: Tristate)

    //Transactions
    @Transaction
    fun  buyCoffee(order: Order)
    {
        newOrder(order)
        gift(order.username)
    }

    @Transaction
    fun redeem(order: Order)
    {
        newOrder(order)
        redeem(order.username)
    }
}

@Database(entities = [User::class, Coffee::class, Order::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun databaseDao() : DBDao
}


@Composable
fun getDrawableIdByStringName(name: String) : Int
{
    val context = LocalContext.current
    val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
    return if (resId != 0) resId else R.drawable.coffee_icon_0
}




