package hello.linkedaccount.service.dto

import hello.linkedaccount.domain.BankType
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull

data class LinkedAccountSaveDto(
    @NotNull
    val bankType: BankType,

    @NotNull
    @Length(min = 1, max = 100)
    val linkedAccountNumber: String,

    @NotNull
    @Length(min = 1, max = 100)
    val holder: String,

    @NotNull
    @Length(min = 5, max = 12)
    val phoneNumber: String,

    val accountNumber: String
) {
}