package hello.member.domain

import hello.utils.BaseEntity
import jakarta.persistence.*
import java.lang.IllegalArgumentException

@Entity
class Member constructor(
    val email: String,
    var password: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null,
) : BaseEntity() {


    init {
        if (email.isBlank() || password.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    fun updatePassword(password: String) {
        this.password = password
    }
}