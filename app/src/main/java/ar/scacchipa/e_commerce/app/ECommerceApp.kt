package ar.scacchipa.e_commerce.app

import android.app.Application
import ar.scacchipa.e_commerce.repository.IItemRepository
import ar.scacchipa.e_commerce.repository.MockFruitItemRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<IItemRepository> { MockFruitItemRepository() as IItemRepository }
    fragment<GondolaFragment> { GondolaFragment( get() ) }
    fragment<DetailFragment> { DetailFragment() }
    fragment<CartFragment> { CartFragment() }
}

class ECommerceApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            fragmentFactory()
            androidContext(this@ECommerceApp)
            modules(appModule)
        }
    }
}