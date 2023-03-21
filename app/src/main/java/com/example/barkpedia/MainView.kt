package com.example.barkpedia

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.barkpedia.data.DogsItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

sealed class DataState{
    class Success(val data: MutableList<DogsItem>):DataState()
    class Failure(val message: String):DataState()
    object Loading:DataState()
    object Empty:DataState()
}

class MainView: ViewModel() {
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init{
        fetchDataFromFireBase()
    }
    private fun fetchDataFromFireBase() {
        val tempList = mutableListOf<DogsItem>()
        response.value = DataState.Loading

        FirebaseDatabase
            .getInstance()
            .getReference("/")
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(EachData in snapshot.children){
                        val eachDog = EachData.getValue(DogsItem::class.java)
                        if (eachDog != null){
                            tempList.add(eachDog)
                        }
                    }
                    response.value = DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }

            })
    }

}