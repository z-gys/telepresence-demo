package ru.zgys.telepresencedemo.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.zgys.telepresencedemo.model.RequestData
import ru.zgys.telepresencedemo.repository.RequestDataRepository
import java.util.concurrent.ThreadLocalRandom

@Service
class UserService(
    @Value("\${application.fail-percent}") private val failPercent: Int,
    private val repository: RequestDataRepository
) {
    fun collectHost(userHost: String) {
        val chance = ThreadLocalRandom.current().nextInt(100)
        if (chance < failPercent) {
            throw RuntimeException("Bad luck :(")
        }
        val requestData = RequestData(userHost)
        repository.save(requestData)
    }
}
