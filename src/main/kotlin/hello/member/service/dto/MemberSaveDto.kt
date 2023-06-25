package hello.member.service.dto

import org.hibernate.validator.constraints.Length

data class MemberSaveDto (
    @Length(min = 5, max = 100)
    val email: String,
    @Length(min = 7, max = 20)
    val password: String
) {

}