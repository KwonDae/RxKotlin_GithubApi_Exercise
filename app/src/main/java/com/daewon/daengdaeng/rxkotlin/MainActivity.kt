package com.daewon.daengdaeng.rxkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GithubClient.getAPi().getRepos("KwonDae")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ items ->
                items.forEach { println(it) }
            }, { e->
                println(e.toString())
            })


//        val disposable: Disposable = Observable.just(1, temp(number=1), 3, 4)
//            .map {
//                if(it==3) throw IllegalStateException() else it
//            }
//            .subscribe(
//                { println("$it") }, // onNext: Consumer
//                { println("onError") }, // onError: Consumer
//                { next() }, // onComplete: Consumer
//                { println("onSubscribe") } // onSubscribe: Consumer
//            )

        Single.just(temp(number=1))
            .subscribeOn(Schedulers.io())
            .subscribe({
                println("success")
            }, {
                println("Error")
            })



//        try {
//            val single = Single.just(temp(number= 1))
//                .subscribe(
//                    {
//                        next();
//                    }, {
//                        println("error!!")
//                    }
//                )
//
//        }catch (e : Exception) {
//            e.printStackTrace()
//        }

    }

    fun temp(number : Int) {
        if(number == 1)
            println("temp")
        else
            throw IllegalStateException()
    }

    fun next() {
        println("next function")
    }
}