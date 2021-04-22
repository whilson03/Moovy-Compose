package com.olabode.wilson.moovy.api.responses.main

import com.olabode.wilson.moovy.models.Keyword

/**
 *   Created by OLABODE WILSON on 7/3/20.
 */
data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
)