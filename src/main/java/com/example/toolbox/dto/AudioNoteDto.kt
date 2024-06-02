package com.example.toolbox.dto

import java.io.Serializable
import java.util.*
import javax.sound.sampled.AudioInputStream

/**
 * DTO for {@link com.example.toolbox.model.AudioNote}
 */
data class AudioNoteDto(val id: Long? = null, val date: Date? = null, val content: AudioInputStream? = null) :
    Serializable