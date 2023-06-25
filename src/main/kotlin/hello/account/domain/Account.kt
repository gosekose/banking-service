package hello.account.domain

import hello.member.domain.Member
import hello.utils.BaseEntity
import jakarta.persistence.*

@Entity
class Account (

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    var amount: Long = 0L,

    @Id
    @Column(name = "account_id")
    val accountNumber: String = generateAccountNumber(member.id),

    @Enumerated(value = EnumType.STRING)
    var accountStatus: AccountStatus = AccountStatus.NOT_CERTIFIED,
) : BaseEntity() {

    fun putAmount(amount: Long) {
        this.amount += amount
    }

    fun withdrawAmount(amount: Long) {
        this.amount -= amount
    }

    companion object {
        fun generateAccountNumber(memberId: Long?): String {
            if (memberId == null) throw IllegalArgumentException()
            val part1 = memberId / 1000
            val part2 = memberId % 1000
            return String.format("001-%06d-%03d", part1, part2)
        }
    }

    fun updateAccountStatus(accountStatus: AccountStatus) {
        this.accountStatus = accountStatus
    }
}

enum class AccountStatus {
    NOT_CERTIFIED,
    CERTIFIED,
    DORMANT // 배치로 작업
}