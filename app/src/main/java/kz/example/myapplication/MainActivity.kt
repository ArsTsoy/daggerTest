package kz.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Qualifier

class MainActivity : AppCompatActivity() {

    private val daggerMainComponent: MainComponent = DaggerMainComponent.create()


    @Inject

    lateinit var bar: Bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        daggerMainComponent.inject(this)
//        val bar: Bar = daggerMainComponent.getBar()
        bar.method()

    }
}

interface IFoo

class Foo @Inject constructor(): IFoo
class Foo2 @Inject constructor(): IFoo

interface IBar

class Bar @Inject constructor(@Named("first") private val foo: IFoo) : IBar {
    private var t = ""

    constructor(t: String, foo: IFoo): this(foo) {
        this.t = t
    }

    fun method() {
        Log.i("myBar", "t = ${t}")
        Log.i("myBar", "foo = ${foo.javaClass}")
    }
}