package com.example.spotifyclone.data.remote

import com.example.spotifyclone.data.entities.Songs
import com.google.firebase.firestore.FirebaseFirestore
import com.example.spotifyclone.other.Constants
import com.example.spotifyclone.other.Constants.SONG_COLLECTION
import com.google.android.gms.tasks.Tasks.await
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs():List<Songs>{
        return try {
            songCollection.get().await().toObjects(Songs::class.java)
        }catch (e:java.lang.Exception){
            emptyList()
        }
    }


}
