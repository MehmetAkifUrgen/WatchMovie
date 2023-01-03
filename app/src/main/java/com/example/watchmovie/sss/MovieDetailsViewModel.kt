package com.example.watchmovie.sss

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.pojo.MovieDetails
import com.example.watchmovie.data.PopularMovies
import com.example.watchmovie.data.Result
import com.example.watchmovie.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel(id:String):ViewModel() {


    private val _moviedetail = MutableStateFlow<List<MovieDetails>>(emptyList())
    val movieDetails = _moviedetail.asStateFlow()

    init{
        viewModelScope.launch {
            RetrofitInstance.api.getMovieDetails(id)
                .enqueue(object : Callback<MovieDetails> {
                    override fun onResponse(
                        call: Call<MovieDetails>,
                        response: Response<MovieDetails>
                    ) {
                        if (response.body() != null) {
                            _moviedetail.value=listOf(response.body()!!)
                           // Log.e("daraaa",getPopularMoviesLiveData.value.toString())

                        }
                        else Log.e("hataaaa","okeee")
                    }

                    override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                        Log.d("Home Fragment",t.message.toString())
                    }


                })
        }
    }
}