package hello.linkedaccount.repository

import hello.linkedaccount.domain.LinkedAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkedAccountRepository : JpaRepository<LinkedAccount, Long> {
}