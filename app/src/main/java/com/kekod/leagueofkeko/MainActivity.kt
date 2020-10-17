package com.kekod.leagueofkeko

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Player.EventListener {

    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClickControl()
        initilizeExoPlayer()


    }

    private fun onClickControl() {
        btnLogin.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
        player.playWhenReady = false
    }

    override fun onStart() {
        super.onStart()
        player.playWhenReady = true
    }

    private fun initilizeExoPlayer() {
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player
        val uri = Uri.parse(getString(R.string.media_url_mp3))
        player.addListener(this)

        //val uri2 = Uri.parse(getString(R.string.media_url2_mp3))
        //val firstVideo = MediaItem.fromUri(uri)
        //val secondVideo = MediaItem.fromUri(uri2)
        //player.addMediaItem(firstVideo)
        //player.addMediaItem(secondVideo)

        val mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem) // henuz oynamiyor
        player.prepare() //videoyu benim icin hazirla
        player.play() // baslat

    }

    override fun onPlayerStateChanged(
        playWhenReady: Boolean,
        playbackState: Int
    ) { //Reklam alanlari icin onemli

        when (playbackState) {
            ExoPlayer.STATE_IDLE -> {
                progressBar.visibility = View.VISIBLE
            }                                               //video aninda ilerletme durumu
            ExoPlayer.STATE_BUFFERING -> {
                progressBar.visibility = View.VISIBLE
            }
            ExoPlayer.STATE_READY -> {
                progressBar.visibility = View.GONE
            }
            ExoPlayer.STATE_ENDED -> {
                progressBar.visibility = View.GONE
            }
        }
    }
}


/*private fun initializePlayer() {
    player = SimpleExoPlayer.Builder(this).build()
    playerView.player = player
    player.addListener(listener)
    val uri = Uri.parse(getString(R.string.media_url_mp3))
    val uri2 = Uri.parse(getString(R.string.media_url2_mp3))
    //val mediaItem = MediaItem.fromUri(uri)
    val firstMediaItem = MediaItem.fromUri(uri)
    val secondMediaItem = MediaItem.fromUri(uri2)
    player.addMediaItem(firstMediaItem)
    player.addMediaItem(secondMediaItem)
    //player.setMediaItem(mediaItem)
    player.prepare()
    player.play()
}*/
/*private fun listenerExo() {
    listener = object : Player.EventListener {
        override fun onPlayerStateChanged(
            playWhenReady: Boolean,
            playbackState: Int
        ) {
            when (playbackState) {
                ExoPlayer.STATE_IDLE -> {
                    progressBar.visibility = View.VISIBLE
                } //bos birakilinca??
                ExoPlayer.STATE_BUFFERING -> {
                    progressBar.visibility = View.VISIBLE
                } // yuklenirken
                ExoPlayer.STATE_READY -> {
                    progressBar.visibility = View.GONE
                } //hazir hale geldiginde
                ExoPlayer.STATE_ENDED -> {
                    progressBar.visibility = View.GONE
                } //bittiginde
                else -> {
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}*/
/*    override fun onStop() {
        super.onStop()
        player.playWhenReady = false
        player.removeListener(listener)
    }


    override fun onStart() {
        super.onStart()
        initializePlayer()
        player.playWhenReady = true
        progressBar.visibility = View.GONE

    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player
        player.addListener(listener)
        val uri = Uri.parse(getString(R.string.media_url_mp3))
        val uri2 = Uri.parse(getString(R.string.media_url2_mp3))
        //val mediaItem = MediaItem.fromUri(uri)
        val firstMediaItem = MediaItem.fromUri(uri)
        val secondMediaItem = MediaItem.fromUri(uri2)
        player.addMediaItem(firstMediaItem)
        player.addMediaItem(secondMediaItem)
        //tekrar baslamaz
        //player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
//        val mediaSource = buildMediaSource(uri)
//        if (mediaSource != null) {
//            player.prepare(mediaSource, false, false)
//        }
//        mediaSource?.let { player.prepare(it, false, false) }
        //player.playWhenReady = true


    }*/
/*    private fun buildMediaSource(uri: Uri): MediaSource? {
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(this, "exoplayer-codelab")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }

    private fun buildHlsMediaSource(uri: Uri): MediaSource {
        val dataSourceFactory: DataSource.Factory =
            DefaultHttpDataSourceFactory(
                Util.getUserAgent(
                    this,
                    getString(R.string.app_name)
                )
            )
        return HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }*/