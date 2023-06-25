package hello.linkedaccount.service

import hello.linkedaccount.service.dto.LinkedAccountSaveDto
import org.springframework.stereotype.Service

@Service
interface LinkedAccountService {

    fun saveLinkedAccount(dto: LinkedAccountSaveDto)

    fun sendMessageWithAuthenticationNumberBy(phoneNumber: String)

    fun checkHolderHasAccountBy(authenticationNumber: String)
}