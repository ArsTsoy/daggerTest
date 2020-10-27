package kz.example.myapplication

import dagger.Component
import dagger.Provides

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 10/27/20
 */

@Component(
        modules = [MainModule::class]
)
interface MainComponent {


//    fun getFoo(): Foo
    fun getBar(): Bar

    fun inject(mainActivity: MainActivity)

}