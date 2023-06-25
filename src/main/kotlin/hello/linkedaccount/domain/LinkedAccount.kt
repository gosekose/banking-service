package hello.linkedaccount.domain

import hello.account.domain.Account
import hello.utils.BaseEntity
import jakarta.persistence.*

@Entity
class LinkedAccount (
    val bank: BankType,

    val linkedAccountNumber: String,

    var holder: String,

    var phoneNumber: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    val account: Account,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity() {

    fun updatePhoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    fun updateHolder(holder: String) {
        this.holder = holder
    }
}

enum class BankType {
    SHINHAN,
    NH,
    KB
}
