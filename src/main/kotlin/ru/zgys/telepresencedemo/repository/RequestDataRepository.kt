package ru.zgys.telepresencedemo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.zgys.telepresencedemo.model.RequestData

interface RequestDataRepository: JpaRepository<RequestData, Int> {
}