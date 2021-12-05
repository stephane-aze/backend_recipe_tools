import com.example.features.food.dao.FoodDao
import com.example.features.food.dao.FoodDaoImpl
import com.example.features.food.data.FoodData
import com.example.features.food.data.FoodDataImpl
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module

val foodModule = module {
    single { FoodDaoImpl() } bind FoodDao::class
    single { FoodDataImpl(get(),get()) } bind FoodData::class
}