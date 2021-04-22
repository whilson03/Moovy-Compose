package com.olabode.wilson.moovy.api.responses.main

import com.olabode.wilson.moovy.models.Review

/**
 *   Created by OLABODE WILSON on 7/3/20.
 */

class ReviewListResponse(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val total_pages: Int,
    val total_results: Int
)