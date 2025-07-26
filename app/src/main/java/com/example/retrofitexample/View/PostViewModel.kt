package com.example.retrofitexample.View

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.ApiService.RetrofitInstance
import com.example.retrofitexample.Model.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel()
{
    private val _post= mutableStateOf<List<Post>>(emptyList())
    val post: State<List<Post>> = _post

    init {
        fetchPost()
    }

    fun fetchPost(){
        viewModelScope.launch {
            try {
              _post.value = RetrofitInstance.api.getPost()
            }
            catch (e: Exception){
                Log.d("Apierror","Exception$e")
            }
        }
    }
}