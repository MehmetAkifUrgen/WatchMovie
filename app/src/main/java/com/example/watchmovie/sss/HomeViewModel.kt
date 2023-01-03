package com.example.watchmovie.sss

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchmovie.data.PopularMovies
import com.example.watchmovie.data.Result
import com.example.watchmovie.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {

    private var getPopularMoviesLiveData = MutableLiveData<List<Result>>()
    private val _noteList = MutableStateFlow<List<com.example.watchmovie.data.Result>>(emptyList())
    val noteList = _noteList.asStateFlow()

   init{
        viewModelScope.launch {
            RetrofitInstance.api.getPopularMovies()
                .enqueue(object : Callback<PopularMovies> {
                    override fun onResponse(
                        call: Call<PopularMovies>,
                        response: Response<PopularMovies>
                    ) {
                        if (response.body() != null) {
                            _noteList.value=response.body()!!.results
                            Log.e("daraaa",getPopularMoviesLiveData.value.toString())

                        }
                        else Log.e("hataaaa","okeee")
                    }

                    override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                        Log.d("Home Fragment",t.message.toString())
                    }
                })
        }
    }

    fun observePopularMovies(): LiveData<List<Result>> {
        return getPopularMoviesLiveData
    }

}