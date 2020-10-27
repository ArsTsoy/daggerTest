package kz.example.myapplication

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 10/27/20
 */

@Module
abstract class MainModule {

    @Binds
    @Named("first")
    abstract fun bindsIFoo(foo: Foo): IFoo


    @Binds
    abstract fun bindsIFoo2(foo: Foo2): IFoo

    companion object {
        @Provides
        fun providesBar(iFoo: IFoo): Bar {
            return Bar("fasf", iFoo)
        }

        @Provides
        @Named("first")
        fun providesBar2(iFoo: IFoo): Bar {
            return Bar("first", iFoo)
        }
    }

}
