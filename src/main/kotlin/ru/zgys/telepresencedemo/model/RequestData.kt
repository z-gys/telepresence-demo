package ru.zgys.telepresencedemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "request_data")
data class RequestData(
    val ip: String = "unknown",
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_data_id_seq")
    @SequenceGenerator(name = "request_data_id_seq", sequenceName = "request_data_id_seq", allocationSize = 1)
    val id: Int? = null
)