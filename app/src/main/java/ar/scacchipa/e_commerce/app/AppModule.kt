package ar.scacchipa.e_commerce.app

import ar.scacchipa.e_commerce.repository.IItemRepository
import ar.scacchipa.e_commerce.repository.MockFruitItemRepository
import ar.scacchipa.e_commerce.viewmodel.ItemCartViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<IItemRepository> { MockFruitItemRepository() as IItemRepository }
    viewModel<ItemCartViewModel> { ItemCartViewModel() as ItemCartViewModel}
    fragment<GondolaFragment> { GondolaFragment( get() ) }
    fragment<DetailFragment> { DetailFragment() }
    fragment<CartFragment> { CartFragment() }
}