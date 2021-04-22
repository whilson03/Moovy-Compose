package com.olabode.wilson.moovy.api.responses.main

import com.olabode.wilson.moovy.models.Video

/**
 *   Created by OLABODE WILSON on 7/3/20.
 */
data class VideoListResponse(
    val id: Int,
    val results: List<Video>
)
