package hello.member.service

import hello.member.domain.Member
import hello.member.repository.MemberRepository
import hello.member.service.dto.MemberSaveDto
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun saveMember(dto: MemberSaveDto): Long {
        if (memberRepository.findMemberByEmail(dto.email) == null) {
            val savedMember = memberRepository.save(Member(email = dto.email, password = dto.password))
            return savedMember.id ?: throw IllegalStateException("Saved member should have an id.")
        }

        throw IllegalArgumentException()
    }
}