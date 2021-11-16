package com.daewon.daengdaeng.rxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.core.Single
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        GithubClient.getAPi().getRepos("KwonDae")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ items ->
//                items.forEach { println(it) }
//            }, { e->
//                println(e.toString())
//            })

        val observer = object : Observer<Int> {
            override fun onComplete() {
                // Observable이 완료된 경우
            }
            override fun onSubscribe(d: Disposable) {
                // Observable이 데이터 전달할 준비가 되었을 때.
                // 작업 취소를 위한 Disposable에 대한 레퍼런스를 여기서 받음
            }
            override fun onNext(t: Int) {
                // Observable이 데이터를 전달할 때 호출
            }
            override fun onError(e: Throwable) {
                // Observable이 에러를 전달할 때 호출. Error시 Complete없이 종료다.
            }
        }
        Observable.just(1, 2, 3, 4).subscribe(observer)

//        val disposable = Observable.just(1, temp(), 3, 4)
//            .subscribe(
//                { println("$it") }, // onNext: Consumer
//                { println("onError") }, // onError: Consumer
//                { next() }, // onComplete: Consumer
//                { println("onSubscribe") } // onSubscribe: Consumer
//            )

        try {
            val single = Single.just(temp(number= 222))
                .subscribe(
                    {
                        next();
                    }, {
                        println("error!!")
                    }
                )

        }catch (e : Exception) {
            e.printStackTrace()
        }

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