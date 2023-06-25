package hello.linkedaccount.service

import hello.account.repository.AccountRepository
import hello.linkedaccount.repository.LinkedAccountRepository
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Primary
@Profile(value = ["local", "alpha"])
@Service
class LinkedAccountAlphaService(
    linkedAccountRepository: LinkedAccountRepository,
    accountRepository: AccountRepository
) : LinkedAccountAbstractService(linkedAccountRepository, accountRepository) {

    val authenticationNumber = "123456"

    override fun sendMessageWithAuthenticationNumberBy(phoneNumber: String) {
        // redis에 공통된 숫자 저장 -> 메세지 전송 X
        logger?.info("profile = ['local', 'alpha'], Authentication Number = {}", authenticationNumber)
    }
}