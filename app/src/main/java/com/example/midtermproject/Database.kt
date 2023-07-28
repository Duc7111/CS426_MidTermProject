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
import kotlin.reflect.KClass


@Entity
data class User(
    @PrimaryKey val username: String,
    val password: String,
    val name: String,
    val phone: String,
    val email: String,
    val address: String,
)
{
}



@Entity
data class Coffee(
    @PrimaryKey val name: String,
    val drawableName: String,
    val basePrice: Float
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
    @PrimaryKey val orderID: Int,
    val username: String,
    val coffeeName: String,
    val state: Tristate, // in cart, on going, done (history)

    val quantity: Int,
    val shot: Boolean,
    val select: Boolean,
    val size: Tristate,
    val ice: Tristate,
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
interface dbDao {
    //User Query
    @Query(
        "select * from User where userName = :userName"
    ) fun getUser(userName: String): User

    @Insert
    fun newUser(user: User)

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
}

@Database(entities = [User::class, Coffee::class, Order::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun databaseDao() : dbDao
}


@Composable
fun getDrawableIdByStringName(name: String) : Int
{
    val context = LocalContext.current
    val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
    return if (resId != 0) resId else R.drawable.coffee_icon_0
}




