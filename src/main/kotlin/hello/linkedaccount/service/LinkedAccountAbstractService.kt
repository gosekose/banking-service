package hello.linkedaccount.service

import hello.account.repository.AccountRepository
import hello.linkedaccount.domain.LinkedAccount
import hello.linkedaccount.repository.LinkedAccountRepository
import hello.linkedaccount.service.dto.LinkedAccountSaveDto
import hello.utils.findByIdOrThrow
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class LinkedAccountAbstractService(
    private val linkedAccountRepository: LinkedAccountRepository,
    private val accountRepository: AccountRepository,
) : LinkedAccountService {

    protected val logger: Logger? = LoggerFactory.getLogger(this::class.java)

    override fun saveLinkedAccount(dto: LinkedAccountSaveDto) {
        val account = accountRepository.findByIdOrThrow(dto.accountNumber)

        val savedLinkedAccount = linkedAccountRepository.save(
            LinkedAccount(
                bank = dto.bankType,
                linkedAccountNumber = dto.linkedAccountNumber,
                holder = dto.holder,
                phoneNumber = dto.phoneNumber,
                account = account,
            )
        )

        //send Message
        sendMessageWithAuthenticationNumberBy(phoneNumber = dto.phoneNumber)
    }

    override fun checkHolderHasAccountBy(authenticationNumber: String) {
        // redis 혹은 데이터베이스에서 해당 값이 맞는지 판단
    }
}