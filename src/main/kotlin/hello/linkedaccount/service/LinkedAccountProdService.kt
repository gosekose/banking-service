package hello.linkedaccount.service

import hello.account.repository.AccountRepository
import hello.linkedaccount.repository.LinkedAccountRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import kotlin.random.Random

@Profile(value = ["beta", "prod"])
@Service
class LinkedAccountProdService(
    linkedAccountRepository: LinkedAccountRepository,
    accountRepository: AccountRepository
) : LinkedAccountAbstractService(linkedAccountRepository, accountRepository) {

    override fun sendMessageWithAuthenticationNumberBy(phoneNumber: String) {
        // 난수 생성하기
        val randomInt = String.format("%06d", Random.nextInt(1, 1000000))
        logger?.info("profile = ['beta', 'prod'], Authentication Number = {}", randomInt)

        // message 전송하기
    }
}