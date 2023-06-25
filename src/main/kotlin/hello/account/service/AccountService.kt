package hello.account.service

import hello.account.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService (
    private val accountRepository: AccountRepository,
) {


}