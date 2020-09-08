package com.rodrigotristany.kincarta.core.extensions

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(resource: Int) = LayoutInflater.from(this.context).inflate(resource, this, false)